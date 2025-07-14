class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
        {
            return false ;
        }
        
        char[] s_array = s.toCharArray() ;
        char[] t_array = t.toCharArray() ;

        Arrays.sort(s_array);
        Arrays.sort(t_array);

        return Arrays.equals(s_array , t_array) ;

    }


   // Solution 2

     public boolean isAnagram2(String s, String t) {

         // chars ki inventory
        int [] char_count = new int[26] ; // intially sb zero

        for(int i=0 ; i<s.length() ; i++)
        {
            char_count[s.charAt(i)-'a']++ ; // jo jo char milta hai make value 1 at that index 
            char_count[s.charAt(i)-'a']--;  // agr dosri string mei bhi woh same char milta hai , us index pr 1 hoga usko 0 krdia 
        }

        for(int count : char_count)
        {
            if(count!=0)          // eik bhi other than 0 mil gya , means dono string mei woh unique element hai 
                return false ;
        }

        return true ;                   // pori array mei 0 honay chaheyay , maatlab jo sting1 mei ay thay woh sb string 2 mei bhi agy 
                                        // tu saray 1s 0s hogay ..

    }



}