public class Inverted_Half_pyramid_by_180 {
    public static void main(String[] args) {

        int n =4 ;

        for(int i=1 ; i<= n ; i++)
        {

            // inner loop for spaces
            for(int j=1 ; j<=n-i ; j++)
            {
                System.out.print(" ");
            }
            //inner loop for stars
            for(int k=1 ; k<=i ; k++)
            {
                System.out.print("*");
            }

            System.out.println();

        }
    }

}
