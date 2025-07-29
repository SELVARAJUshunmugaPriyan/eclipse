
// public access modifier
package p2;

import p1.*;

class C extends D
{
	//
}

class E 
{
	public static void main(String[] args)
	{
		D obj = new D();
		obj.display();
		
		obj = new C();
		obj.display();
	}
}
