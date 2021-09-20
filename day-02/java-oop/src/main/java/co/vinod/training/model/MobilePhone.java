package co.vinod.training.model;

public class MobilePhone extends Product{

    private String dimension;
    private String batteryCapacity;

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "dimension='" + dimension + '\'' +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", Product details = " + super.toString() +
                '}';
    }
}
