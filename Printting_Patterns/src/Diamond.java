import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Diamond {
    public static void main(String[] args) {

        int n = 5 ;
// half diamond
        for(int i=1 ; i<=n ; i++)
        {
            //spaces
            for(int j=1 ; j<=(n-i) ; j++)
            {
                System.out.print(" ");
            }

            // stars
            for(int k=1 ; k<= (2*i-1) ; k++)
            {
                System.out.print("*");
            }


            System.out.println();

        }


//other half of Diamond
        for(int i=n ; i>=1 ; i--)
        {
            //spaces
            for(int j=1 ; j<=(n-i) ; j++)
            {
                System.out.print(" ");
            }

            // stars
            for(int k=1 ; k<= (2*i-1) ; k++)
            {
                System.out.print("*");
            }


            System.out.println();

        }

    }

}
