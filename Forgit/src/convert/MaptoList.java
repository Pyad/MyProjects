package convert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaptoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, String> myMap = new HashMap<>();
	      myMap.put(1, "Java");
	      myMap.put(2, "JavaFX");
	      myMap.put(3, "CoffeeScript");
	      myMap.put(4, "TypeScript");

	      ArrayList<Integer> keyList = new ArrayList<Integer>(myMap.keySet());
	      ArrayList<String> valueList = new ArrayList<String>(myMap.values());

	      System.out.println("contents of the list holding keys the map ::"+keyList.size());
	      System.out.println("contents of the list holding values of the map ::"+valueList);

	}

}
