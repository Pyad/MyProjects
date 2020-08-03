import java.util.HashMap;


public class Contains {
	
	public static boolean Solution (int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<nums.length; i++) {
			int current = nums[i];
			System.out.print(current);
			if(map.containsKey(current) && i-map.get(current)<=k) {
				return true;
			}
			else {
				map.put(current, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    int[] nu= {1,2,3,1,2,3};
	    int n= 3;
	   boolean output = Solution(nu, n);
	   System.out.print(output);
         

	}

}
