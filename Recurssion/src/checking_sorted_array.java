public class checking_sorted_array {

    static Boolean result ;
    public static Boolean Check_sort(int arr[] , int index)
    {
        if(index== arr.length-1)
        {
            return true ;

        }


        if(arr[index]<arr[index+1])
           return Check_sort(arr , index+1) ;
        else
           return false ;



    }


    public static void main(String[] args) {
        int arr [] = {2,1,3,4,5} ;
        Boolean res = Check_sort(arr , 0) ;
        if(res==true)
        {
            System.out.println("Sorted");
        }
        else
        {
            System.out.println("Unsorted");
        }

    }
}
