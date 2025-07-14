class Solution {
    public ListNode reverseList(ListNode head) {
        // recursion 

        if(head == null)
        {
            return null ;
        
        }

        ListNode newhead = head ;

        if(head.next!=null)
        {
            newhead = reverseList(head.next);
            head.next.next = head ;
        }

        head.next=null ;

        return newhead ;
        
    }


    // Solution 2 

     public ListNode reverseList2(ListNode head) {

        // iterrative
        ListNode prev = null ;
        ListNode curr = head ;

        while(curr!=null)
        {
            ListNode next = curr.next ;
            curr.next = prev ;  // reversing the link 

            // moving curr and prev one step forward
            prev = curr ;
            curr = next ;

           
        }

        return prev ; // curr tu null tk chala jay ga , or prev us say eik peechay last node 
                        //jo k reversed linkedlist ka first node(head) hoga 


     }
}