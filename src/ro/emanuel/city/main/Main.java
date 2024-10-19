package ro.emanuel.city.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.city.dao.CityDAO;
import ro.emanuel.city.pojo.City;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//afisam
        List<City> cities = CityDAO.getCities();
        for (City city : cities) {
            System.out.println(city);
        }
        
        System.out.println("=====================");	        
        
        //afisam dupa ID
        City city = CityDAO.getById(2);
        System.out.println("Oras gasit dupa ID: " + city);
        
        System.out.println("=====================");
        
        //create
        City newCity = new City("New York", "USA", 8.8);
        int rowsInserted = CityDAO.createCity(newCity);
        System.out.println( rowsInserted);
        
        System.out.println("=====================");

        //update
        City cityToUpdate = new City(4, "Sydney", "Australia", 5.3);
        int rowsUpdated = CityDAO.updateCity(cityToUpdate);
        System.out.println(rowsUpdated);
        city = CityDAO.getById(4);
        System.out.println( city);
        
        System.out.println("=====================");

        //delete
        int rowsDeleted = CityDAO.deleteCity(5);
        System.out.println(rowsDeleted);
        city = CityDAO.getById(5);
        System.out.println(city);

	
}


}
