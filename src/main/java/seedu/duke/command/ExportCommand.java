package seedu.duke.command;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Item;
import seedu.duke.exceptions.InvalidCommandException;

import java.io.FileOutputStream;

public class ExportCommand extends Command {
    private String filePath;

    public ExportCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException {
        exportToExcel(spendingList);
        ui.printExportMessage();
    }

    private void exportToExcel(SpendingList list) throws InvalidCommandException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet0");
        HSSFRow row = sheet.createRow(0);
        HSSFCell[] cells = new HSSFCell[5];
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);
        for (int i = 0; i < 5; i++) {
            cells[i] = row.createCell(i);
            cells[i].setCellStyle(cellStyle);
        }
        cells[0].setCellValue("Description");
        cells[1].setCellValue("Currency");
        cells[2].setCellValue("Amount");
        cells[3].setCellValue("Date");
        cells[4].setCellValue("Category");
        for (int i = 0; i < list.getListSize(); i++) {
            row = sheet.createRow(i + 1);
            Item item = list.getItem(i);
            row.createCell(0).setCellValue(item.getDescription());
            row.createCell(1).setCellValue(item.getSymbol());
            row.createCell(2).setCellValue(item.getAmount());
            row.createCell(3).setCellValue(item.getDate());
            row.createCell(4).setCellValue(item.getCategory());
        }
        try {
            FileOutputStream output = new FileOutputStream("records.xls");
            workbook.write(output);
            output.flush();
        } catch (Exception e) {
            throw new InvalidCommandException();
        }
    }
}
