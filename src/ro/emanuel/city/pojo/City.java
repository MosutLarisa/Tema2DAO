package ro.emanuel.city.pojo;

public class City {
	
	private int id;
	private String name;
	private String country;
	private double population;
	
	public City() {
		
	}

	@Override
	public String toString() {
		return "City [id:" + id + " | name:" + name + " | country:" + country + " | population:" + population +"]";
	}

	public City(int id, String name, String country, double population) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.population = population;
	}

	public City(String name, String country, double population) {
		super();
		this.name = name;
		this.country = country;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getPopulation() {
		return population;
	}

	public void setPopulation(double population) {
		this.population = population;
	}
	
	
}
