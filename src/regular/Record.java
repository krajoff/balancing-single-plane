package regular;

public class Record {
    private String mode;
    private double valueVibration;
    private double phaseVibration;
    private Complex complexVibration;
    private double valueWeight;
    private double phaseWeight;
    private Complex complexWeight;
    private int reference;

    public enum Stage {On, Off}

    private Stage stage;

    public Record(String mode,
                  double valueVibration,
                  double phaseVibration,
                  double valueWeight,
                  double phaseWeight,
                  int reference,
                  Stage stage) {
        this.mode = mode;
        this.valueVibration = valueVibration;
        this.phaseVibration = phaseVibration;
        this.complexVibration = Transform.toComplex(valueVibration, phaseVibration);
        this.valueWeight = valueWeight;
        this.phaseWeight = phaseWeight;
        this.complexWeight = Transform.toComplex(valueWeight, phaseWeight);
        this.reference = reference;
        this.stage = stage;

    }

    Record(double valueVibration,
           double phaseVibration,
           double valueWeight,
           double phaseWeight) {
        this.mode = "None";
        this.reference = -1;
        this.stage = Stage.Off;
    }

    @Override
    public String toString() {
        return "mode='" + mode + '\'' +
                "; vP2P=" + String.format("%.0f", valueVibration) +
                "; pP2P=" + String.format("%.0f", phaseVibration) +
                "; zP2P=" + complexVibration.toString(2) +
                "; vWeight=" + String.format("%.0f", valueWeight) +
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
        return valueVibration;
    }

    public double getPhaseVibration() {
        return phaseVibration;
    }

    public double getValueWeight() {
        return valueWeight;
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
