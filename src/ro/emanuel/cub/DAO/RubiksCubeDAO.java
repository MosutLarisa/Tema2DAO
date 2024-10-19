package ro.emanuel.cub.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.cub.helper.DBHelper;
import ro.emanuel.cub.pojo.RubiksCube;

public class RubiksCubeDAO {

	 public static List<RubiksCube> getCubes() throws SQLException {
	        List<RubiksCube> cubes = new ArrayList<>();

	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        ResultSet rs = stmt.executeQuery("select * from rubikscube");
			while(rs.next()) {
				int id = rs.getInt("id");
				String brand = rs.getString("brand");
				double weight = rs.getDouble("weight");
				int sides = rs.getInt("sides");
				RubiksCube cube = new RubiksCube(id, brand, weight, sides);
				cubes.add(cube);
			}
			
			DBHelper.closeConnection();
			return cubes;
		}
	    
	    public static RubiksCube getById(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        
	        List<RubiksCube> cubes = getCubes();
	        for(RubiksCube b : cubes) {
	            if(b.getId() == id) {
	                return b; 
	            }
	        }
	        return null;
	    }
	    
	    
	  public static int createCube(RubiksCube cubeToCreate) throws SQLException {
	      Connection conn = DBHelper.getConnection();
	      String query = "insert into rubikscube (brand, weight, sides) values(?,?,?)";
	      PreparedStatement ps = conn.prepareStatement(query);
	      
	      ps.setString(1, cubeToCreate.getBrand());
	      ps.setDouble(2, cubeToCreate.getWeight());
	      ps.setInt(3, cubeToCreate.getSides());
	      
	      int affectedRows = ps.executeUpdate();
	      
	      DBHelper.closeConnection();
	      
	      return affectedRows; 
	  }
	  
	  
	  public static int updateCube(RubiksCube cube) throws SQLException {
		  Connection conn = DBHelper.getConnection();
		  String query = "update rubikscube set brand = ?, weight = ?, sides = ? where id = ?";
		  PreparedStatement ps = conn.prepareStatement(query);
	    
	    	ps.setString(1, cube.getBrand());
	    	ps.setDouble(2, cube.getWeight());
	    	ps.setInt(3, cube.getSides());
	    	ps.setInt(4, cube.getId());
	    
	    	int rowsUpdated = ps.executeUpdate();
	    
	    	DBHelper.closeConnection();
	    
	    	return rowsUpdated; 
		}


	    public static int deleteCube(int id) throws SQLException {
	        Connection conn = DBHelper.getConnection();
	        Statement stmt = conn.createStatement();
	        
	        int deletedRows = stmt.executeUpdate("delete from rubikscube where id = " + id);
	        
	        DBHelper.closeConnection();
	        
	        return deletedRows; 
	    }

}
