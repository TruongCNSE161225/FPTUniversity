
import java.lang.Comparable;

public class Car {

    public String carID;
    public Brand Brand;
    public String color;
    public String frameId;
    public String engineId;

    public Car() {
    }

    public Car(String carID, Brand Brand, String color, String frameId, String engineId) {
        this.carID = carID;
        this.Brand = Brand;
        this.color = color;
        this.frameId = frameId;
        this.engineId = engineId;
    }

    public String getCarID() {
        return carID;
    }

    public Brand getBrand() {
        return Brand;
    }

    public String getColor() {
        return color;
    }

    public String getFrameId() {
        return frameId;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setBrand(Brand Brand) {
        this.Brand = Brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public int comparedTo(Car c) {
        int d = this.Brand.brandName.compareTo(c.Brand.brandName);
        if (d != 0) {
            return d;
        }

        return this.carID.compareTo(c.carID);

    }

    @Override
    public String toString() {
        return "Car ID: " + this.carID + ", brand name: " + this.Brand + ", color: " + this.color + ", frame: " + this.frameId + ", engine: " + this.engineId;
    }

//    public String ScreenString() {
//        return 
//    }

}
