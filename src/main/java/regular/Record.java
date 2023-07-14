package  regular;

public class Record {
    private String mode;
    private double magnitudeVibration;
    private double phaseVibration;
    private Complex complexVibration;
    private double magnitudeWeight;
    private double phaseWeight;
    private Complex complexWeight;
    private int reference;
    private double totalMagnitudeWeight;
    private double totalPhaseWeight;
    private Complex totalComplexWeight;

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
        this.totalMagnitudeWeight = 0;
        this.totalPhaseWeight = 0;
        this.totalComplexWeight = Transform.toComplex(
                totalMagnitudeWeight, totalPhaseWeight);
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

//    @Override
//    public String toString() {
//        return "mode='" + mode + '\'' +
//                "; mP2P=" + String.format("%.0f", magnitudeVibration) +
//                "; pP2P=" + String.format("%.0f", phaseVibration) +
//                "; zP2P=" + complexVibration.toString(2) +
//                "; mWeight=" + String.format("%.0f", magnitudeWeight) +
//                "; pWeight=" + String.format("%.0f", phaseWeight) +
//                "; zWeight=" + complexWeight.toString(2) +
//                "; ref=" + reference +
//                "; stage=" + stage + "\n";
//    }
    @Override
    public String toString() {
        return "| " + " ".repeat(10-mode.length()) + mode +" | " +
                " ".repeat(7-String.format("%.0f", magnitudeVibration).length()) +
                String.format("%.0f", magnitudeVibration)
                + " | " +
                " ".repeat(7-String.format("%.0f", phaseVibration).length()) +
                String.format("%.0f", phaseVibration) + " | " +
                " ".repeat(17-complexVibration.toString(2).length()) +
                complexVibration.toString(2) + " | " +
                " ".repeat(7-String.format("%.0f", magnitudeWeight).length()) +
                String.format("%.0f", magnitudeWeight) + " | " +
                " ".repeat(7-String.format("%.0f", phaseWeight).length()) +
                String.format("%.0f", phaseWeight) + " | " +
                " ".repeat(18-complexWeight.toString(2).length()) +
                complexWeight.toString(2) + " | " +
                " ".repeat(3-String.valueOf(reference).length()) +
                reference + " | " +
                " ".repeat(3-String.valueOf(stage).length()) +
                stage + " | " + "\n";

    }

    public void setTotalMagnitudeWeight(double totalMagnitudeWeight) {
        this.totalMagnitudeWeight = totalMagnitudeWeight;
    }

    public void setTotalPhaseWeight(double totalPhaseWeight) {
        this.totalPhaseWeight = totalPhaseWeight;
    }

    public void setTotalComplexWeight(Complex totalComplexWeight) {
        this.totalComplexWeight = totalComplexWeight;
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
