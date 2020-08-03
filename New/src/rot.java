
public class rot{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int s = arr.length;
        int[] rot = new int[s];
        int i=0;
        int ri= 3;
        
        while(ri < s){
            rot[i] = arr[ri];
            i++;
            ri++;
        }
      
        ri=0;
        while(ri<3){
            rot[i] = arr[ri];
            i++;
            ri++;
            
        }

        for(int j=0; j<rot.length; j++){
            System.out.print(rot[j]+ " ");
        }
    }
}