import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class Solution {
	 public static List<List<String>> groupedAnagrams(String[] Str){
	        List<List<String>> groupedAnagrams= new ArrayList<>();
	        HashMap<String, List<String>> map = new HashMap<>();
	        for(String Current: Str){
	            char[] Characters= Current.toCharArray();
	            Arrays.sort(Characters);
	            //System.out.print(Characters);
	            String Sorted = new String(Characters);
	            if(!map.containsKey(Sorted)){
	                map.put(Sorted, new ArrayList<>());
	                
	            }
	            map.get(Sorted).add(Current);
	            
	        }
	        groupedAnagrams.addAll(map.values());
	        return groupedAnagrams;
	        }
	

public static void main(String[] args) {
	String[] ana =  {"eat", "tea", "ate", "nat", "bat", "tan"};
	 List<List<String>> output = groupedAnagrams(ana); 
	 System.out.print(output);
	
}
}
