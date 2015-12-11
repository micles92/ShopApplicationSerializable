import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michał on 06.12.2015.
 */
public class TextFileProcessor implements FileProcessor {
    @Override
    public void save(String fileName, List<Product>products) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for(Product tmp: products){
                printWriter.println(tmp);
            }
            printWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> load(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Product>products = new ArrayList<>();
        String textLine = bufferedReader.readLine();
        do {
            String tmp[] = textLine.split(",");
            if(tmp[0].equals("C")){
                products.add(new Computer(tmp[1],Double.parseDouble(tmp[2]), Integer.parseInt(tmp[3]) , Double.parseDouble(tmp[4])));
            } else {
                if(tmp[0].equals("P")){
                    products.add(new Phone(tmp[1],Double.parseDouble(tmp[2]),Double.parseDouble(tmp[3]),Double.parseDouble(tmp[4])));
                }
            }

          //  System.out.println(textLine);

            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();
        return products;
    }
}
