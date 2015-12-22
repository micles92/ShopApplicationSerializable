import java.io.IOException;
import java.util.List;

/**
 * Created by Michał on 21.12.2015.
 */
public interface DataProcessor {
    void save(String dataSourceName, List<Product> products);
    List<Product> load(String dataSourceName) throws Exception;
}
