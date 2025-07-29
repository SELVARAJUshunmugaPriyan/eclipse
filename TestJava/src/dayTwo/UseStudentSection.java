package dayTwo;

class StudentSection {
	String studentName;
	int studentAge;
	long studentMobileNo;
	String classSection;
	float marksPercentage;
}

public class UseStudentSection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentSection s1 = new StudentSection();
		StudentSection s2 = new StudentSection();
		StudentSection s3 = new StudentSection();
		
		s1.studentName = "mohan";
		s1.studentAge = 12;
		s1.studentMobileNo = 9692939495l;
		s1.classSection = "X C";
		s1.marksPercentage = 72.0f;
		
		
		s2.studentName = "Ram";
		s2.studentAge = 13;
		s2.studentMobileNo = 7235443322l;
		s2.classSection = "XII D";
		s2.marksPercentage = 68.0f;
		
		
		s3.studentName = "mohana";
		s3.studentAge = 15;
		s3.studentMobileNo = 6355442211l;
		s3.classSection = "XII E";
		s3.marksPercentage = 80.0f;
		
		
		System.out.println("Student name = " + s1.studentName + "\n" +
				"Age = " + s1.studentAge + "\n" +
				"Mobile no = " + s1.studentMobileNo + "\n" +
				"Class section = " + s1.classSection + "\n" +
				"Marks percentage = " + s1.marksPercentage + "\n");
		
		System.out.println("Student name = " + s2.studentName + "\n" +
				"Age = " + s2.studentAge + "\n" +
				"Mobile no = " + s2.studentMobileNo + "\n" +
				"Class section = " + s2.classSection + "\n" +
				"Marks percentage = " + s2.marksPercentage + "\n");
		
		System.out.println("Student name = " + s3.studentName + "\n" +
				"Age = " + s3.studentAge + "\n" +
				"Mobile no = " + s3.studentMobileNo + "\n" +
				"Class section = " + s3.classSection + "\n" +
				"Marks percentage = " + s3.marksPercentage);
	}

}
