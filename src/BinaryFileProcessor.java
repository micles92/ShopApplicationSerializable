import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 11.12.2015.
 */
public class BinaryFileProcessor implements  FileProcessor{

    @Override
    public void save(String fileName, List<Product> products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for(Product x: products){
                objectOutputStream.writeObject(x);
            }
            objectOutputStream.writeObject(null);
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> load(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<Product>products = new ArrayList<>();

        try {
            Product p = (Product) objectInputStream.readObject();
            while (p != null) {
                products.add(p);
                p =(Product) objectInputStream.readObject();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }
}
