import java.util.Scanner;

public class Circualr_queue_using_LL {

    Node front ;
    Node rear ;

    class Node
    {
        int data ;
        Node next;

        public Node( int data)
        {
            this.data = data;
            next = null;
        }

    }


    public Boolean isFull()
    {
        return rear.next == front ;

    }

    public Boolean isEmpty()
    {
        return front==null && rear==null ;

    }

    public void Enqueue(int data)
    {
        Node newNode = new Node(data);

        //first insertion
        if(isEmpty())
        {
            front = rear = newNode;
            rear.next = front;  // Circular link establish kiya
            return;
        }
        rear.next = newNode;
        rear = newNode;
        rear.next = front ;


    }

    public int Dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        int to_be_del = front.data;
        //single element deletion
        if(front == rear)
        {
            front=rear=null;
            return -1 ;
        }

        front = front.next;
        rear.next = front ;    // Circular link establish kiya (NEW FRONT K SATH)
        return to_be_del ;


    }


    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return ;
        }
        Node temp = front;
       do
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }while(temp!=front);

        System.out.println();

    }


    public static void main(String[] args) {

        Circualr_queue_using_LL CLQ = new Circualr_queue_using_LL();
        CLQ.Enqueue(1);
        CLQ.Enqueue(2);
        CLQ.Enqueue(3);
        CLQ.Enqueue(4);
        CLQ.display();
        CLQ.Dequeue();
        CLQ.display();
        CLQ.Enqueue(36);
        CLQ.Enqueue(44);
        CLQ.Enqueue(37);
        CLQ.display();
    }



}
