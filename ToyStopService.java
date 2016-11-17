
package lab.pkg7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
/**
 *
 * @author Fahad Satti
 */
public class ToyStopService {
    ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Store> stores = new ArrayList<>();
        
    public void initEmployees(){
        //Create a List of first 200 Employees
        
        try{
            FileOutputStream fileOut =
         new FileOutputStream("employee.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for(int i=0; i<200; i++){
            Employee myEmployee = new Employee();
            myEmployee.setUID(i);
            myEmployee.setRandomName();
            myEmployee.setEmail(myEmployee.getName()+"@toystop.org");
             out.writeObject(myEmployee);
            employees.add(myEmployee);
           // System.out.printf("Serialized asubc"+myEmployee.getUID()+"\n");
        }
          out.close();
         fileOut.close();
        }catch(IOException i2) {
         i2.printStackTrace();
      }
        
    }
    
    public void initStores(){
        //Create a List of Stores in a region
          try{
            FileOutputStream fileOut =
         new FileOutputStream("store.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for(int i=0; i<100; i++){
            Store myStore = new Store();
            myStore.setUID(Util.getSaltNum(-1));
            myStore.addRandomEmployees(employees);
            stores.add(myStore);
            myStore.setAddress(Util.getSaltAlphaNumString());
            myStore.setContactNo("+92"+Util.getSaltNum(9));
            Email storeEmail = new Email();
            storeEmail.setEmailAddress(myStore.getUID()+"@toystop.org");
            myStore.setEmail(storeEmail);
            out.writeObject(storeEmail);
        }
         out.close();
         fileOut.close();
        }catch(IOException i2) {
         i2.printStackTrace();
      }
    }
    
    public void initToys(){
        //Add Toys in random stores
        
           try{
            FileOutputStream fileOut =  new FileOutputStream("toy.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
        for(int i=0; i<200000; i++){
            Toy newToy = new Toy();
            newToy.setUID(Util.getSaltNum(-1));
            newToy.setMinAge(Util.getSaltNum(1));
            newToy.setMaxAge(Util.getSaltNum(18));
            newToy.setPrice(Util.getSaltNum(1000));
            newToy.setName(Util.getSaltAlphaString());
            newToy.setAddedOn(LocalDateTime.now());
            
            Random randStore = new Random();
            int index = randStore.nextInt(stores.size());
            Store selectedStore = (Store)stores.get(index);
            selectedStore.addToy(newToy);
             out.writeObject(newToy);
        }
        out.close();
         fileOut.close();
           }catch(IOException i2) {
         i2.printStackTrace();
      }
    }
    //Only creates a new employee and returns the UID
    public int addEmployee(){
            Employee myEmployee = new Employee();
            
            myEmployee.setRandomName();
            myEmployee.setEmail(myEmployee.getName()+"@toystop.org");
            myEmployee.setUID(employees.size()+1);
            employees.add(myEmployee);
            return myEmployee.getUID();
    }
    
    //Creates a new store
    public int addStore(){
            Store myStore = new Store();
            myStore.setUID(Util.getSaltNum(-1));
            //This will assign any new employees or the ones remaining after previous store insertions.
            myStore.addRandomEmployees(employees);
            
            myStore.setAddress(Util.getSaltAlphaNumString());
            myStore.setContactNo("+92"+Util.getSaltNum(9));
            Email storeEmail = new Email();
            storeEmail.setEmailAddress(myStore.getUID()+"@toystop.org");
            myStore.setEmail(storeEmail);
            stores.add(myStore);
            return myStore.getUID();
    }
}
