package seedu.duke.command;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import seedu.duke.SpendingList;
import seedu.duke.Ui;
import seedu.duke.category.Item;
import seedu.duke.exceptions.InvalidCommandException;
import seedu.duke.exceptions.InvalidMonthException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExportCommand extends Command {
    private String filePath;

    public ExportCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute(SpendingList spendingList, Ui ui) throws InvalidCommandException, IOException, InvalidMonthException {
        exportToExcel(spendingList);
        ui.printExportMessage();
    }

    private void exportToExcel(SpendingList list) throws InvalidCommandException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("sheet0");
        for (int i = 0; i < list.getListSize(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            HSSFCell description = row.createCell(0),
                    amount = row.createCell(1),
                    date = row.createCell(2),
                    category = row.createCell(3);
            Item item = list.getItem(i);
            description.setCellValue(item.getDescription());
            amount.setCellValue(item.getSymbol() + item.getAmount());
            try {
                date.setCellValue(new SimpleDateFormat("yyyy-MM-dd").parse(item.getDate()));
            } catch (ParseException e) {
                throw new InvalidCommandException();
            }
            category.setCellValue(item.getCategory());
        }
        try {
            FileOutputStream output = new FileOutputStream(filePath);
            workbook.write(output);
            output.flush();
        } catch (Exception e) {
            throw new InvalidCommandException();
        }
    }
}
