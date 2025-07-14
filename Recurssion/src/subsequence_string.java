import java.util.HashSet;

public class subsequence_string {

    public static void subsequences(String str , int index , String newstr , HashSet<String> set)
    {
        if(index==str.length())
        {
            if(set.contains(newstr))
            {
                return;
            }
            else
            {

                System.out.println(newstr);
                set.add(newstr);
                return;
            }


        }

        char current_character = str.charAt(index);

        // to be
        subsequences(str , index +1 , newstr+current_character,set);

        // not to be
        subsequences(str , index +1 , newstr , set);

    }

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        subsequences("AAA" , 0, "", set);
    }

}
