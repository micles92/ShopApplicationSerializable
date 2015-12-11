/**
 * Created by Michał on 06.12.2015.
 */
public class Computer extends Product{

    private int ram;
    private double CPU;
    private final static String PRODUCTID = "C";

    public Computer(String name, double price, int ram, double CPU){

        super(name, price);
        this.ram = ram;
        this.CPU = CPU;
    }


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getCPU() {
        return CPU;
    }

    public void setCPU(double CPU) {
        this.CPU = CPU;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (Double.compare(computer.CPU, CPU) != 0) return false;
        if (Double.compare(computer.price, price) != 0) return false;
        if (ram != computer.ram) return false;
        if (name != null ? !name.equals(computer.name) : computer.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ram;
        temp = Double.doubleToLongBits(CPU);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        String result;
        result = PRODUCTID + "," + name + "," + price + "," + ram + "," + CPU;

        return result;
    }

    public void discount(){
        System.out.println("Dla komputerow -10%");
    }
}
