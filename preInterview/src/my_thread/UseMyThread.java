package my_thread;

class MyThread extends Thread 
{
	
	@Override
	public void run() 
	{
		System.out.println("Thread executes");
	}
	
}

public class UseMyThread 
{

	public static void main(String[] args)
	{
		Thread t1 = new MyThread();
		
		System.out.println("main starts");
		t1.start();
		System.out.println("main  ends");
	}
	
}