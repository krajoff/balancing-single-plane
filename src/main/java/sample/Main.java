package sample;

import regular.*;

public class Main {
    public static void main(String[] args) {
        String partpath = ".\\src\\main\\java\\data\\";
        String filepath = "TupolangLower2_after_cutted.xls";
        //filepath = "Test_GeneralCase.xls";
        Repository repository = ImportTable.xls(partpath + filepath);
        Weight.total(repository);
        Weight.target(repository);
        repository.printRawTable();
        repository.printWholeTable();
    }
}
