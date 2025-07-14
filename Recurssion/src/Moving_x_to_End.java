public  class Moving_x_to_End {

    public static void Move_all_x(String str , int index , int count , String newstr)
    {
        if(index==str.length())
        {
            for(int i=0 ; i<count ; i++)
            {
                newstr+='x';
            }

            System.out.println(newstr);
                return;
        }

        if(str.charAt(index)=='x')
        {
            count ++;
            Move_all_x(str , index +1 , count , newstr);

        }
        else
        {
            newstr+=str.charAt(index) ;
            Move_all_x(str , index +1 , count , newstr);

        }

    }

    public static void main(String[] args) {

        Move_all_x("abccxddxadx" , 0 , 0 , "");
    }
}
