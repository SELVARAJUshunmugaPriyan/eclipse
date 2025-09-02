package my_thread;

class MyThread extends Thread 
{
	
	@Override
	public void run() 
	{
		System.out.println("Thread executes");
	}
	
}

class MyRunnable implements Runnable
{
	
	@Override
	public void run() 
	{
		System.out.println("Runnable executes");
	}
	
}

public class UseMyThread 
{

	public static void main(String[] args) 
		throws InterruptedException
	{
		Thread t1 = new MyThread();
		
		 MyRunnable mr = new MyRunnable();
		 Thread t2 = new Thread(mr);
		
		System.out.println("main starts");
		
		t1.start();
		 t1.join();
		t2.start();
		 t2.join();
		
		Thread t3 = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("Thread 1 " + i);
			}
		});
		
		t3.start();
		t3.join();
		
		System.out.println("main  ends");
	}
	
}