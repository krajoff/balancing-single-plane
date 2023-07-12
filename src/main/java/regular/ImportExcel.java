package regular;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import regular.Record;
import regular.Repository;
public class ImportExcel {

    public static Repository xls(String filepath) {
        String mode = null;
        double magnitudeVibration = 0;
        double phaseVibration = 0;
        Complex complexVibration;
        double magnitudeWeight = 0;
        double phaseWeight = 0;
        Complex complexWeight;
        int reference = 0;
        Record.Stage use = Record.Stage.Off;

        Repository rep = new Repository();
        try {
            FileInputStream file = new FileInputStream(filepath);
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);

            int id, cnt;
            for (Row row : sheet) {
                Iterator<Cell> cellIterator
                        = row.cellIterator();
                cnt = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    id = 0;
                    if (cell.getCellType() == CellType.NUMERIC) {
                        System.out.print(cell.getNumericCellValue() + "\t | \t ");
                    } else if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cell.getStringCellValue() + "\t | \t");
                    }

                    if (cnt == 0) {
                        switch (id) {
                            case 0:
                                mode = cell.getStringCellValue();
                                break;
                            case 1:
                                magnitudeVibration = cell.getNumericCellValue();
                                break;
                            case 2:
                                phaseVibration = cell.getNumericCellValue();
                                break;
                            case 3:
                                magnitudeWeight = cell.getNumericCellValue();
                                break;
                            case 4:
                                phaseWeight = cell.getNumericCellValue();
                                break;
                            case 5:
                                reference = (int) cell.getNumericCellValue();
                                break;
                            case 6:
                                if (cell.getNumericCellValue() > 1) {
                                    use = Record.Stage.On;
                                } else {
                                    use = Record.Stage.Off;
                                }
                                break;
                        }
                        cnt++;
                    }
                }
                System.out.println();

                rep.add(new Record(mode, magnitudeVibration, phaseVibration,
                        magnitudeWeight, phaseWeight, reference, use));
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rep;
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
