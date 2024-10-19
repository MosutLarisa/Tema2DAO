package ro.emanuel.city.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.city.helper.DBHelper;
import ro.emanuel.city.pojo.City;

public class CityDAO {

	 public static List<City> getCities() throws SQLException {
	        List<City> cities = new ArrayList<>();

	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("select * from city");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String country = rs.getString("country");
				double population = rs.getDouble("population");
				City city = new City(id, name, country, population);
				cities.add(city);
			}
			
			DBHelper.closeConnection();
			return cities;
		}
	    
	    public static City getById(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        
	        List<City> cities = getCities();
	        for(City b : cities) {
	            if(b.getId() == id) {
	                return b; 
	            }
	        }
	        return null;
	    }
	    
	    
	  public static int createCity(City cityToCreate) throws SQLException {
	      Connection conn = DBHelper.getConnection();
	      String query = "insert into city (name, country, population) values(?,?,?)";
	      PreparedStatement ps = conn.prepareStatement(query);
	      
	      ps.setString(1, cityToCreate.getName());
	      ps.setString(2, cityToCreate.getCountry());
	      ps.setDouble(3, cityToCreate.getPopulation());
	      
	      int affectedRows = ps.executeUpdate();
	      
	      DBHelper.closeConnection();
	      
	      return affectedRows; 
	  }
	  
	  
	  public static int updateCity(City city) throws SQLException {
		  Connection conn = DBHelper.getConnection();
		  String query = "update city set name = ?, country = ?, population = ? where id = ?";
		  PreparedStatement ps = conn.prepareStatement(query);
	    
	    	ps.setString(1, city.getName());
	    	ps.setString(2, city.getCountry());
	    	ps.setDouble(3, city.getPopulation());
	    	ps.setInt(4, city.getId());
	    
	    	int rowsUpdated = ps.executeUpdate();
	    
	    	DBHelper.closeConnection();
	    
	    	return rowsUpdated; 
		}


	    public static int deleteCity(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        int deletedRows = stmt.executeUpdate("delete from city where id = " + id);
	        
	        DBHelper.closeConnection();
	        
	        return deletedRows; 
	    }

}
