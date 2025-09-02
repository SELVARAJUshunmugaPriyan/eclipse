package my_thread;

public class MyThreadWait {

	private static final Object key = new Object();
	private static int number = 1;
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			synchronized (key) {
				while (number <= 9) {
					if (number % 2 == 1) {
						System.out.println("Thread 1 number: " + number++);
						try {
							key.notify();
							if (number < 10)
								key.wait();
						} catch (Exception e) {
							;
						}
					}
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			synchronized (key) {
				while (number <= 10) {
					if (number % 2 == 0) {
						System.out.println("Thread 2 number: " + number++);
						try {
							key.notify();
							if (number < 11)
								key.wait();
						} catch (Exception e) {
							;
						}
					}
				}
			}
		});
		
		t1.start();
		t2.start();
	}

}
