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
    private double totalMagnitudeWeight;
    private double totalPhaseWeight;
    private Complex totalComplexWeight;
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

    public int[] getSml() {
        return sml;
    }

    public int getId() {
        return ID;
    }

    @Override
    public String toString() {
        return  "| " + printColumn(sml[0], String.valueOf(ID)) +
                printColumn(sml[1], String.valueOf(mode)) +
                printColumn(sml[1], String.format("%.0f", magnitudeVibration)) +
                printColumn(sml[1], String.format("%.0f", phaseVibration)) +
                printColumn(sml[2], complexVibration.toString(2)) +
                printColumn(sml[1], String.format("%.0f", magnitudeWeight)) +
                printColumn(sml[1], String.format("%.0f", phaseWeight)) +
                printColumn(sml[2], complexWeight.toString(2)) +
                printColumn(sml[0], String.valueOf(reference)) +
                printColumn(sml[1], String.format("%.0f", totalMagnitudeWeight)) +
                printColumn(sml[1], String.format("%.0f", totalPhaseWeight)) +
                printColumn(sml[2], totalComplexWeight.toString(2)) +
                printColumn(sml[0], String.valueOf(stage)) + "\n";
    }

    private String printColumn (int n, String column){
        return  " ".repeat(n - column.length()) + column + " | ";
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
