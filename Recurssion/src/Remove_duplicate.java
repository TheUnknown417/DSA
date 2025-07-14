public class Remove_duplicate {

    public static boolean[] map = new boolean[26];

    public static void remove_duplicate(String str , int index , String newstr)
    {
        if(index==str.length())
        {
            System.out.println(newstr);
            return;
        }

        char current_character = str.charAt(index);
        if(map[current_character - 'a'])
        {
            remove_duplicate(str , index+1 , newstr);
        }
        else
        {
            newstr+=current_character;
            map[current_character -'a'] = true ;
            remove_duplicate(str , index+1 , newstr);
        }

    }

    public static void main(String[] args) {

        remove_duplicate("daaaouddzz", 0 ,"") ;
    }

}
