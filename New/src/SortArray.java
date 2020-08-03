import java.util.*;
class SortArray implements Comparator<Integer> {
	public int compare(Integer number1, Integer number2) {
		return number2.compareTo(number1);
	}
public  class Main{
    public static void main (String[] args) {
		// TODO Auto-generated method stub
	Integer numbersArray[] = {12,13,11};
	Arrays.sort(numbersArray, new SortArray());
	for(int number : numbersArray) {
		System.out.print(number+" ");
	}
		

	}

}
