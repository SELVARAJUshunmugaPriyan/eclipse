// Another class trying to access PrivateInnerClass (will result
// in a compilation error)
package p1;


class AnotherClass 
{
	
	public static void main(String[] args)
	{
		// All fields except private accessible
		// without extending
		new OuterClass().defaultData = 0;
		new OuterClass().publicData = 0;
		new OuterClass().protectedData = 0;
//		new OuterClass().privateData = 0; // Error
		new AnotherClassExtends().protectedData = 0;
		new AnotherClassExtends().defaultData = 0;
		new AnotherClassExtends().publicData = 0;
//		new AnotherClassExtends().privateData = 0; // Error
		
		// All methods except private are accessible for parent
		// object
		new OuterClass().defaultMethod();
		new OuterClass().publicMethod();
		new OuterClass().protectedMethod();
//		new OuterClass().privateMethod(); // Error
		new AnotherClassExtends().defaultMethod();
		new AnotherClassExtends().publicMethod();
		new AnotherClassExtends().protectedMethod();
//		new AnotherClassExtends().privateMethod(); // Error
		
		// All inner classes except private are accessible
		// by parent object and child object
		new OuterClass().new DefaultInnerClass();
		new OuterClass().new PublicInnerClass();
		new OuterClass().new ProtectedInnerClass();
//		new OuterClass().new PrivateInnerClass(); // Error
		new AnotherClassExtends().new DefaultInnerClass();
		new AnotherClassExtends().new PublicInnerClass();
		new AnotherClassExtends().new ProtectedInnerClass();
//		new AnotherClassExtends().new PrivateInnerClass(); // Error
	}
}

class AnotherClassExtends extends OuterClass
{
	public static void main(String[] args)
	{
//		OuterClass.PrivateInnerClass inner = new OuterClass().
//				new PrivateInnerClass(); // Error
		new OuterClass().createAndUseInner(); // Access to Inner
											  // class
		// Fields accessible after extending
		new OuterClass().defaultData = 0;
		new OuterClass().publicData = 0;
		new OuterClass().protectedData = 0;
//		new OuterClass().privateData = 0; // Error
		new AnotherClassExtends().protectedData = 0;
		new AnotherClassExtends().defaultData = 0;
		new AnotherClassExtends().publicData = 0;
//		new AnotherClassExtends().privateData = 0; // Error
		
		// All methods  except private are accessible after
		// extending
		new OuterClass().defaultMethod();
		new OuterClass().publicMethod();
		new OuterClass().protectedMethod();
//		new OuterClass().privateMethod();
		new AnotherClassExtends().defaultMethod();
		new AnotherClassExtends().publicMethod();
		new AnotherClassExtends().protectedMethod();
//		new AnotherClassExtends().privateMethod();
		
		// All inner classes except private are accessible
		new OuterClass().new DefaultInnerClass();
		new OuterClass().new PublicInnerClass();
		new OuterClass().new ProtectedInnerClass();
//		new OuterClass().new PrivateInnerClass(); // Error
		new AnotherClassExtends().new DefaultInnerClass();
		new AnotherClassExtends().new PublicInnerClass();
		new AnotherClassExtends().new ProtectedInnerClass();
//		new AnotherClassExtends().new PrivateInnerClass(); // Error
	}
}