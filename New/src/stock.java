
public class stock {

	public static int maxprofit(int[] prices) {
		int max=0;
		int min = Integer.MAX_VALUE;
		for (int i=0; i< prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				}
			else {
				max =Math.max(max, prices[i]-min);
			}
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int[] stk= {7,6,4,3,1};
		int output = maxprofit(stk); 
		System.out.print(output);
		

	}

}
