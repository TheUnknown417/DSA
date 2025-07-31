import java.util.ArrayList;

public class Stack_using_AL {

    ArrayList<Integer> list = new ArrayList<>() ;
    public Boolean isEmpty()
    {
        return list.size()==0 ;

    }

    public void push(int data)
    {
        list.add(data);
        System.out.println(data + "added to stack");
    }

    public int pop()
    {
        if(isEmpty())
            return -1;

        int top = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return top;
    }

    public int peek ()
    {
        if(isEmpty())
            return -1;

        return list.get(list.size() - 1) ;

    }



    public static void main(String[] args) {
        Stack_using_AL stack = new Stack_using_AL();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.pop();

        while(!stack.isEmpty())
        {
            System.out.println(stack.peek());
            stack.pop();

        }


    }

}
