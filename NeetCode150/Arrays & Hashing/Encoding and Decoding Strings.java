class Solution {

    public String encode(List<String> strs) {

        StringBuilder newstr = new StringBuilder() ;
        for(String s : strs)  // eik eik string ko uski lenght + special character k sath eik single string mei merge krein gy 
        {
            newstr.append(s.length()).append('#').append(s);
        }

        return newstr.toString() ;
    }

    public List<String> decode(String str) {

        List<String> arr = new ArrayList<>() ;

        int i=0 ;
        while(i<str.length() ) 
        {
            int j = i ;

            while(str.charAt(j)!='#')
            j++;

            int length = Integer.parseInt(str.substring(i,j)) ; // asal string say phelay uski lenght written thi

            i = j+1 ;
            j = i+length;

            arr.add(str.substring(i,j));

            i=j;
 
        }

        return arr ;



    }
}