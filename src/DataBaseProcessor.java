import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Michał on 21.12.2015.
 */
public class DataBaseProcessor implements DataProcessor {
   private static  final String URL = "jdbc:mysql://localhost:3306/shop";
    private static  final String USER = "root";
    private static  final String PASSWORD = "";
    private Connection connection;

    public DataBaseProcessor() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("nie mozna zaladowac drivera MySQL");
        }
    }


    public  void connect() throws SQLException {
        connection =  DriverManager.getConnection(URL,USER, PASSWORD);
    }

    @Override
    public void save(String dataSourceName, List<Product> products) {
        try {
            connect();
            for(Product x: products){
                if(x instanceof Phone){
                    Phone tmp = (Phone) x;
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO phone(name,price,battery,screensize) VALUES(?, ?, ?, ?)");
                    statement.setString(1,tmp.getName() );
                    statement.setDouble(2,tmp.getPrice() );
                    statement.setDouble(3,tmp.getBattery() );
                    statement.setDouble(4,tmp.getScreensize() );
                    statement.executeUpdate();
                }

                if(x instanceof Computer){
                    Computer tmp = (Computer) x;
                    PreparedStatement statement = connection.prepareStatement("INSERT INTO computer(name,price,ram,CPU) VALUES(?, ?, ?, ?)");
                    statement.setString(1, tmp.getName());
                    statement.setDouble(2, tmp.getPrice());
                    statement.setDouble(3, tmp.getRam());
                    statement.setDouble(4, tmp.getCPU());
                    statement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Zapis sie nie powiodl");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Product> load(String dataSourceName) throws Exception {
        return null;  //resultset
    }
}
