package sample;

import regular.ImportExcel;
import regular.Record;
import regular.Repository;

public class Main {
    public static void main(String[] args) {
        Repository rep = new Repository();
        rep.add(new Record("100%U",
                236, 163,
                0,0,
                -1, Record.Stage.Off));
        rep.add(new Record("100%U",
                205, 182,
                19.6,157.5,
                1, Record.Stage.On));
        System.out.println(rep);


        Repository pp = ImportExcel.xls("D:\\JAVA\\TupolangLower2_after_cutted.xls");
        System.out.println(pp);
    }

}
