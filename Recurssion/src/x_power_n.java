public class x_power_n {


                                                // stack height = n

//     simple approach
//    public static int Cal_pow(int x , int n)
//    {
//        if(n==0)
//            return 1 ;
//        if(x==0)
//            return 0 ;
//
//        return x * Cal_pow(x, n-1);
//    }

    // Youtube approach (involving extra variables )
//    public static int Cal_pow(int x , int n)
//    {
//        if(n==0)
//            return 1 ;
//        if(x==0)
//            return 0 ;
//
//        int xpownm1 = Cal_pow(x,n-1);
//        int xpown = x * xpownm1 ;
//        return xpown ;
//    }


                                             // stack height = logn

    public static int Cal_pow(int x , int n)
    {
        if(n==0)
            return 1 ;
        if(x==0)
            return 0 ;

        if(n%2==0) // n is even
            return Cal_pow(x ,n/2) *  Cal_pow(x ,n/2) ;

        else // n is odd
            return Cal_pow(x ,n/2) *  Cal_pow(x ,n/2) * x ;

    }



    public static void main(String[] args) {

        System.out.println(Cal_pow(2,5));

    }
}
