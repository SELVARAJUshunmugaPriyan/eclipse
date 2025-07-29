package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExampleFileNotFoundException 
{

	public static void main(String[] args) 
			throws IOException, 
			FileNotFoundException
	{
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\monk_\\eclipse-workspace\\Java\\src\\exception\\dummy.txt");
		
		FileReader fr = new FileReader(f);
		
		int temp = 0;
		while((temp = fr.read()) != -1) {
			System.out.print((char) temp);
		}
		
		fr.close();
	}

}
