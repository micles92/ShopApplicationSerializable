import java.io.IOException;
import java.util.*;

/**
 * Created by Michał on 06.12.2015.
 */
public class GenericShop {
    private List<Product> products;
    private FileProcessor fileProcessor;
    private Map<String, Integer>wareHouseState;

    public GenericShop(FileProcessor fileProcessor) {
        products = new ArrayList<>();
        wareHouseState = new HashMap<>();
        //fileProcessor = new TextFileProcessor();
        this.fileProcessor = fileProcessor;

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
        fileProcessor.save("test", products);
    }

    public void load() throws IOException {
       products =  fileProcessor.load("test");
    }

}
