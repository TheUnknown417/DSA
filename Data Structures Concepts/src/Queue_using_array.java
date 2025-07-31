public class Queue_using_array {

    static int rare = -1 ;
    static int size ;
    static  int[] arr;

    public Queue_using_array(int size)     //constructor mei queue ka size
    {
        arr = new int[size];
        this.size = size ;

    }

    public Boolean isempty()
    {
        return rare==-1;
    }
    public void enqueue(int data)
    {
        if(rare==size-1)
        {
            System.out.println("Queue is Full");
            return ;
        }
        rare++;
        arr[rare] = data ;


    }

    public int dequeue() // removes from front of the queue
    {
        //checking if queue is empty
        if(rare==-1)
        {
            System.out.println("Queue is empty");
            return -1;
        }

        int front = arr[0]; //locating front

        // front apni jgha pr he rahay ga , saray elements eik step peechay atay rahein gy

        for(int i = 0 ; i<rare ; i++)
        {
            arr[i] = arr[i+1] ;
        }

        // ab rare bhi eik step peechay ajay ga
        rare-- ;
        return front ;

    }

    public int front() // removes from front of the queue
    {
        //checking if queue is empty
        if (rare == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        return arr[0];
    }

    public static void main(String[] args) {
        Queue_using_array q = new Queue_using_array(5) ;

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        while(!q.isempty())
        {
            System.out.println(q.front());
            q.dequeue();
        }






    }
}
