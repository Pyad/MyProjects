package nepar;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Comparelist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		        Collection listOne = new ArrayList(Arrays.asList("milan","dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"));
		        Collection listTwo = new ArrayList(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));

		        listOne.retainAll( listTwo );
		        System.out.println( listOne );
		    }
		}

	
