import java.util.LinkedList;

 class Priority_queue_using_LL {

     public static void main(String[] args) {

         Priority_queue_using_LL queue = new Priority_queue_using_LL() ;

         queue.Enqueue(74 , 9);
         queue.Enqueue(17 , 8);
         queue.Enqueue(569 , 7);
         queue.Enqueue(24 , 4);

         queue.display();

     }

     class Pair {
        int data;
        int priority;

        public Pair(int data , int priority) {
            this.data = data;
            this.priority = priority;

        }
         @Override
         public String toString() {
             return "Value: " + data + " " +  "Priority: " + priority;
         }
    }

    LinkedList<Pair> PQ ;

    public Priority_queue_using_LL()
    {
        PQ = new LinkedList<>() ;
    }


    public void Enqueue( int data , int priority)
    {
        Pair newpair = new Pair( data , priority) ;

        int i = 0 ;
        while(i<PQ.size() && PQ.get(i).priority> priority)
        {
            i++ ;
        }

        PQ.add(i , newpair);

    }


    public int dequeue()
    {
        if(PQ.isEmpty())
        {
            System.out.println("Queue is Empty");
            return -1 ;
        }

        return PQ.removeFirst().data ;

    }

    public void display()
    {
        if (PQ.isEmpty()) {
            System.out.println("Queue khali hai ");
            return;
        }

        for(Pair p : PQ)
        {
            System.out.println(p);
        }
    }



    }






