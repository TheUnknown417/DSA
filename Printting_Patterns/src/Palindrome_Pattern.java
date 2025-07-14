public class Palindrome_Pattern {
    public static void main(String[] args) {

        int n = 5 ;

        for(int i=1 ;  i<=n ; i++)
        {
            //spaces
            for(int j=1 ; j<=n-i ; j++)
            {
                System.out.print(" ");
            }

            // Backward traversal
            for(int k=i ; k>=1 ; k--)
            {
                System.out.print(k);
            }

            // forward traversal
            for(int l=2 ; l<=i ; l++)
            {
                System.out.print(l);
            }

            System.out.println();
        }
    }

}
