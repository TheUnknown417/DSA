public class Stack_using_LL {
    Node head = null ;
    class Node
    {

        int data ;
        Node next ;

        public Node(int data)
        {
            this.data = data ;
            next = null ;
        }
    }



        public Boolean is_empty()
        {
            return head==null ;
        }

        public void push(int data)
        {
            Node newnode = new Node(data) ;

            if(is_empty())
            {
                head = newnode ;
                return;
            }

           newnode.next = head ;
            head = newnode ;

        }

        public int pop()
        {
            if(is_empty())
            {
                System.out.println("Nothing to POP");
                return -1;
            }

            int top = head.data ;
            head = head.next ;
            return top ;


        }

        public int peek()
        {
            if(is_empty())
            {
                System.out.println("Nothing to Show");
                return -1;
            }

          return head.data ;

        }

        public void print_stack()
        {
            while(!is_empty())
            {
                System.out.println(pop());
            }

        }




    public static void main(String[] args) {
        Stack_using_LL stack = new Stack_using_LL() ;

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        //System.out.println(stack.pop());
        //System.out.println(stack.peek());
        stack.print_stack();




    }




}
