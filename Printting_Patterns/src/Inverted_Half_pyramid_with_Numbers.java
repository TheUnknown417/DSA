public class Inverted_Half_pyramid_with_Numbers {

    public static void main(String[] args) {
        int n = 5 ;
/*
        for(int i=n ; i>=1 ; i--)
        {
            for(int j =1 ; j<=i ; j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }*/

        // another way of doing it
        for(int i=1 ; i<=n ; i++)
        {
            for(int j =1 ; j<=n-i+1 ; j++)
            {
                System.out.print(j);
            }
            System.out.println();
        }

    }
}
