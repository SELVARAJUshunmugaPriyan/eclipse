package collectionsThree;

//import java.util.Set;
//import java.util.Map;
import java.util.List;
import java.util.Arrays;
//import java.util.Comparator;
import java.util.stream.Collectors;

public class UseMobile {

	public static void main(String[] args) {
		
		/*
//		Mobile m1 = new Mobile(101, 12000, "Samsung", "Blue", true);
//		Mobile m2 = new Mobile(222, 40000, "HTC", "Red", false);
//		Mobile m3 = new Mobile(343, 80000, "Motorola", "Green", true);
//		Mobile m4 = new Mobile(404, 6000, "Oppo", "Black", true);
//		Mobile m5 = new Mobile(506, 9000, "Vivo", "Blue", false);
//		
//		List<Mobile> m = Arrays.asList(m1, m2, m3, m4, m5);
		
//		List<Mobile> warrantyMobiles = m.stream().filter(x -> 
//				x.isWarranty()).collect(Collectors.toList());
		
//		warrantyMobiles.forEach(x -> System.out.println(x));
		
//		List<String> names = m.stream().map(x -> x.getName())
//				.collect(Collectors.toList());
//		
//		names.forEach(x -> System.out.println(x));
		
//		List<Integer> priceRangeIds = m.stream().filter(x ->
//				x.getPrice() > 20000).map(x -> x.getId()).collect(
//						Collectors.toList());
//		
//		priceRangeIds.forEach(x -> System.out.println(x));
		
//		long cnt1 = m.stream().count();
//		
//		System.out.println(cnt1);
		
//		long cnt2 = m.stream().filter(x -> x.isWarranty()).count();
//		
//		System.out.println(cnt2);
		
//		int max = m.stream().map(x -> x.getPrice()).
//				max(Comparable::compareTo).get();
//		
//		System.out.println(max);
		
//		int min = m.stream().map(x -> x.getPrice()).
//				min(Comparable::compareTo).get();
//		
//		System.out.println(min);
		
//		Mobile maxObject = m.stream().max(Comparator.
//				comparing(Mobile::getId)).get();
//		
//		System.out.println(maxObject);
		
//		Mobile minObject = m.stream().min(Comparator.
//				comparing(Mobile::getId)).get();
//		
//		System.out.println(minObject);
		
//		Mobile maxObject = m.stream().filter(x -> x.getId() >= 222 
//				&& x.getId() <= 404).max(Comparator.comparing(
//				Mobile::getId)).get();
		
//		int minPrice = m.stream().filter(x -> x.getId() >= 222 
//				&& x.getId() <= 404).map(x -> x.getPrice()).min(
//						Comparable::compareTo).get();
//		
//		System.out.println(minPrice);
		
//		List<Mobile> limit1 = m.stream().limit(2).collect(
//				Collectors.toList());
//		
//		limit1.forEach(x -> System.out.println(x));
		
//		List<Mobile> skip1 = m.stream().skip(3).collect(
//				Collectors.toList());
//		
//		skip1.forEach(x -> System.out.println(x));
		
//		List<Integer> sortedField = m.stream().map(x -> 
//			 x.getPrice()).sorted().collect(Collectors.toList());
//		
//		sortedField.forEach(x -> System.out.println(x));

//		List<Integer> reversedField = m.stream().map(x -> 
//			 x.getId()).sorted(Comparator.reverseOrder())
//			 .collect(Collectors.toList());
//	
//		reversedField.forEach(x -> System.out.println(x));
//		List<Mobile> objSort = m.stream().sorted(Comparator.
//				comparing(Mobile::getPrice)).collect(Collectors
//						.toList());
//		
//		objSort.forEach(x -> System.out.println(x));
		
//		List<Mobile> objSort1 = m.stream().sorted(Comparator.
//				comparing(Mobile::getName).reversed()
//				).collect(Collectors.toList());
//		
//		objSort1.forEach(x -> System.out.println(x));
		
//		Mobile find = m.stream().findFirst().get();
//		
//		System.out.println(find);
		
//		Mobile secondMax = m.stream().sorted(Comparator
//				.comparing(Mobile::getPrice).reversed())
//				.skip(1).findFirst().get();
//		
//		System.out.println(secondMax);
		
//		Mobile secondMax = m.stream().filter(x -> x.isWarranty())
//				.skip(1).findFirst().get();
//		
//		System.out.println(secondMax);
		
//		List<String> names = m.stream().map(x -> x.getName())
//				.distinct().collect(Collectors.toList());
//		names.forEach(x -> System.out.println(x));
		
//		boolean a = m.stream().anyMatch(x -> x.getName()
//				.equals("Samsung"));
//		System.out.println(a);
		
//		List<Mobile> mobiles = m.stream().filter(x -> x.isWarranty())
//				.peek(x -> x.setPrice(x.getPrice() + 40000)).collect(
//						Collectors.toList());
//		
//		mobiles.forEach(x -> System.out.println(x));
		
//		int total = m.stream().collect(Collectors.
//				summingInt(x -> x.getPrice()));
//		
//		System.out.println(total);
		
//		int total = m.stream().filter(x -> !x.isWarranty())
//				.collect(Collectors.summingInt(
//						x -> x.getPrice()));
//
//		System.out.println(total);
		
//		Set<Integer> prices = m.stream().map(x -> x.getPrice())
//				.collect(Collectors.toSet());
//		
//		System.out.println(prices);
		
//		Map<Integer, Mobile> map = m.stream().collect(Collectors
//				.toMap(x -> x.getId(), x -> x));
//		
//		map.forEach((k, v) -> System.out.println(k + "=" + v));
		
//		Map<String, Long> map = m.stream().collect(Collectors
//				.groupingBy(x -> x.getName(), Collectors.counting()));
//		
//		map.forEach((k, v) -> System.out.println(k + "=" + v));
//
*/
//		List<Integer> num1 = Arrays.asList(1, 2, 3);
//		List<Integer> num2 = Arrays.asList(4, 5, 6);
//		List<List<Integer>> num3 = Arrays.asList(num1, num2);
//		System.out.println(num3);
//		List<Integer> num4 = num3.stream().flatMap(x -> 
//				x.stream()).collect(Collectors.toList());
//		System.out.println(num4);
//		
		List<String> str1 = Arrays.asList("Hello", "World");
		List<String> str2 = Arrays.asList("Hi", "im", "Priyan");
		List<List<String>> str3 = Arrays.asList(str1, str2);
		System.out.println(str3);
		List<String> str4 = str3.stream()
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
		System.out.println(str4);
	}

}

class Mobile
{
	private int id, price;
	private String name, color;
	private boolean isWarranty;
	
	// Constructor
	Mobile(int id, int price, String name,
			String color, boolean isWarranty)
	{
		this.id = id;
		this.price = price;
		this.name = name;
		this.color = color;
		this.isWarranty = isWarranty;
	}
	
	// Getters and setters
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
	public boolean isWarranty() {
		return isWarranty;
	}
	public void setWarranty(boolean isWarranty) {
		this.isWarranty = isWarranty;
	}
	
	public String toString()
	{
		return "Name: " + name + ", id: " + id + ", color"
				+ color + ", price: " + price + ", is warranty? "+
				(isWarranty ? "yes" : "no");
	}
}