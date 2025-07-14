class Solution {
    public boolean isValid(String s) {

        // use while loop jb tk string valid parenthese ka koi bhi group majood hai
        while(s.contains("()") || s.contains("{}") || s.contains("[]"))
        {
            s = s.replace("()" , "") ;
            s = s.replace("{}" , "") ;
            s = s.replace("[]" , "") ;
        }

        // agr valid string hoge to loop k baad empty hogy hoge

        return s.isEmpty() ;
        
    }

   

    // Solution 2 

    public boolean isValid2(String s) {

        // using stack and hashmap
         Stack<Character> stack = new Stack<>();
       Map<Character, Character> map = new HashMap<>();


       // defining our hashmap
        // every closing is a key , and opening is the respective value for it
        map.put(')' ,'(') ;
        map.put('}' ,'{') ;
        map.put(']' ,'[') ;


       for( char c : s.toCharArray())
       {
           // closing agy
           if(map.containsKey(c))
           {
               if(!stack.isEmpty() && stack.peek() == map.get(c))
               {
                   stack.pop();
               }
               else
                   return false ;
           }
              // opening agy
            else
                stack.push(c);
       }

       // agr valid expression hoga tu stack empty hojay ga

        return stack.isEmpty() ;



    }



}
