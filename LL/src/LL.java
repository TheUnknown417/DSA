import java.util.LinkedList;

class LL {
    private static int size;

    LL() {
        this.size = 0;
    }

    Node head;

    class Node {


        String data;
        Node next;


        public Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }

    }

    public void addfirst(String s) {
        Node newnode = new Node(s);
        if (head == null) // linked list is empty
        {
            head = newnode; // pointing head to new node
            return;
        }

        // agr nahi
        newnode.next = head; // newnode ko 1st node say phelay link kra
        head = newnode; // or head ab newnode ko bnadia


    }

    public void addlast(String s) {

        Node newnode = new Node(s);
        if (head == null) // linked list is empty
        {
            head = newnode; // pointing head to new node
            return;
        }


        /* we will never change our head ,
         instead we will point another node towards head ,
          this node will be used for traversing*/

        Node currnode = head; // head ko change krnay ki zaroort nahi

        //traversing ( null say pecchay poncha dy ga)
        while (currnode.next != null) {
            currnode = currnode.next;

        }

        currnode.next = newnode;


    }


    // Method to add a node at a specific position
    public void addAtPosition(String data, int position) {
        Node newnode = new Node(data);
        if(position == 0) // shroo mei
        {
            newnode.next = head ;
            head = newnode ;
            return ;

            // can also use addfirst()
        }
        // beech mei khein bhi
        Node currnode = head;
        for(int i =0 ; i<position-1 &&  currnode!=null ;i++ )
        {
            currnode = currnode.next;
        }
        newnode.next = currnode.next;
        currnode.next = newnode;
    }

    public void delfirst() {


        if (head == null) // linked list is empty
        {
            System.out.println("Nothing in the list to delete");
            return;
        }


        head = head.next; // head ab sb say phelay element ko point nahi kr raha
        size--;
    }


    public void dellast() {


        if (head == null) // linked list is empty
        {
            System.out.println("Nothing in the list to delete");
            return;
        }

        size--;
        // agr list mei sirf eik he element hai
        if (head.next == null) {
            head = null;
            System.out.println();
            System.out.println("Eik element bhi gya");
            return;
        }


        Node seclast = head;
        Node last = head.next;


        while (last.next != null) {
            last = last.next;
            seclast = seclast.next;
        }

        seclast.next = null; // end say gya


    }


    // Method to delete a node at a specific position
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) { // Remove the head
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {  // current ko delete honay walay node say peechay tk ponchaa dy ga
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        Node nodetoDelete = current.next;
        current.next = nodetoDelete.next;
    }


    public void printlist() {
        if (head == null) // linked list is empty
        {
            System.out.println("List is empty ....");
            return;
        }

        Node currnode = head;
        while (currnode != null) {
            System.out.print(currnode.data + "->");
            currnode = currnode.next;
        }

        System.out.print("NULL"); //end of list

    }


    //iterative
    public void reverse_Linkedlist() {
        if (head == null || head.next == null) {
            System.out.println("BSDK List is empty...or already reversed.");
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            // positions update hongi hr new link tootnay or jurnay pr
            prev = curr;
            curr = next;

        }

        // phela link jo toota nahi tha
        head.next = null;
        // head ko end pr rakhna
        head = prev;
    }

    // recursive
    public Node reverse_Linkedlist(Node head) {
        if (head == null || head.next == null) {
            return head;

        }
        Node newhead = reverse_Linkedlist(head.next);
        head.next.next = head;
        head.next = null;
        return newhead ;
    }





    public static void main(String[] args) {



        LL list = new LL();

        list.addlast("Daoud");
        list.addlast("Haroon");
        list.addlast("is");
        list.addlast("a");
        list.addlast("Genius");


        


        list.printlist();


        System.out.println();

        list.addAtPosition("xx" , 2);


        list.printlist();
        System.out.println();

        list.deleteAtPosition(1);
        list.printlist();
       // System.out.println("size =" + size);

       /* list.reverse_Linkedlist();
        System.out.println();
       list.printlist();
*/


    }


}