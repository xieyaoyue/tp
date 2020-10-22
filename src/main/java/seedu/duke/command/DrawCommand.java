package seedu.duke.command;

import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.XDDFChartAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Item;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TreeMap;

public class DrawCommand extends Command {
    @Override
    public void execute(SpendingList spendingList, Ui ui) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet0 = workbook.createSheet("Sheet 0");
        XSSFSheet sheet1 = workbook.createSheet("Sheet 1");

        TreeMap<String, Double> categoryMap = getCategoryMap(spendingList);
        String[] categories = categoryMap.keySet().toArray(new String[0]);
        Double[] amounts = categoryMap.values().toArray(new Double[0]);
        DrawChart(sheet0, categories, amounts, 0, 0, 10, 12);

        FileOutputStream fileOut = new FileOutputStream("Charts.xlsx");
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
    }

    private TreeMap<String, Double> getCategoryMap(SpendingList spendingList) {
        TreeMap<String, Double> map = new TreeMap<>();
        for (int i = 0; i < spendingList.getListSize(); i++) {
            Item item = spendingList.getItem(i);
            if (map.containsKey(item.getCategory())) {
                map.replace(item.getCategory(), map.get(item.getCategory()) + item.getAmount());
            } else {
                map.put(item.getCategory(), item.getAmount());
            }
        }
        return map;
    }

    private void DrawChart(XSSFSheet sheet, String[] category, Double[] values, int x1, int y1, int x2, int y2) {
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, x1, y1, x2, y2);
        XSSFChart chart = drawing.createChart(anchor);
        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(org.apache.poi.xddf.usermodel.chart.LegendPosition.TOP_RIGHT);
        XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromArray(category);
        XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromArray(values);
        XDDFChartData chartData = chart.createData(ChartTypes.PIE, null, null);
        chartData.addSeries(cat, val);
        chart.plot(chartData);
    }

    private void DrawChart(XSSFSheet sheet, Integer[] category, Double[] values, int x1, int y1, int x2, int y2) {
        XSSFDrawing drawing = sheet.createDrawingPatriarch();
        XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, x1, y1, x2, y2);
        XSSFChart chart = drawing.createChart(anchor);
        XDDFChartLegend legend = chart.getOrAddLegend();
        legend.setPosition(org.apache.poi.xddf.usermodel.chart.LegendPosition.TOP_RIGHT);
        XDDFDataSource<Integer> cat = XDDFDataSourcesFactory.fromArray(category);
        XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromArray(values);
        XDDFChartAxis chartAxis = chart.createCategoryAxis(AxisPosition.LEFT);
        XDDFValueAxis valueAxis = chart.createValueAxis(AxisPosition.BOTTOM);
        XDDFChartData chartData = chart.createData(ChartTypes.LINE, chartAxis, valueAxis);
        chartData.addSeries(cat, val);
        chart.plot(chartData);
    }
}
