import java.util.*;

class mass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> object1= new HashMap<String, Integer>();
		object1.put("A", new Integer(30));
		object1.put("B", new Integer(20));
		object1.put("C", new Integer(80));
		object1.remove("A", new Integer(30));
		System.out.println(object1);

	}

}
