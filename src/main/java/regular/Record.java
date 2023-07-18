package regular;

public class Record {
    private int ID;
    static int count;
    private String mode;
    private double magnitudeVibration;
    private double phaseVibration;
    private Complex complexVibration;
    private double magnitudeWeight;
    private double phaseWeight;
    private Complex complexWeight;
    private int reference;
    private double magnitudeTotalWeight;
    private double phaseTotalWeight;
    private Complex complexTotalWeight;
    private double phaseReferenceWeight;
    private double magnitudeTargetWeight;
    private double phaseTargetWeight;
    private Complex complexTargetWeight;
    static int[] sml = new int[]{3, 7, 17};

    public enum Stage {On, Off}

    private Stage stage;

    public Record(String mode,
                  double magnitudeVibration,
                  double phaseVibration,
                  double magnitudeWeight,
                  double phaseWeight,
                  int reference,
                  Stage stage) {
        this.ID = count;
        count++;
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
        this.magnitudeTotalWeight = 0;
        this.phaseTotalWeight = 0;
        this.complexTotalWeight = Transform.toComplex(
                magnitudeTotalWeight, phaseTotalWeight);
        this.phaseReferenceWeight = -1;
        this.magnitudeTargetWeight = -1;
        this.phaseTargetWeight = -1;
        this.complexTargetWeight = Transform.toComplex(
                magnitudeTargetWeight, phaseTargetWeight);
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

    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "| " + printColumn(sml[0], String.valueOf(ID)) +
                printColumn(sml[1], String.valueOf(mode)) +
                printColumn(sml[1], String.format("%.0f", magnitudeVibration)) +
                printColumn(sml[1], String.format("%.0f", phaseVibration)) +
                printColumn(sml[2], complexVibration.toString(2)) +
                printColumn(sml[1], String.format("%.0f", magnitudeWeight)) +
                printColumn(sml[1], String.format("%.0f", phaseWeight)) +
                printColumn(sml[2], complexWeight.toString(2)) +
                printColumn(sml[0], String.valueOf(reference)) +
                printColumn(sml[1], String.format("%.0f", magnitudeTotalWeight)) +
                printColumn(sml[1], String.format("%.0f", phaseTotalWeight)) +
                printColumn(sml[2], complexTotalWeight.toString(2)) +
                printColumn(sml[0], String.valueOf(stage));
    }

    public String printAllData() {
        return this +
                printColumn(sml[1], String.format("%.0f", magnitudeTargetWeight)) +
                printColumn(sml[1], String.format("%.0f", phaseTargetWeight)) +
                printColumn(sml[2], complexTargetWeight.toString(2));
    }

    private String printColumn(int n, String column) {
        return " ".repeat(n - column.length()) + column + " | ";
    }

    public void setMagnitudeTotalWeight(double magnitudeTotalWeight) {
        this.magnitudeTotalWeight = magnitudeTotalWeight;
    }

    public void setPhaseTotalWeight(double phaseTotalWeight) {
        this.phaseTotalWeight = phaseTotalWeight;
    }

    public void setComplexTotalWeight(Complex complexTotalWeight) {
        this.complexTotalWeight = complexTotalWeight;
    }

    public void setPhaseReferenceWeight(double phaseReferenceWeight) {
        this.phaseReferenceWeight = phaseReferenceWeight;
    }

    public void setComplexTargetWeight(Complex complexTargetWeight) {
        this.complexTargetWeight = complexTargetWeight;
    }

    public void setMagnitudeTargetWeight(double magnitudeTargetWeight) {
        this.magnitudeTargetWeight = magnitudeTargetWeight;
    }

    public void setPhaseTargetWeight(double phaseTargetWeight) {
        this.phaseTargetWeight = phaseTargetWeight;
    }

    public Complex getComplexTotalWeight() {
        return complexTotalWeight;
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

    public int getReference() {
        return reference;
    }

    public Stage getStage() {
        return stage;
    }

    public double getPhaseReferenceWeight() {
        return phaseReferenceWeight;
    }
}
