package nepar;

public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[] c = {'j','a','v','a'};
		String s1 = new String(c);
		
		for(int i=0; i<s1.length();i++) {
			System.out.println(c[i]);
		}

		
		Integer i =22,j=29;
		System.out.println(i.toString()+j);
		
		String st = "Inception";
		//char l = st.charAt(5);
		//System.out.println(l);
		int start = 2;
		int end = 8;
		char[] buf = new char[end-start];
		st.getChars(start, end, buf, 0);
		System.out.println(buf);
		//System.out.print(st.getChars(start, end, buf, 0));
//		for(int k=0; k<st.length();k++) {
//		System.out.print(st.codePointAt());
//	
//		}
		
		
		
		
		
		
		
		
		
		
	}

}
