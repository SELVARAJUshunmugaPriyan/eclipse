package oopsOne;

//import java.util.Arrays;

class Camera
{
	private int megapixels;
	private boolean isOpticalZoom, isDigitalZoom;
	private String location;
	
	// Constructors
	public Camera()
	{}
	
	public Camera(int megapixels, boolean isOpticalZoom,
			boolean isDigitalZoom, String location)
	{
		this.megapixels = megapixels;
		this.isOpticalZoom = isOpticalZoom;
		this.isDigitalZoom = isDigitalZoom;
		this.location = location;
	}
	
	// Setters
	public void setMegapixels(int megapixels) 
	{
		this.megapixels = megapixels;
	}

	public void setOpticalZoom(boolean isOpticalZoom) 
	{
		this.isOpticalZoom = isOpticalZoom;
	}
	
	public void setDigitalZoom(boolean isDigitalZoom) 
	{
		this.isDigitalZoom = isDigitalZoom;
	}
	
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	// Getters
	public int getMegapixels() 
	{
		return megapixels;
	}
	
	public boolean isOpticalZoom() 
	{
		return isOpticalZoom;
	}
	
	public boolean isDigitalZoom() 
	{
		return isDigitalZoom;
	}
	
	public String getLocation() 
	{
		return location;
	}
	
	public String toString()
	{
		return "\n\n\t\tmegapixels : " + megapixels
			 + "\n\t\tOptical zoom : " + (isOpticalZoom ? "yes" : "no")
			 + "\n\t\tDigital zoom : " + (isDigitalZoom ? "yes" : "no")
			 + "\n\t\tlocation : " + location;
	}
}

class Mobile
{
	private int id, price;
	private float memoryInGB;
	private String brand, model;
	private Camera cameraNames[];
	
	// Constructor
	public Mobile()
	{}
	
	public Mobile(int id, int price, float memoryInGB,
			String brand, String model, Camera cameraNames[])
	{
		this.id = id;
		this.price = price;
		this.memoryInGB = memoryInGB;
		this.brand = brand;
		this.model = model;
		this.cameraNames = cameraNames;
	}
	
	// Setters
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setPrice(int price)
	{
		this.price = price;
	}

	public void setMemory(float memoryInGB)
	{
		this.memoryInGB = memoryInGB;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public void setCameras(Camera cameraNames[])
	{
		this.cameraNames = cameraNames;
	}
	
	// Getters
	public int getId()
	{
		return id;
	}
	
	public int getPrice()
	{
		return price;
	}

	public float getMemory()
	{
		return memoryInGB;
	}

	public String getBrand()
	{
		return brand;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public Camera[] getCameras()
	{
		return cameraNames;
	}
}

public class UseMobile {

	public static void main(String[] args) {
		
//		Mobile mobile1 = new Mobile(616, 85000, 12.0f,
//				"Samsung", "S20", new String[] {
//						"Canon", "Fujifilm", "Nikon"
//				});
//		Mobile mobile2 = new Mobile(727, 66000, 6.0f,
//				"LG", "G5", new String[] {
//						"Canon", "Kodak", "Nikon"
//				});
//		Mobile mobile3 = new Mobile(808, 115000, 10.0f,
//				"Apple", "i13", new String[] {
//						"Canon", "Fujifilm", "Kodak"
//				});
		Mobile mobile1 = new Mobile();
		Mobile mobile2 = new Mobile();
		Mobile mobile3 = new Mobile();
		
		Mobile mobiles[] = new Mobile[] {mobile1, mobile2, mobile3};
		
		Camera Canon = new Camera(64, true, true, "back");
		Camera Fujifilm = new Camera(32, true, false, "front");
		Camera Nikon = new Camera(16, false, true, "back");
		Camera Kodak = new Camera(64, false, false, "back");
		
		mobile1.setBrand("Samsung");
		mobile1.setId(616);
		mobile1.setPrice(85000);
		mobile1.setMemory(12.0f);
		mobile1.setModel("S20");
		mobile1.setCameras(new Camera[] {Canon, Fujifilm, Nikon});

		mobile2.setBrand("LG");
		mobile2.setId(727);
		mobile2.setPrice(66000);
		mobile2.setMemory(6.0f);
		mobile2.setModel("G5");
		mobile2.setCameras(new Camera[] {Canon, Kodak, Nikon});

		mobile3.setBrand("Apple");
		mobile3.setId(808);
		mobile3.setPrice(115000);
		mobile3.setMemory(10.0f);
		mobile3.setModel("i13");
		mobile3.setCameras(new Camera[] {Canon, Kodak, Fujifilm});

		
		for (Mobile mobile : mobiles)
			showMobileDetails(mobile);
//			System.out.println("\nid : " + mobile.getId()
//					+ "\nbrand : " + mobile.getBrand()
//					+ "\nmodel : " + mobile.getModel()
//					+ "\nprice : " + mobile.getPrice()
//					+ "\nmemory (in GB) : " + mobile.getMemory()
//					+ "\ncameras : " + Arrays.toString(mobile.getCameras()));
	}

	static void showMobileDetails(Mobile mobile)
	{
		System.out.println("\nid : " + mobile.getId()
				+ "\nbrand : " + mobile.getBrand()
				+ "\nmodel : " + mobile.getModel()
				+ "\nprice : " + mobile.getPrice()
				+ "\nmemory (in GB) : " + mobile.getMemory()
				+ "\ncameras : ");
		
		for (Camera camera : mobile.getCameras())
			System.out.println("\n\t\tmegapixels : " + camera.getMegapixels()
					+ "\n\t\tOptical zoom : " + (camera.isOpticalZoom() ? "yes" : "no")
					+ "\n\t\tDigital zoom : " + (camera.isDigitalZoom() ? "yes" : "no")
					+ "\n\t\tlocation : " + camera.getLocation());
	}
}
