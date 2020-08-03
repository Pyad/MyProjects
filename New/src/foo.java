public class foo{
    public int foo(int n, int r)
    {
        n= 345;
        r=10;
        int k=0;
        if (n>0){
            
           k= ( n % r + foo(n/r, r));
           System.out.print(k);
        }
        
    }
    
public static void main(String arg[])
    {
        foo x= new foo();
        
    }
    
    
}
