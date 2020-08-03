import java.util.HashSet;


public class Contain {
	
	public static boolean Solution (int[] nums) {
		HashSet<Integer> Set = new HashSet<Integer>();
		for(int i:nums) {
			if(Set.contains(i)) {
				return true;
			}
			else {
				Set.add(i);
			}
			
		}
		return false;
		}

	public static void main(int[] args) {
		// TODO Auto-generated method stub
		
	    int[] nu= {1, 2, 3, 4};
	   boolean output = Solution(nu);
	   System.out.print(output);
         

	}

}
