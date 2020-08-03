import java.util.*;
class caw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> listA = new ArrayList<>();
		listA.add("A");
		
		List <String> listB = listA;
		List <String> listC = new ArrayList<>(listB);
		
		listA.clear();
		listB.add("B");
		listC.add("C");
		
		System.out.println(listA);
		System.out.println(listB);
		System.out.println(listC);
		

	}

}
