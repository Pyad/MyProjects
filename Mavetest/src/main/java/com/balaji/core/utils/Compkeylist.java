package com.balaji.core.utils;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

public class Compkeylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, String> map1 = new LinkedHashMap<String, String>();
		Map<String, String> map2 = new LinkedHashMap<String, String>();
		
		map1.put("FN", "Balaji");
		map1.put("MN", "C");
		map1.put("LN", "S");
		map1.put("DOB", "July");
		
		map2.put("FN", "Bala");
		map2.put("MN", "c");
		map2.put("LN", "S");
		map2.put("DOB", "July");
		map2.put("year", "1992");
		if(map1.keySet().equals(map2.keySet())) {
			
			System.out.println("Both map are equal");
			
			
		}
		else {
			
			
				HashSet<String> unionKeys = new HashSet<String>(map1.keySet());
				System.out.println("unionKeys ->"+unionKeys);
				unionKeys.addAll(map2.keySet());
				System.out.println("unionKeys1 ->"+unionKeys);
				
				unionKeys.removeAll(map1.keySet());
				//logs.info("Keys to remove"+unionKeys);
				System.out.println("unionKeys2 ->"+unionKeys);
				for(String KeysToRemove : unionKeys) {
					System.out.println("KeysToRemove ->"+KeysToRemove);
					map2.remove(KeysToRemove);
					MapDifference<String, String> mapDifference = Maps.difference(map1, map2);
					System.out.println("mapDifference ->"+mapDifference);
				
			
				}
			
		}
		

	}

}
