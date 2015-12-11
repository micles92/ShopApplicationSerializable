import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Michał on 06.12.2015.
 */
public class Shop {
    private ArrayList<Computer> computers;
    private ArrayList<Phone> phones;

    public Shop() {

        computers = new ArrayList<>();
        phones = new ArrayList<>();
    }



    public void addComputer(Computer computer) {
        computers.add(computer);
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public void deleteComputer(Computer computer){
        computers.remove(computer);

    }

    public void deleteComputer(String name){
        Computer toDelete = null;
        for(Computer tmp: computers){
            if(tmp.getName().equals(name)){
                toDelete = tmp;
            }
        }
        if(toDelete != null){
            computers.remove(toDelete);
        }
    }

    public void deletePhone(Phone phone){
        phones.remove(phone);
    }

    public void deletePhone(String name){  // usuwa ostatni jaki zwrocil
        Iterator<Phone> iterator = phones.iterator();
        while(iterator.hasNext()){
            Phone tmp = iterator.next();
            if(tmp.getName().equals(name)){
                iterator.remove();
            }
        }
    }

    public void displayDiscounts(){
        for(Computer tmp: computers){
            tmp.discount();
        }

        for(Phone tmp: phones){
            tmp.discount();
        }
    }




    public String toString(){
        return phones + " " + computers;
    }
}