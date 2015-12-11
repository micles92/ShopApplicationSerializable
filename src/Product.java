import java.io.Serializable;

/**
 * Created by Michał on 06.12.2015.
 */
public abstract class Product implements Serializable{

    protected String name;
    protected double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void discount();

}
