package lab.pkg7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Fahad Satti
 */
public class ToyStopInventoryManagementSystem {
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
        
        
        ToyStopInventoryManagementSystem tsims = new ToyStopInventoryManagementSystem();
        tsims.init();
        
        //load previous data
        //tsims.loadData();
        
        //tsims.showMenu();
        tsims.printAll();
        
    }

    private void loadData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void showMenu() {
        System.out.println("Welcome to Toy Stop Inventory Management System");
        System.out.println("Enter 1 to show all data");
        System.out.println("Enter 2 to add a new Store");
        System.out.println("Enter 3 to add a new Employee");
        System.out.println("Enter 4 to add a new Toy");
        System.out.println("Enter 0 to save state");
    }

    void printAll() {
        System.out.println(this.tsService.stores);
    }
    
}
