package dayThree;

class Hospital {
	String name;
	String location;
	boolean isAvail24;
}

public class UseHospital {
	// Class Hospital and string operations
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hospital hos1 = new Hospital();
		Hospital hos2 = new Hospital();
		Hospital hos3 = new Hospital();
		
		hos1.name = "apollo";
		hos1.location = "chennai";
		hos1.isAvail24 = true;
		
		hos2.name = "kauvery";
		hos2.location = "chennai";
		hos2.isAvail24 = true;
		
		hos3.name = "sims";
		hos3.location = "chennai";
		hos3.isAvail24 = true;
		
		System.out.println("Hospital names (UPPER-CASE), location (UPPER-CASE) and 24hrs availability are \n"
				+ hos1.name.toUpperCase() + " " + hos1.location.toUpperCase() + " " + hos1.isAvail24 + "\n"
				+ hos2.name.toUpperCase() + " " + hos2.location.toUpperCase() + " " + hos2.isAvail24 + "\n"
				+ hos3.name.toUpperCase() + " " + hos3.location.toUpperCase() + " " + hos3.isAvail24 + "\n"
				+ "\nLength of location name of third hospital is "
				+ hos3.location.length()
				+ "\nAre first and second hospital names same?"
				+ hos1.name.equals(hos2.name));
	}

}
