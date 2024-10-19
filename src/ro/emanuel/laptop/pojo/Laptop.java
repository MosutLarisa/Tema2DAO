package ro.emanuel.laptop.pojo;

public class Laptop {
	
	private int id;
	private String brand;
	private String model;
	private int ram;
	
	public Laptop() {
		
	}
	
	@Override
	public String toString() {
		return "Laptop [id:" + id + " | brand:" + brand + " | model:" + model + " | ram:" + ram +"]";
	}

	public Laptop(int id, String brand, String model, int ram) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.ram = ram;
	}

	public Laptop(String brand, String model, int ram) {
		super();
		this.brand = brand;
		this.model = model;
		this.ram = ram;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}
	
	

}
