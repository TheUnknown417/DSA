public class Keypad {

    static  String[] keypad = {" " , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" ,"yz"} ;

    public static void display_keyboard_patterns(String str , int index , String combinations)
    {
        if(index==str.length())
        {
            System.out.println(combinations);
            return;
        }

        char current_char = str.charAt(index);
        String mapping = keypad[current_char - '0'];


        for(int i = 0 ; i<mapping.length() ; i++)
        {
            display_keyboard_patterns(str , index+1 , combinations+mapping.charAt(i));
        }

    }

    public static void main(String[] args) {

        display_keyboard_patterns("24" +
                "" , 0 , "");


    }
}
