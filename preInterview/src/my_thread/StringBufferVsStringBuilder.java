package my_thread;

public class StringBufferVsStringBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start, end;
		StringBuffer s1 = new StringBuffer("x");
		start = System.nanoTime();
		for (int i = 1; i < 1000; i++) {
			s1.append("x");
		}
		
		end = System.nanoTime();
		System.out.println("StringBuffer time: " + (end - start));
		
		StringBuilder s2 = new StringBuilder("x");
		start = System.nanoTime();
		
		for (int i = 1; i < 1000; i++) {
			s2.append("x");
		}
		
		end = System.nanoTime();
		System.out.println("StringBuilder time: " + (end - start));
	}

}
