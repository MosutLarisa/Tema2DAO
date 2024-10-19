package ro.emanuel.laptop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.laptop.helper.DBHelper;
import ro.emanuel.laptop.pojo.Laptop;


public class LaptopDAO {
	

	 public static List<Laptop> getLaptops() throws SQLException {
	        List<Laptop> laptops = new ArrayList<>();

	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("select * from laptop");
			while(rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int ram = rs.getInt("ram");
				Laptop laptop = new Laptop(id, brand, model, ram);
				laptops.add(laptop);
			}
			
			DBHelper.closeConnection();
			return laptops;
		}
	    
	    public static Laptop getById(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        
	        List<Laptop> laptops = getLaptops();
	        for(Laptop b : laptops) {
	            if(b.getId() == id) {
	                return b; 
	            }
	        }
	        return null;
	    }
	    
	    
	  public static int createLaptop(Laptop laptopToCreate) throws SQLException {
	      Connection conn = DBHelper.getConnection();
	      String query = "insert into laptop (brand, model, ram) values(?,?,?)";
	      PreparedStatement ps = conn.prepareStatement(query);
	      
	      ps.setString(1, laptopToCreate.getBrand());
	      ps.setString(2, laptopToCreate.getModel());
	      ps.setInt(3, laptopToCreate.getRam());
	      
	      int affectedRows = ps.executeUpdate();
	      
	      DBHelper.closeConnection();
	      
	      return affectedRows; 
	  }
	  
	  
	  public static int updateLaptop(Laptop laptop) throws SQLException {
		  Connection conn = DBHelper.getConnection();
		  String query = "update laptop set brand = ?, model = ?, ram = ? where id = ?";
		  PreparedStatement ps = conn.prepareStatement(query);
	    
	    	ps.setString(1, laptop.getBrand());
	    	ps.setString(2, laptop.getModel());
	    	ps.setInt(3, laptop.getRam());
	    	ps.setInt(4, laptop.getId());
	    
	    	int rowsUpdated = ps.executeUpdate();
	    
	    	DBHelper.closeConnection();
	    
	    	return rowsUpdated; 
		}


	    public static int deleteLaptop(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        int deletedRows = stmt.executeUpdate("delete from laptop where id = " + id);
	        
	        DBHelper.closeConnection();
	        
	        return deletedRows; 
	    }

}
