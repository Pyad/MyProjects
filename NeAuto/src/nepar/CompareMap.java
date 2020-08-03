package nepar;

import java.util.HashMap;

public class CompareMap {

	public static void main(String[] args) {
		
		public boolean mapsAreEqual(HashMap<String, String> map1, HashMap<String, String> map) {
	        for (String k : map1.keySet())
	        {
	            if (!map.get(k).equals(map1.get(k))) {
	                return false;
	            }
                 return true;
		}
	}
	
		// TODO Auto-generated method stub
		public static HashMap<String, String> comp() {
		HashMap<String, String>  map = new HashMap<String, String>();
		map.put("Name", "Balaji");
		map.put("Age", "Twenty");
		map.put("nickname", "Spped");
		map.put("Add", "Chennai");
	
		
		return map;
		
		
		}
	public static HashMap<String, String> comp1() {
		
		HashMap<String, String>  map1 = new HashMap<String, String>();
		map1.put("Name", "Balaji");
		map1.put("Age", "Twenty");
		map1.put("nickname", "Spped");
		map1.put("Add", "Chennai");
		
		return map1;
		
		
	}
	

}
