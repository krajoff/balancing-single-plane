package regular;

public class Record {
    private String mode;
    private double magnitudeVibration;
    private double phaseVibration;
    private Complex complexVibration;
    private double magnitudeWeight;
    private double phaseWeight;
    private Complex complexWeight;
    private int reference;

    public enum Stage {On, Off}

    private Stage stage;

    public Record(String mode,
                  double magnitudeVibration,
                  double phaseVibration,
                  double magnitudeWeight,
                  double phaseWeight,
                  int reference,
                  Stage stage) {
        this.mode = mode;
        this.magnitudeVibration = magnitudeVibration;
        this.phaseVibration = phaseVibration;
        this.complexVibration = Transform.toComplex(
                magnitudeVibration, phaseVibration);
        this.magnitudeWeight = magnitudeWeight;
        this.phaseWeight = phaseWeight;
        this.complexWeight = Transform.toComplex(
                magnitudeWeight, phaseWeight);
        this.reference = reference;
        this.stage = stage;

    }

    Record(double magnitudeVibration,
           double phaseVibration,
           double magnitudeWeight,
           double phaseWeight) {
        this.mode = "None";
        this.reference = -1;
        this.stage = Stage.Off;
    }

    @Override
    public String toString() {
        return "mode='" + mode + '\'' +
                "; mP2P=" + String.format("%.0f", magnitudeVibration) +
                "; pP2P=" + String.format("%.0f", phaseVibration) +
                "; zP2P=" + complexVibration.toString(2) +
                "; mWeight=" + String.format("%.0f", magnitudeWeight) +
                "; pWeight=" + String.format("%.0f", phaseWeight) +
                "; zWeight=" + complexWeight.toString(2) +
                "; ref=" + reference +
                "; stage=" + stage + "\n";
    }

    public Complex getComplexVibration() {
        return complexVibration;
    }

    public Complex getComplexWeight() {
        return complexWeight;
    }

    public String getMode() {
        return mode;
    }

    public double getValueVibration() {
        return magnitudeVibration;
    }

    public double getPhaseVibration() {
        return phaseVibration;
    }

    public double getValueWeight() {
        return magnitudeWeight;
    }

    public double getPhaseWeight() {
        return phaseWeight;
    }

    public int getReference() {
        return reference;
    }

    public Stage getStage() {
        return stage;
    }
}
