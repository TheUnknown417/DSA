public class fibonacci {

    // this function will give the nth term in the sequence
    public static int fib(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        return fib(n-1) + fib(n-2) ;
    }

    // this function will print the entire pattern without using a loop
    public static void fib(int a , int b , int n)
    {
        if(n==0)
        {
            return;
        }

        int c = a+b ;
        System.out.println(c);
        fib(b,c,n-1);


    }


    public static void main(String[] args) {

        int n = 10 ;
        int sum = 0;
        // entire sequence (but considering number of elements instead of index)
        for(int i=0; i<=n-1 ; i++)
        {
            System.out.println(fib(i));
            sum+=fib(i);
        }
        System.out.println("Sum of Fib series : " + sum);

        int a = 0 ;
        int b = 1 ;
        System.out.println(a);
        System.out.println(b);
        fib(a,b,n-2);

    }
}
