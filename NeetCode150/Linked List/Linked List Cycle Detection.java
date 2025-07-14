class Solution {
    public boolean hasCycle(ListNode head) {

        // using hashset

        Set<ListNode> set = new HashSet<>() ;

        ListNode curr = head ;

        while(curr!=null)
        {

            if(set.contains(curr))
            {
                return true ;
            }

            set.add(curr);
            curr = curr.next ;
        }

        return false ;
        
    }

   
    // Solution 2 

     public boolean hasCycle2(ListNode head) {
        // fast slow pointers 
       ListNode fast = head ;
       ListNode slow = head ;

       while(fast!=null && fast.next!=null)
       {
            fast = fast.next.next ;
            slow = slow.next ;
            
            if(fast==slow)
            return true ;

       }

       return false ;
        
    }

}