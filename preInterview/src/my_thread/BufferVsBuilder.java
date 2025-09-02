package my_thread;

public class BufferVsBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer("Buffer");
		StringBuilder sb2 = new StringBuilder("Builder");
		
		Runnable task = () -> {
			for (int i = 1; i <= 1000; i++) {
				sb1.append("x");
				sb2.append("b");
			}
		};
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			;
		}
		
		System.out.println("StringBuffer length: " + sb1.length() +
				"\nStringBuilder length: " + sb2.length());
	}

}
