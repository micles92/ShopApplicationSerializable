import java.io.IOException;

/**
 * Created by Michał on 06.12.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        GenericShop obj = new GenericShop(new DataBaseProcessor());


    //        obj.addProduct(new Computer("Asus", 999, 16, 2.7));
    //        obj.addProduct(new Computer("Asus1", 929, 22, 2.7));
    //
    //        obj.addProduct(new Phone("Nokia", 66, 4.5, 5.6));
    //        obj.addProduct(new Phone("Nokia22", 26, 4.3, 3.6));
        obj.addProduct(new Phone("LUMIA", 6, 6.0, 6.0));

//        obj.displayDiscount();
//        //obj.addProduct(new Product("nazwa1", 5.5));
//        System.out.println(obj);
//
//
//    //    obj.displayDiscount();
//        //obj.addProduct(new Product("nazwa1", 5.5));
//        System.out.println(obj);
        obj.save();
       // obj.load();
        System.out.println(obj);

    }
}
