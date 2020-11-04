package seedu.duke.command;

import seedu.duke.data.RepaymentList;
import seedu.duke.data.SpendingList;
import seedu.duke.data.Item;
import seedu.duke.utilities.FileExplorer;
import seedu.duke.ui.Ui;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//@@author Wu-Haitao
public class ExportCommand extends Command {
    private String filePath;
    private final FileExplorer fileExplorer;

    public ExportCommand(String filePath) {
        this.filePath = filePath + "Records.xlsx";
        fileExplorer = new FileExplorer(this.filePath);
    }

    @Override
    public void execute(SpendingList spendingList, RepaymentList repaymentList, Ui ui) throws IOException {
        exportToExcel(spendingList);
        try {
            fileExplorer.openFile();
        } catch (IOException e) {
            ui.printOpenFileFailedMessage();
        }
        ui.printExportMessage();
    }

    private void exportToExcel(SpendingList list) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet0");
        sheet.setDefaultColumnWidth(15);
        Row row = sheet.createRow(0);
        printHeaders(workbook, row);
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
            FileOutputStream output = new FileOutputStream(filePath);
            workbook.write(output);
            output.flush();
            output.close();
        } catch (Exception e) {
            throw new IOException();
        }
    }

    private void printHeaders(Workbook workbook, Row row) {
        Cell[] cells = new Cell[5];
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
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
    }
}
