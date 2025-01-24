public class Queue_Mids_Qs {

    private int [] queue ;
    private int size ;
    private int capacity ;

    public Queue_Mids_Qs(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    public Boolean isEmpty()
    {
        return size==0;
    }

    public Boolean isFull()
    {
        return size== capacity;
    }

    public void Enqueue(int data )
    {
        if(isFull())
        {
            System.out.println("Queue is Full");
            return;
        }

        int i = size - 1 ;

        for( ; i>= 0 && queue[i]>data ; i--)
        {
            queue[i+1] = queue[i] ;
        }
        queue[i+1] = data ;
        size++ ;

    }


    public int Dequeue()
    {
        if(isEmpty())
        {   System.out.println("Queue is Empty");
            return -1 ;
        }

        int to_be_del = queue[0] ;

        for(int i =0 ; i<size-1 ; i++)
        {
            queue[i] = queue[i+1];
        }

        size--;
        return to_be_del ;
    }

    public void display_queue()
    {
        for(int i=0 ; i<size ; i++)
        {
            System.out.print(queue[i] + " ,");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue_Mids_Qs pq = new Queue_Mids_Qs(5) ;
        pq.Enqueue(10);
        pq.Enqueue(20);
        pq.Enqueue(15);
        pq.Enqueue(5);

        pq.display_queue();

        System.out.println(pq.Dequeue());

        pq.display_queue();
        pq.Enqueue(17);
        pq.display_queue();



    }



}
