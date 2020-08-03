
public class movezero {
	
	

	public static void main(String[] args) {
		int[] n= {0,1,0,2,3,4};
		 int[] output= sol(n);
		 System.out.print(output);
		
	}

	private static int[] sol(int[] n) {
		
		int index=0;
		for(int i=0; i<n.length;i++) {
			if(n[i]!=0) {
				n[index++] = n[i];
				System.out.println(n[i]);
				System.out.println("index value" +index);
				
			}
		}
		for (int i=index; i<n.length;i++) {
			n[i]=0;
			System.out.println(n[i]);
		}
		return n;
	}

}
