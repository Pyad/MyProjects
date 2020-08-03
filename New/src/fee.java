import java.util.*;
class fee {
    public static class p{
    	{
    	System.out.print("1");
    	
    }
    static {
    	System.out.print("2");
    }
    }
    public static class C extends p{
    	{
    		System.out.print("3");
    	}
    	static {
    		System.out.print("4");
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c = new C();

	}

}
