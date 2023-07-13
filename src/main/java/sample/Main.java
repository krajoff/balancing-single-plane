package sample;

import regular.ImportTable;
import regular.Repository;

public class Main {
    public static void main(String[] args) {
        String filepath = "D:\\JAVA\\TupolangLower2_after_cutted.xls";
        //filepath = "D:\\JAVA\\Test_GeneralCase.xls";
        Repository repository = ImportTable.xls(filepath);

        System.out.println(repository);
    }
}
