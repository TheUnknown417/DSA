public class Printing_Numbers {

    public static void Print_numbers(int n )
    {
        if(n==0)
            return;

        System.out.println(n);
        Print_numbers(n-1);
    }

    public static void Print_numbers(int n , int m )
    {
        if(n==m+1)
            return;

        System.out.println(n);
        Print_numbers(n+1 , m);
    }




    public static void main(String[] args) {
        int n= 10 ;

       // Print_numbers(n);
        Print_numbers(1,10);
    }
}
