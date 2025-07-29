// Java program to illustrate
// the concept of TypeErasure

package javaClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UseTypeErasure 
{	
	
	// Here, type is bounded by Object i.e. java.lang.Object
	class UnboundedType<type>
	{
		// Here, type will be replaced by default i.e. Object
		type obj;
		
		UnboundedType(type o) 
		{
			// TODO Auto-generated constructor stub
			obj = o;
		}
		type getObj()
		{
			return obj;
		}
	}
	
	// Here, type is bounded by Object i.e. java.lang.Object
	@SuppressWarnings("all")
	class BoundedType<type extends String>
	{
		// Here, type will be replaced by String i.e. java.lang.String
		type obj;
		
		BoundedType(type o) 
		{
			// TODO Auto-generated constructor stub
			obj = o;
		}
		type getObj()
		{
			return obj;
		}
	}
	
	static void typeErasure()
	{
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void rawTypes()
	{
		List list = new ArrayList<>();
		list.add("Hello");
		String s;
		for (Iterator iter = list.iterator(); iter.hasNext();
				System.out.println(s))
			s = (String) iter.next();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		UnboundedType o = new UseTypeErasure().new UnboundedType(null);
		BoundedType p = new UseTypeErasure().new BoundedType(null);
		System.out.println(o.getObj());
//		typeErasure();
//		rawTypes();
	}

}
