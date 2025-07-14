class Solution {
    public int[] twoSum(int[] array, int target) {

        int i ,j ;
        for(i=0 ; i< array.length ; i++)
        {
            for(j=i+1 ; j<array.length ; j++)
            {
                if(array[i]+array[j]==target)
                {
                    return new int[] {i,j};
                }
            }
        }

        return new int[0];
        
    }

 // Solution 2 

    public int[] twoSum1(int[] array, int target) {

          //using a hashmap

        Map<Integer, Integer> checker = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            checker.put(array[i], i); // element or us k sath uska index
        }


        // ab hr index ki value k liyay difference nikal kr check krein gy k hashmap mei majood hai k nahi
        // agr majood howa tu us index ko i , or hashmap mei difference ki respective value ko j bna dein gy

        for (int i = 0; i < array.length; i++)
        {
            int diff = target -array[i] ;

            if(checker.containsKey(diff) && checker.get(diff)!=i)
                return new int[] {i,checker.get(diff)} ;

        }

        return new int[] {} ;
    
  
    }


 // Solution 3

    public int[] twoSum3(int[] array, int target) {
         //using a hashmap

        Map<Integer, Integer> checker = new HashMap<>();


        for (int i = 0; i < array.length; i++)
        {
            int num = array[i];
            int diff = target -array[i] ;

            if(checker.containsKey(diff)) {
                return new int[]{checker.get(diff), i};
            }

            checker.put(num , i) ;

        }

        return new int[] {} ;
      
        
    }
}