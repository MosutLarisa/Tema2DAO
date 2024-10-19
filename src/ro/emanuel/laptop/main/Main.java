package ro.emanuel.laptop.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.laptop.dao.LaptopDAO;
import ro.emanuel.laptop.pojo.Laptop;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//afisam
        List<Laptop> laptops = LaptopDAO.getLaptops();
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        
        System.out.println("=====================");	        
        
        //afisam dupa ID
        Laptop laptop = LaptopDAO.getById(2);
        System.out.println("Laptop gasit dupa ID: " + laptop);
        
        System.out.println("=====================");
        
        //create
        Laptop newLaptop = new Laptop("HP", "Spectre x360", 8);
        int rowsInserted = LaptopDAO.createLaptop(newLaptop);
        System.out.println( rowsInserted);
        
        System.out.println("=====================");

        //update
        Laptop laptopToUpdate = new Laptop(4, "Dell", "XPS 15", 16);
        int rowsUpdated = LaptopDAO.updateLaptop(laptopToUpdate);
        System.out.println(rowsUpdated);
        laptop = LaptopDAO.getById(4);
        System.out.println( laptop);
        
        System.out.println("=====================");

        //delete
        int rowsDeleted = LaptopDAO.deleteLaptop(3);
        System.out.println(rowsDeleted);
        laptop = LaptopDAO.getById(3);
        System.out.println(laptop);

	
}


}
