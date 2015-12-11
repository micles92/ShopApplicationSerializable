import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
            objectOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> load(String fileName) throws IOException {
        return null;
    }
}
