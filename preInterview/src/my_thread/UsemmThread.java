package my_thread;

public class UsemmThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main starts");
		
		Thread t1 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("Thread 1 " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("Thread 2 " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		System.out.println("main   ends");
	}

}
