package csv;

public class Car {
	private int id;
	private String brand;
	private String model;
	private String varient;
	private int year;
	private Long drivenKilometers;
	private String fuel;
	private String ownerType;
	private String bodyType;
	private String location;
	private Long price;
	private Long goal2Count;
	private Long goal6Count;

	public Car(int id, String brand, String model, String varient, int year, Long drivenKilometers, String fuel,
			String ownerType, String bodyType, String location, Long price) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.varient = varient;
		this.year = year;
		this.drivenKilometers = drivenKilometers;
		this.fuel = fuel;
		this.ownerType = ownerType;
		this.bodyType = bodyType;
		this.location = location;
		this.price = price;
	}
	
	public Car(String brand, int year, Long count) {
		this.brand = brand;
		this.year = year;
		this.goal2Count = count;
	}
	
	

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getVarient() {
		return varient;
	}

	public int getYear() {
		return year;
	}

	public Long getDrivenKilometers() {
		return drivenKilometers;
	}

	public String getFuel() {
		return fuel;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getLocation() {
		return location;
	}

	public Long getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", varient=" + varient + ", year=" + year
				+ ", drivenKilometers=" + drivenKilometers + ", fuel=" + fuel + ", ownerType=" + ownerType
				+ ", bodyType=" + bodyType + ", location=" + location + ", price=" + price+" ]";
	}
	public String toString1() {
		return "id=" + id + ", brand=" + brand + ", model=" + model + ", varient=" + varient + ", year=" + year
				+ ", drivenKilometers=" + drivenKilometers + ", fuel=" + fuel + ", ownerType=" + ownerType
				+ ", bodyType=" + bodyType + ", location=" + location + ", price=" + price;
	}
	
	public String Goal2String() {
		return "brand=" + brand + ", Manufacture Year=" + year + ", count=" + this.goal2Count;
	}
	
	
}

