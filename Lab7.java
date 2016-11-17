package lab.pkg7;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import java.nio.file.*;
import java.util.Scanner; 
import java.io.*;
/**
 *
 * @author Shehryar
 */
public class Lab7 {


    private static void showmenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  ToyStopService tsService = new ToyStopService();
    public void init(){
        
        tsService.initEmployees();
        tsService.initStores();
        tsService.initToys();
        System.out.println("Init complete");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        ToyStopInventoryManagementSystem tsims = new ToyStopInventoryManagementSystem();
        Path path = Paths.get("employee.ser");

if (Files.exists(path)) {
  while(true){
    tsims.showMenu();
    int val = scan.nextInt();
     ArrayList<Employee> employees = new ArrayList<>();
      ArrayList<Store> stores = new ArrayList<>();
    if(val==1){
        
    }else if(val==2){
   
     Store myStore = new Store();
            myStore.setUID(Util.getSaltNum(-1));
            myStore.addRandomEmployees(employees);
            stores.add(myStore);
            myStore.setAddress(Util.getSaltAlphaNumString());
            myStore.setContactNo("+92"+Util.getSaltNum(9));
            Email storeEmail = new Email();
            storeEmail.setEmailAddress(myStore.getUID()+"@toystop.org");
            myStore.setEmail(storeEmail);
    }else if(val==3){
       
    Employee myEmployee = new Employee();
            myEmployee.setUID(5777);
            myEmployee.setRandomName();
            myEmployee.setEmail(myEmployee.getName()+"@toystop.org");
             
            employees.add(myEmployee);
    }else if(val==4){
    
    }else if(val==0){
    break;
    }
    
    
  }
}else{
        tsims.init();
     tsims.printAll();
}
        //load previous data
        //tsims.loadData();
        
        //tsims.showMenu();
        
        
    }

    private void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void showMenu() {
        System.out.println("Welcome to Toy Stop Inventory Management System");
        System.out.println("Enter 1 to show all data");
        System.out.println("Enter 2 to add a new Store");
        System.out.println("Enter 3 to add a new Employee");
        System.out.println("Enter 4 to add a new Toy");
        System.out.println("Enter 0 to save state");
    }

    private void printAll() {
        System.out.println(this.tsService.stores);
    }
     private void prints() throws ClassNotFoundException {
         ArrayList<Employee> employees = new ArrayList<>();
    ArrayList<Store> stores = new ArrayList<>();
       try {
           Employee e = new Employee();
         FileInputStream fileIn = new FileInputStream("employee.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e =(Employee)  in.readObject();
         employees.add(e);
         in.close();
         fileIn.close();
          Store myStore = new Store();
        fileIn = new FileInputStream("store.ser");
        in = new ObjectInputStream(fileIn);
         e =(Employee)  in.readObject();
         stores.add(myStore);
         in.close();
         fileIn.close();
         
      }catch(IOException i) {
         i.printStackTrace();
         return;
      }
     }
}
