class Solution {
    public int[] productExceptSelf(int[] nums) {
        // BRUTE FORCE 

         int till = nums.length ;
        int [] newarr = new int [till] ;

        for(int i =0 ; i<till ; i++)
        {
            int product = 1 ;
            for(int j=0 ; j<till ; j++)
            {
                if(i!=j)
                {
                    product*=nums[j];
                }
            }

            newarr[i]= product ;
        }

        return newarr ;
    }



 // Solution 2 

    public int[] productExceptSelf2(int[] nums) {
        // DIVISION METHOD 
         int till = nums.length ;

        // DETERMINE THE TOTAL PRODUCT ;
        int product = 1 ;
        int zero_count = 0 ;

        for(int n : nums)
        {
            if(n!=0)
            { product*=n; }

            else 
                zero_count++ ;
        }

        if(zero_count>1)  // no chance , All products will be zero
            return new int[till] ;

        // array with one zero or Non
        int [] res = new int[till] ;
        for(int i =0 ; i<till ; i++)
        {
            if(zero_count>0)
               { res[i] = (nums[i]==0) ? product : 0 ;  } // woh index pr jahan zero hai , us k ilawa saray products 0 
                                                          // or us 0 k liyay product already calculated above 
            else
               { res[i] = product/nums[i]; }
        }
        return res ;
         
    }


 // Solution 3

    public int[] productExceptSelf3(int[] nums) {
        int n = nums.length ;
        int [] res = new int[n] ;
        int [] pre = new int[n] ;
        int [] post = new int[n] ;

        // pre k first mei or post k last mei 1 rakhna pray ga , q k un k agay peechay kuch nahi 
        pre[0] = 1 ;
        post[n-1] = 1 ;

        // setting pre array , jis mei hr index hr us say phelay walay indexes ka product hoga
        for(int i = 1 ; i<n ; i++)
        {
            pre[i] = pre[i-1]* nums[i-1] ;
        }

         // setting post array, jo last-1 index say shroo hoge aur , jis mei hr index hr us say peechay walay indexes ka product hoga

        for(int i = n-2 ; i>=0 ; i--)
        {
            post[i] = post[i+1] * nums[i+1];

        }

        // combining results 

        for(int i = 0 ; i<n ; i++)
        {
            res[i] = pre[i] * post[i] ;
        }

        return res ;

    }

 // Solution 4

    public int[] productExceptSelf4(int[] nums) {
    
    // memory efficent 
    // direct res array mei prefix store krwaein gy 
    // then hr iteration pr post nikal kr res say multiply krdy gein 
          
    int n = nums.length ;
    int [] res = new int[n] ;
    res[0] = 1 ;

    for(int i = 1 ; i<n ; i++)
    {
        res[i] = res[i-1]* nums[i-1] ;
    }

    int post = 1 ;

    for(int i=n-2 ; i>=0 ; i--)
    {
      
        post *= nums[i+1] ; 
        res[i]*= post ;  // res[i] means respective suffix ;
    }

    return res ;    
    
    }
}  