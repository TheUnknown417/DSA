public class Butterfly_Pattern {

    public static void main(String[] args) {

        int n = 18;
// Upper half
        for(int i = 1 ; i <= n ; i++){

            // phelay taray
            for(int j = 1 ; j <= i ; j++){
                System.out.print("*");
            }


           // beech wali spaces
            for(int k = 1 ; k <= 2*(n-i) ; k++){
                System.out.print(" ");
            }

            // baad walay taray
            for(int l = 1 ; l <= i ; l++){
                System.out.print("*");
            }

            System.out.println();
        }


// Bottom half
        for(int i = n ; i >= 1 ; i--){

            // phelay taray
            for(int j = 1 ; j <=i ; j++){
                System.out.print("*");
            }


            // beech wali spaces
            for(int k = 1 ; k <= 2*(n-i) ; k++){
                System.out.print(" ");
            }

            // baad walay taray
            for(int j = 1 ; j <=i ; j++){
                System.out.print("*");
            }

            System.out.println();
        }

    }
}
