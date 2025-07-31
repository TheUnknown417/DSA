public class DLL {
    Node head = null;
    Node tail = null;
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data= data;
            next = null;
            prev = null;

        }
    }

        public void addatfirst( int data)
        {
            Node newnode = new Node(data);
            if (head == null)
            {
                head = newnode ;
                tail = newnode ;
                return ;
            }

            newnode.next = head ;
            head.prev = newnode ;
            head = newnode ;
        }

    public void addatlast( int data)
    {
        Node newnode = new Node(data);
        if (head == null)
        {
            head = newnode ;
            tail = newnode ;
            return ;
        }

        tail.next = newnode ;
        newnode.prev = tail ;
        tail = newnode ;
    }

    public void addatcertain(int data , int pos)
    {
        Node newnode = new Node(data) ;

        // if at start
        if(pos == 0)
        {
            addatfirst(data);
        }
        // Traverse to the desired position

        Node curr = head ;
        for(int i=0 ; i<pos && curr!= null ; i++)
        {
            curr = curr.next ; // jo delete krma tha wahan agay

        }

        // If the current node is null, it means position is out of bounds
        if (curr == null) {
           addatlast(data);
            return;
        }

        // Set the links to insert the new node before 'curr'
        newnode.next = curr;        // New node's next will point to 'curr'
        newnode.prev = curr.prev;   // New node's prev will point to 'curr's previous node

        // Update the previous node of 'curr' to point to the new node
        if (curr.prev != null) {
            curr.prev.next = newnode;
        }

        // Update 'curr's previous to the new node
        curr.prev = newnode;




    }

    public void delfirst()
    {

        if(head== null)
        {
            System.out.println("List is empty");
            return;
        }
        head = head.next ;
        head.prev = null ;
    }

    public void dellast()
    {

        if(head== null)
        {
            System.out.println("List is empty");
            return;
        }
        if(head.next == null)
        {

            head = null ;
            tail = null ;
            System.out.println("Eik element bhi gya");

        }

        Node to_be_del = tail ;
        to_be_del.prev.next = null ;

        //updating the tail
        tail = to_be_del.prev ;
    }

    public void delatcertain(int pos)
    {
        if(head==null)
        {
            System.out.println("list is empty");
            return;
        }
        if(pos==0)
        {
            delfirst();
            return;
        }

        Node curr = head ;
        for(int i = 0 ; i<pos-1 ; i++)
        {
            if(curr ==null || curr.next==null)
            {
                System.out.println("Out of bonds");
            }
            curr = curr.next ;
        }

        // Update the links to remove the node at position `pos`
        Node nodeToDelete = curr.next;
        curr.next = nodeToDelete.next;  // Bypass the node to be deleted

        // If we are not deleting the last node, update the prev pointer of the next node
        if (nodeToDelete.next != null) {
            nodeToDelete.next.prev = curr;
        } else {
            // If we are deleting the last node, update the tail
            tail = curr;
        }

        nodeToDelete = null;  // Free the node (optional, helps readability)


    }



        public void printDll_using_head()
        {
            Node curr = head ;
            if(head== null )
                System.out.println("BSDK list is empty");

            System.out.print("Null" + "<->" );
            while(curr!=null)
            {
                System.out.print(curr.data + "<->");
                curr=curr.next ;
            }
            System.out.println("Null");

        }

    public void printDll_using_tail()
    {
        Node curr = tail ;
        if(head== null )
            System.out.println("BSDK list is empty");

        System.out.print("Null" + "<->" );
        while(curr!=null)
        {
            System.out.print(curr.data + "<->");
            curr=curr.prev ;
        }
        System.out.println("Null");

    }

    public static void main(String[] args) {
        DLL ll = new DLL() ;
        ll.addatfirst(2);
        ll.addatfirst(3);
        ll.addatfirst(5);
        ll.addatlast(10);
        ll.addatcertain(17 ,2);

       ll.delfirst();
        ll.dellast() ;
        ll.delatcertain(2);




        ll.printDll_using_head();
       // ll.printDll_using_tail();
    }









}
