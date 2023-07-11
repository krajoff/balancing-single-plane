package sample;
import regular.*;

import regular.Complex;
import regular.Record;
import regular.Repository;
import regular.Transform;

public class Main {
    public static void main(String[] args) {
        Repository rep = new Repository();
        rep.add(new Record("100%n",
                236, 163,
                0,0,
                -1, Record.Stage.Off));
        rep.add(new Record("100%n",
                205, 182,
                19.6,157.5,
                1, Record.Stage.On));
        System.out.println(rep);


    }
}
