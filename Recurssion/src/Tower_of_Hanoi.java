public class Tower_of_Hanoi {
    public static void towerofhanoi(int n , String Source , String Helper , String Destination)
    {
        if(n==1)
        {
            System.out.println("Transfer disk " + n + " from " + Source + " to " + Destination);
            return;

        }

        towerofhanoi(n-1 , Source , Destination , Helper );
        System.out.println("Transfer disk " + n + " from " + Source + " to " + Destination);
        towerofhanoi(n-1 , Helper ,Source , Destination );




    }

    public static void main(String[] args) {
        int n = 3 ;
        towerofhanoi(n,"S" , "H" ,"D");
    }
}
