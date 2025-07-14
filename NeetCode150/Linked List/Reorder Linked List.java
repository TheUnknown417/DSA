class Solution {
    public void reorderList(ListNode head) {
        
        List<ListNode> nodes_list = new ArrayList<>() ;
        ListNode temp = head ;

        // saray nodes ko arraylist mei daldo
        while(temp!=null)
        {
            nodes_list.add(temp) ;
            temp = temp.next ;
        }

        int i = 0 ;
        int j = nodes_list.size() - 1;
        
        // reordering
        while(i<j)
        {

            nodes_list.get(i).next = nodes_list.get(j);
            i++ ;

            if(i>=j) break ;

            nodes_list.get(j).next = nodes_list.get(i);
            j--;

        }

        nodes_list.get(i).next = null ;   // last node k next mei null 
        
    }



    // Solution 2 
    public void reorderList2(ListNode head) {
        // reversing and merging 

    // determining 1st/2nd half 

        ListNode fast = head ;
        ListNode slow = head ;

        while(fast!=null && fast.next!=null)
        {

            fast = fast.next.next ;
            slow = slow.next ; 

        }

        // slow 1st k last node  pr ajay ga

        ListNode second = slow.next ;  // pointing to the start of the 2nd half
        ListNode prev = slow.next = null ; // 2nd half ki reversing k liyay kam ay ga

        // reversing the 2nd half 
        while(second != null)
        {
            ListNode temp_next = second.next ; // reversing mei next ka kam krta hai 

            second.next = prev ;  // establishing the reverse link

            prev = second ;         // forwarding one position 
            second = temp_next ;
        }

        // after the loop , 2nd half will be reversed and prev will be pointing to 
        // the start of that 2nd half

        second = prev ; // now , second is at the start of reversed 2nd half 
        ListNode first = head ;// first is at the start of 1st half 

        // merging 
        while(second!=null)
        {

            ListNode temp1 = first.next ;
            ListNode temp2 = second.next ;

            first.next = second ;
            second.next = temp1 ;

            first = temp1 ;
            second = temp2 ;
        }


    }
}