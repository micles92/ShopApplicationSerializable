import java.io.IOException;
import java.util.*;

/**
 * Created by Michał on 06.12.2015.
 */
public class GenericShop {
    private List<Product> products;
    private DataProcessor dataProcessor;
    private Map<String, Integer>wareHouseState;

    public GenericShop(DataProcessor dataProcessor) {
        products = new ArrayList<>();
        wareHouseState = new HashMap<>();
        //fileProcessor = new TextFileProcessor();
        this.dataProcessor = dataProcessor;

    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void removeProduct(String name){
        Iterator<Product> iterator = products.iterator();

        while(iterator.hasNext()){
            Product tmp = iterator.next();
            if(tmp.getName().equals(name)){
                iterator.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "GenericShop{" +
                "products=" + products +
                '}';
    }

    public void displayDiscount(){
        for(Product tmp: products){
            tmp.discount();
        }
    }

    public void save(){
        dataProcessor.save("test", products);
    }

    public void load() throws Exception {
       products =  dataProcessor.load("test");
    }

}
