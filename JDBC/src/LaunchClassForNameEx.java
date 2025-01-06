public class LaunchClassForNameEx{
	public static void main(String args[]) throws  ClassNotFoundException{
		System.out.println("From main meeathod");
		  Demo d = new Demo();
		  Class.class.forName("myDemo");
	}
}

  class Demo{
	    static {
	        System.out.println("from Sataic bllock");
	    }
	    {
	    	System.out.println("From non Static block");
	    }
  }
  
  class myDemo{
	  static {
		  System.out.println("static bloock of myDemo package");
	  }
	  {
		  System.out.println("From non static block of myDemo Package");
	  }
  }