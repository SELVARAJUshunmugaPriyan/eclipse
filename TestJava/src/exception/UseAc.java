package exception;

public class UseAc {

	public static void main(String[] args) {
		
		Ac acs[] = {
			new Ac("LG", "MDH001", 43000, 12),
			new Ac("Samsung", "FX900", 48000, 6),
			new Ac("Carrier", "LL809", 24000, 0),
			new Ac("OGeneral", "OG98", 32000, -2),
			new Ac("WhirlPool", "C91", 43000, 10)
		};
		
		for (Ac ac : acs) {
			try {
				if (ac.getNoOfMonthsWarranty() < 1)
					throw new NoWarrantyException(ac.getBrand() +
							" " + ac.getModel() + " has no warranty");
				System.out.println(ac);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}

class Ac
{
	private String brand, model;
	private int price, noOfMonthsWarranty;
	
	// Constructor
	Ac(String brand, String model,
	   int price, int noOfMonthsWarranty)
	{
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.noOfMonthsWarranty = noOfMonthsWarranty;
	}
	
	// Getters and Setters
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNoOfMonthsWarranty() {
		return noOfMonthsWarranty;
	}
	public void setNoOfMonthsWarranty(int noOfMonthsWarranty) {
		this.noOfMonthsWarranty = noOfMonthsWarranty;
	}
	
	public String toString()
	{
		return "Brand: " + brand + ", Model: " + model +
			   ", Price: " + price + ", No of warranty (months): " +
			   noOfMonthsWarranty;
	}
}

class NoWarrantyException extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	NoWarrantyException(String msg)
	{
		super(msg);
	}
}

