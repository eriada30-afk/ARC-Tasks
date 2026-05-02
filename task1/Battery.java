package task1;

public class Battery {

    private String status;
    private double voltage;

    public Battery(String status, double voltage) {
        this.status = status;
        this.voltage = voltage;
    }

    public String getStatus() {
        return this.status;
    }

    public double getVoltage() {
        return this.voltage;
    }

    public String toString() {
        return this.status + "/" + this.voltage + "V";
    }

}