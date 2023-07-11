package regular;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcel {

    public static void xls(String filepath) {
        try {
            FileInputStream file = new FileInputStream(filepath);
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Iterator<Cell> cellIterator
                        = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t | \t ");
                    } else if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t | \t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void xlsx(String filepath) {
        try {
            FileInputStream file = new FileInputStream(filepath);
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Iterator<Cell> cellIterator
                        = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t | \t ");
                    } else if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t | \t");
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
