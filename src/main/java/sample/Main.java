package sample;

import regular.ImportTable;
import regular.Repository;

public class Main {
    public static void main(String[] args) {
        String partpath = ".\\src\\main\\java\\sample\\";
        String filepath = "TupolangLower2_after_cutted.xls";
        //filepath = "Test_GeneralCase.xls";
        Repository repository = ImportTable.xls(partpath + filepath);
        repository.printTable();
        repository.getRepositoryUniqueMode("100%n").printTable();
    }
}
