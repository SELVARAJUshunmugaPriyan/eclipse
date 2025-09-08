package collectionsTwo;

import java.util.HashMap;
//import java.util.Iterator;

class Car
{
	private int id, price;
	private String name, color, model;
	private boolean isWarranty;
	
	// Constructor
	Car(int id, int price, String name, String color, String model, boolean isWarranty)
	{
		this.id = id;
		this.price = price;
		this.name = name;
		this.color = color;
		this.model = model;
		this.isWarranty = isWarranty;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public boolean isWarranty() {
		return isWarranty;
	}
	public void setWarranty(boolean isWarranty) {
		this.isWarranty = isWarranty;
	}
	
	public String toString()
	{
		return 	String.format("id: %03d, price: %7d, name: %8s"
				+ ", color: %6s, model: %7s, Is Warranty? %3s",
				id, price, name, color, model, (isWarranty ? "yes" : "no"));
	}
}

public class UseCar {

	public static void main(String[] args) {
		
		Car c1 = new Car(0, 1200000, "BMW", "Blue", "X8", true);
		Car c2 = new Car(1, 6700000, "Volvo", "Green", "X12", true);
		Car c3 = new Car(17, 5700000, "Mercedes", "Yellow", "C-Class", true);
		Car c4 = new Car(3, 600000, "Maruti", "Red", "v6", false);
		Car c5 = new Car(4, 900000, "Tata", "White", "Sumo", false);

		HashMap<Integer, Car> c = new HashMap<>();
		
		c.put(c1.getId(), c1);
		c.put(c2.getId(), c2);
		c.put(c3.getId(), c3);
		c.put(c4.getId(), c4);
		c.put(c5.getId(), c5);
		
		// Iterating through (k, v) pairs
//		c.forEach((k, v) -> System.out.println(k + " " + v));
//		c.values().forEach(v -> System.out.println(v));
//		c.keySet().forEach(k -> System.out.println(k + " " + 
//										c.get(k)));
//		for (Car car : c.values())
//			System.out.println(car);
//		
//		for (int i : c.keySet())
//			System.out.println(i + " " + c.get(i));
		
		// finding costliest car
//		Car maxCar = c1;
//		for (int i : c.keySet())
//			if (c.get(i).getPrice() > maxCar.getPrice())
//				maxCar = c.get(i);
		

//		System.out.println("Max-priced car : \n" + maxCar);
		
//		for (Car car : c.values())
//			if (car.getPrice() > maxCar.getPrice())
//				maxCar = car;
		
//		System.out.println("Max-priced car : \n" + maxCar + "\n");
		
		// finding cars with warranty
//		for (int i : c.keySet())
//			if (c.get(i).isWarranty())
//				System.out.println(c.get(i));
		
//		for (Car car : c.values())
//			if (car.isWarranty())
//				System.out.println(car);
		
		// filtering cars in price range
//		for (int i : c.keySet()) {
//			Car car = c.get(i);
//			int price = car.getPrice();
//			if (price >= 1200000 && price <= 5700000)
//				System.out.println(car);
//		}
//		
//		for (Car car : c.values()) {
//			int price = car.getPrice();
//			if (price >= 1200000 && price <= 5700000)
//				System.out.println(car);
//		}
		
		// filter by starts with
//		for (int i : c.keySet()) {
//			Car car = c.get(i);
//			String name = car.getName();
//			if (name.startsWith("M"))
//				System.out.println(car);
//		}
		
//		for (Car car : c.values()) {
//			String name = car.getName();
//			if (name.startsWith("M"))
//				System.out.println(car);
//		}
		
//		c.forEach((k, v) -> {
//			if (v.getName().startsWith("M"))
//				System.out.println(v);
//		});
		
		// filter by ends with
//		for (int i : c.keySet()) {
//			Car car = c.get(i);
//			String name = car.getName();
//			if (name.endsWith("W"))
//				System.out.println(car);
//		}
		
//		for (Car car : c.values()) {
//			String name = car.getName();
//			if (name.endsWith("W"))
//				System.out.println(car);
//		}
		
//		c.forEach((k, v) -> {
//			if (v.getName().endsWith("W"))
//				System.out.println(v);
//		});
//		c.forEach((k, v) -> {
//			if (v.isWarranty())
//				v.setPrice((int) (v.getPrice() * 1.1));
//			else
//				v.setPrice((int) (v.getPrice() * 0.9));
//			System.out.println(v);
//		});
		
		// Using Iterator
//		Iterator<Car> cars = c.values().iterator();
//		while (cars.hasNext())
//			if (!cars.next().isWarranty())
//				cars.remove();
		
//		for (cars = c.values().iterator(); cars.hasNext(); )
//			System.out.println(cars.next());
//		Iterator<Integer> cars = c.keySet().iterator();
//		while (cars.hasNext())
//			if (!c.get(cars.next()).isWarranty())
//				cars.remove();
//		for (cars = c.keySet().iterator(); cars.hasNext(); 
//				System.out.println(c.get(cars.next())))
//			;
		c.keySet().forEach(k -> System.out.println(k.hashCode() % 16));
	}

}
