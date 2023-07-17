package regular;

public class TargetWeight {
    public Complex calculation (Record first, Record second) {
        double mSen, pSen;
        Complex deltaVibration = second.getComplexVibration().minus(first.getComplexVibration());
        Complex deltaWeight = second.getComplexWeight().minus(first.getComplexWeight());
        Complex sensitivity = deltaVibration.divides(deltaWeight);
        mSen = sensitivity.abs();
        pSen = Math.toDegrees(sensitivity.phase());
        Complex targetWeight = first.getComplexVibration().
                minus(deltaWeight.times(first.getComplexVibration()).
                divides(deltaVibration));
        return targetWeight;
    }
}
