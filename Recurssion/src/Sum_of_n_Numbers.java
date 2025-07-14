public class Sum_of_n_Numbers {

    public static int Sum(int n )
    {
        if(n==0)
        {
            return 0 ;
        }

        return n + Sum(n-1) ;
    }

    public static int Sum(int n , int m)
    {
        if(m==0)
        {
            System.out.println("Not possible , Enter a Valid Range");
            return Integer.MIN_VALUE ;

        }

        if(n==m)
            return m ;

        return n + Sum(n+1 , m);

    }

// backward sum
 /*   public static int Sum(int m , int n)
    {
        if(m==n)
            return n ;

        return m + Sum(m-1 , n);

    }*/

    public static void main(String[] args) {
        int n = 5 ;
        System.out.println(Sum(100));
        System.out.println(Sum(1,100));

    }
}
