public class String_operations {

    // reversing the string

    public static void reverse_str(String str , int n) {
        if(n==-1)
            return;

        System.out.print(str.charAt(n));

        reverse_str(str , n-1);
    }


    // Indexes of first and last occurrences
    public static int first = -1 ;
    public static int last = -1 ;

    public static void find_Occurrence(String str , Character key ,int index)
    {

        if(index==str.length())
        {
            System.out.print("first : " + first + " last : " + last);
            return;
        }
        if(str.charAt(index)==key)
        {
            if(first==-1)
            {first = index ;}
            else
            {
                last= index;
            }
        }

        find_Occurrence(str , key , index +1 );

    }


    public static void main(String[] args) {
        String str = "ABCD" ;
       // reverse_str(str , str.length()-1);

        String str1 = "sddfdaeeddskaskdieoka" ;

        find_Occurrence(str1 , 'd' , 0 );


    }
}
