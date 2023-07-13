package regular;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class ImportTable {
    public static Repository xls(String filepath) {
        String mode = "";
        double magnitudeVibration = 0;
        double phaseVibration = 0;
        double magnitudeWeight = 0;
        double phaseWeight = 0;
        int reference = 0;
        Record.Stage use = Record.Stage.Off;
        Repository rep = new Repository();
        try {
            FileInputStream file = new FileInputStream(filepath);
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int columnPos;
            int rowPos = 0;
            for (Row row : sheet) {
                Iterator<Cell> cellIterator
                        = row.cellIterator();
                columnPos = 0;
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (rowPos != 0) {
                        switch (columnPos) {
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
                    }
                    columnPos++;
                }
                if (rowPos != 0) {
                    rep.add(new Record(mode, magnitudeVibration, phaseVibration,
                            magnitudeWeight, phaseWeight, reference, use));
                }
                rowPos++;
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rep;
    }
}
