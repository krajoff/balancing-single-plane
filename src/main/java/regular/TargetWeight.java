package regular;

public class TargetWeight {
    public static Complex calculation (Record first, Record second) {
        double mSen, pSen;
        Complex zVib1 = first.getComplexVibration();
        Complex zVib2 = second.getComplexVibration();
        Complex zWgt1 = first.getComplexTotalWeight();
        Complex zWgt2 = second.getComplexTotalWeight();

        Complex dVib = zVib2.minus(zVib1);
        Complex dWgt = zWgt2.minus(zWgt1);
        Complex sen = dVib.divides(dWgt);
        mSen = sen.abs();
        pSen = Math.toDegrees(sen.phase());
        Complex foo1 = dWgt.times(zVib1);
        Complex foo2 = foo1.divides(dVib);
        return zWgt1.minus(foo2);
    }
}
