public class Inverted_Half_Pyramid {

    public static void main(String[] args) {
       int height = 5 ;
       /* int x = 5 ;

        for(int i=1 ; i<=height ; i++)
        {
            for(int j=1 ; j<=x ; j++)
            {
                System.out.print("*");
            }
           x-- ;
            System.out.println();
        }
     */

        // Efficient solution

        for(int i = height ; i>=1 ; i--)
        {
            for(int j=1 ; j<=i ; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }


    }
}
