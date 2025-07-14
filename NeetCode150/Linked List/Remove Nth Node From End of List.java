class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null)
        {
            return null ;
        }

        // using an array list (sirf is liyay usr kri ta k pta lg jay konsi node delete krni hai)

        List<ListNode> list = new ArrayList<>() ;

        ListNode temp = head ;
        while(temp!=null)
        {
            list.add(temp);
            temp = temp.next ;
        }

        int index_to_remove = list.size()-n ; 

        // agr head say removal hu
        if(index_to_remove==0)
        {
            return head.next ;
        }
        

        // now just have to skip the node to be 
        // delete honay wali k peechay wali ko , delete honay wali k agay k sath mila detay hain

        ListNode prevNode = list.get(index_to_remove -1 ) ;
        prevNode.next = list.get(index_to_remove ). next ;

        
        return head ;             
    }


     // Solution 2 

    public ListNode removeNthFromEnd2(ListNode head, int n)
    {
        // two pointers and a Dummy Node before head ;

        ListNode Dummy = new ListNode(0,head) ; // means dummy k next pr head 

        ListNode fast = Dummy , slow = Dummy ;

        // moving fast pointers n+1 times 
        for(int i =0 ; i<=n ; i++)
        {
            fast = fast.next ;
        }

        // now moving slow , until fast reaches null

        while(fast!=null)
        {
            slow = slow.next ;
            fast = fast.next;
        }

        // slow will point previous to the node to be deleted 

        slow.next = slow.next.next ;

        return Dummy.next; // pretty useful when revomal is from head 

    }
}


