public class reverseString{
    public static String Solution(String s){
        char[] characters= s.toCharArray();
        int i=0;
        int j= s.length()-1;
        while(i<j){
            char temp = characters[i];
            characters[i++] = characters[j];
            characters[j--]= temp;
        }
        return new String(characters);
    }
    public static  void main(String[] args){
       String s="Reverse";
       String output= Solution(s);
       System.out.println(output);
        
    }
}