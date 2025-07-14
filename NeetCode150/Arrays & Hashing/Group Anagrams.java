class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

      // using sorting

        Map<String , List<String>> map = new HashMap<>() ;

        for(String s : strs)
        {
            char[] char_arr = s.toCharArray() ;
            Arrays.sort(char_arr);
            String sorted_String = new String(char_arr) ;
            map.putIfAbsent(sorted_String , new ArrayList<>()) ;
            map.get(sorted_String).add(s);
        }


        ArrayList<List<String>> list = new ArrayList<>(map.values()) ;
        System.out.println(list);

        return list ;
    }


 // Solution 2 

     public List<List<String>> groupAnagrams2(String[] strs) {

        Map<String , List<String>> map = new HashMap<>() ;


        for(String s : strs)
        {
            char[] char_array = s.toCharArray() ;
            int [] char_count = new int[26] ;  // key bnanay wali arary 
            // making the 26 letter key
            // phelay array 01 ki array bnay ge phir usko istemal mei lanay k liyay string mei convert krein gy
            for(char c : char_array)
            {
                char_count[c-'a']++;  // creation of unique key 
            }

            String key = Arrays.toString(char_count) ;
            map.putIfAbsent(key , new ArrayList<>()) ;
            map.get(key).add(s) ;

        }


        return new ArrayList<>(map.values()) ;
       
     }
}