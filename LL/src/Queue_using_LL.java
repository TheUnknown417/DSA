public class Queue_using_LL
{
    Node head ;
    Node tail ;

    class Node {
        int data;
        Node next;


        public Node(int data) {
            this.data = data;
            next = null;

        }
    }

    public Boolean isempty()
    {

        return head==null && tail == null ;


    }
    public void enqueue(int data)
    {
        Node newnode = new Node(data);

        if(head==null)
        {
            tail =head = newnode ;
            return;
        }

       tail.next = newnode ;
        tail = newnode ;

    }

    public int dequeue()
    {
        if(isempty())
        {
            System.out.println("Empty Queue");
            return -1;
        }
        int to_be_del = head.data;
        // deletion of 1st element
        if(head == tail)
        {
            tail = null ;
        }

        head = head.next ;


        return to_be_del ;
    }

    public int front()
    {
        if(isempty())
        {
            System.out.println("Empty Queue");
            return -1;
        }

        return head.data ;

    }

    public static void main(String[] args) {

        Queue_using_LL q = new Queue_using_LL() ;
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(50);

        while(!q.isempty())
        {
            System.out.println(q.front());
            q.dequeue() ;
        }

        q.front() ;

    }

}
