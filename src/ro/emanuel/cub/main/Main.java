package ro.emanuel.cub.main;

import java.sql.SQLException;
import java.util.List;

import ro.emanuel.cub.DAO.RubiksCubeDAO;
import ro.emanuel.cub.pojo.RubiksCube;

public class Main {

		public static void main(String[] args) throws SQLException, ClassNotFoundException {
			
			//afisam
	        List<RubiksCube> cubes = RubiksCubeDAO.getCubes();
	        for (RubiksCube cube : cubes) {
	            System.out.println(cube);
	        }
	        
	        System.out.println("=====================");	        
	        
	        //afisam dupa ID
	        RubiksCube cube = RubiksCubeDAO.getById(2);
	        System.out.println("Cub gasit dupa ID: " + cube);
	        
	        System.out.println("=====================");
	        
	        //create
	        RubiksCube newCube = new RubiksCube("MoYu", 80, 5);
	        int rowsInserted = RubiksCubeDAO.createCube(newCube);
	        System.out.println( rowsInserted);
	        
	        System.out.println("=====================");

	        //update
	        RubiksCube cubeToUpdate = new RubiksCube(4, "Gan11", 70, 6);
	        int rowsUpdated = RubiksCubeDAO.updateCube(cubeToUpdate);
	        System.out.println(rowsUpdated);
	        cube = RubiksCubeDAO.getById(2);
	        System.out.println( cube);
	        
	        System.out.println("=====================");

	        //delete
	        int rowsDeleted = RubiksCubeDAO.deleteCube(3);
	        System.out.println(rowsDeleted);
	        cube = RubiksCubeDAO.getById(3);
	        System.out.println(cube);

		
	}

}
