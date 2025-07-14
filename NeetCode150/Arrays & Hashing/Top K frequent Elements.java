public class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Bucket Sort 
        List<Integer> [] freq = new List[nums.length+1] ;
        Map<Integer , Integer> map = new HashMap<>();

        // freq k hr index pr eik arraylist rakh dein gy except zero cuz 0 frequency nahi hosakti
        for(int i =1 ; i<freq.length ; i++)
        {
            freq[i] = new ArrayList<>();
        }
       

        // hashmap to determine frequencies 
        for(int n : nums)
        {
            map.put(n , map.getOrDefault(n,0) +1 ) ;
        }
        

        // hashmap ko use krtay howay frequencies k according elements of unki respective arraylist mei add krtay jaien gy

        //new trick to iterate through k hashmap using for each
        for(Map.Entry<Integer , Integer> entry : map.entrySet())
        {
            // entry woh eik order pair hai jo entery set k andr traverse kray ga 

            freq[entry.getValue()].add(entry.getKey()) ;

        }
        
        

        // AT last , we have to make the res[]  jis ki lenght k hai or 
        // freq ko peechay say traverse krtay howay res[] mei elements add krtay jaien gy 

        int res [] = new int[k] ;
        int index = 0 ;

        for(int i=freq.length-1 ; i> 0 && index < k ; i--)
        // outer loop is to traverse freq List
         {   
            for(int n : freq[i])
            // inner loop us arraylist mei traverse kray ga jo freq k kisi index pr pari hoge
            {
                res[index++] = n ;
                if(index==k)  // hoskta hai k eik he arraylist say pora hojay 
                return res ;

                    
            }
        }  
        
        return res ;
}


 // Solution 2 

public int[] topKFrequent2(int[] nums, int k) {

        //sorting 
        Map<Integer , Integer> map = new HashMap<>() ;
        List<int[]> arr = new ArrayList<>() ;

        for(int n : nums)
        {
            map.put(n,map.getOrDefault(n,0)+1) ;
        }

        for(Map.Entry<Integer , Integer> entry : map.entrySet())
        {
            arr.add(new int[] {entry.getValue() , entry.getKey() }) ; // hr index pr(freq , element) store hogy

        }

        // ab freq k according sort krelin gy descending order mei 
        arr.sort((a,b)-> b[0] - a[0]) ;// bari freq shroo mei ati jay ge 

        // ab hr (freq , element) pair mei say K number of elements res mei store krwa lein gy
        int res[] = new int[k]; 
        for(int i=0 ; i<k ; i++)
        {
            res[i] = arr.get(i)[1]; // inner array_pair mei index 1 pr element pra hoga 
        }

        return res ;
}
}