import NewClass.child;

public class NewClass {
	public static class parent{
	
	void print() {
		System.out.println("print in parent");
	}

}
    public static class child extends print{
	@Override
	void print() {
		System.out.println("print in child");
	}
}

		
    public static void main(String[] args) {
    	parent A = new parent();
    	parent B = new child();
    	A.print();
    	B.print();
    }
	
}
