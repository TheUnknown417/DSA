class Solution {


     public boolean hasDuplicate(int[] nums) {
            // for un-sorted array 
        for(int i=0 ; i< nums.length ; i++)
        {

           for(int j=i+1 ; j<nums.length ; j++)
           {
                if(nums[i]==nums[j])
                return true ;
           }

        }

        return false ;


    }

    // sorting
    // Solution 2 
public boolean hasDuplicate2(int[] nums) {

    Arrays.sort(nums) ;

    for(int i=0 ; i< nums.length -1 ; i++)
        {
           if(nums[i]==nums[i+1])
           {
                return true;
           }    
        }

             return false ;
}


 // Solution 3

public boolean hasDuplicate3(int[] nums) {

    Set<Integer> seen = new HashSet<>();

    for(int num : nums)
    {
        if(seen.contains(num))  
            return true ;

        seen.add(num);
    }
    return false ;
             
}

 // Solution 4

public boolean hasDuplicate4(int[] nums) {

   return Arrays.stream(nums).distinct().count() < nums.length ;
}


}