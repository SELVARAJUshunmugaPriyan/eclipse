package dayTwo;

class Student {
	String name;
	int id;
	int age;
	String classSection;
	float attendancePercentage;
	int numOfDaysPresent;
}
public class UseStudent {
	
	public static void main (String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		s1.name = "siva";
		s1.id = 234;
		s1.age = 14;
		s1.classSection = "IX";
		s1.attendancePercentage = 75.0f;
		s1.numOfDaysPresent = (int)(240 * (s1.attendancePercentage / 100));
		
		s2.name = "mari";
		s2.id = 236;
		s2.age = 15;
		s2.classSection = "X";
		s2.attendancePercentage = 80.0f;
		s2.numOfDaysPresent = (int)(240 * (s2.attendancePercentage / 100));
		
		s3.name = "Valli";
		s3.id = 237;
		s3.age = 13;
		s3.classSection = "VIII";
		s3.attendancePercentage = 90.0f;
		s3.numOfDaysPresent = (int)(240 * (s3.attendancePercentage / 100));
		
		
		System.out.println(s1.name + " No of days present is " +
				s1.numOfDaysPresent);
		System.out.println(s2.name + " No of days present is " +
				s2.numOfDaysPresent);
		System.out.println(s3.name + " No of days present is " +
				s3.numOfDaysPresent);
	}
	
}
