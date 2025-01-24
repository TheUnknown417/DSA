public class Circular_Queue_using_array {

    static int size;
    static int relative_size = 0;
    static int front = -1;
    static int rear = -1;
    static int[] arr;


    public Circular_Queue_using_array(int size) {

        arr = new int[size];
        this.size = size;

    }

    public Boolean isEmpty() {
        return rear == -1 && front == -1;


    }

    public void enqueue(int data) {
        //checking full
        if ((rear + 1) % size == front) {
            System.out.println("Queue is Full");
            return;
        }
        //shrro mei add
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;  //updating rear , most useful when rear is at the end of the queue and front is empty for enqueue
        arr[rear] = data;
        relative_size++ ;

    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        // single element deletion
        if (front == rear) {
            front = rear = -1;
            return -1;
        }

        int to_be_del = arr[front];
        front = (front + 1) % size;
        relative_size--;

        return to_be_del;



    }

    public int getFront()
    {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return arr[front] ;
    }

    public void display_queue()
    {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }

        int i = front ;
        while(true)
        {
            System.out.print(arr[i] + ",");
            if (i == rear) {
                break ;
            }
            i = (i + 1) % size;

        }
        System.out.println();


    }


    public static void main(String[] args) {
        Circular_Queue_using_array q = new Circular_Queue_using_array(4) ;

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.display_queue();
        q.enqueue(69);
        q.dequeue();
        q.display_queue();
        q.enqueue(69);
        q.display_queue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display_queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.display_queue();





    }

}
