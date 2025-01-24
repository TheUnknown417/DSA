public class Priority_Queue_using_array {

    private int [] queue ;
    private int capacity ;
    private int size ;

    public Priority_Queue_using_array(int capacity) {

        this.capacity = capacity ;
        this.queue = new int[capacity] ;
        this.size = 0 ;
    }


    public boolean isEmpty() {
        return size==0;
    }
    public Boolean isFull()
    {
        return size==capacity;
    }

    public void insert(int data) {

        if(isFull())
        {
            System.out.println("Queue is full");
            return;
        }
        queue[size] = data ;
        size++ ;

    }

    public int getHighest_priority()
    {

        int max_index = 0 ;

        for(int i = max_index ; i<size ;i++)
        {
            if(queue[i]>queue[max_index])
                max_index = i ;
        }

        return queue[max_index] ;
    }


    public int delete_Highest_priority()
    {
        if(isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return -1;
        }

        int max_index = 0 ;

        for(int i = max_index ; i<size ;i++)
        {
            if(queue[i]>queue[max_index])
                max_index = i ;
        }

        int to_be_del = queue[max_index] ;

        //updating the queue , shifting the elements

        for(int i= max_index ; i< size -1 ; i++)
        {
            queue[i] = queue[i+1] ;
        }

        size-- ;
        return to_be_del;

    }


    public void Dispaly_queue()
    {

        if(isEmpty())
        {
            System.out.println("QUEUE IS EMPTY");
            return ;
        }

        for(int i =  0 ; i<size ; i++)
        {
            System.out.print(queue[i] + ",");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        Priority_Queue_using_array pq = new Priority_Queue_using_array(6) ;
        pq.insert(6);
        pq.insert(7);
        pq.insert(9);
        pq.insert(1);
        pq.insert(5);
        pq.insert(3);

        System.out.println(pq.getHighest_priority() );
        System.out.println(pq.delete_Highest_priority()) ;
        pq.Dispaly_queue();


        System.out.println(pq.getHighest_priority() );
        System.out.println(pq.delete_Highest_priority()) ;
        pq.Dispaly_queue();

    }


}
