/**
 * Created by Michał on 06.12.2015.
 */
public class Phone extends Product{

    private double battery;
    private double screensize;
    private final static String PRODUCTID = "P";

    public Phone(String name, double price, double battery, double screensize) {
        super(name, price);
        this.battery = battery;
        this.screensize = screensize;
    }


    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public double getScreensize() {
        return screensize;
    }

    public void setScreensize(double screensize) {
        this.screensize = screensize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (Double.compare(phone.battery, battery) != 0) return false;
        if (Double.compare(phone.price, price) != 0) return false;
        if (Double.compare(phone.screensize, screensize) != 0) return false;
        if (name != null ? !name.equals(phone.name) : phone.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(battery);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(screensize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = PRODUCTID + "," + name + "," + price + "," + battery + "," + screensize;
        return result;
    }
    public void discount(){
        System.out.println("Dla telefonow -10%");
    }
}

