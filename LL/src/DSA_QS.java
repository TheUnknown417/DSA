import java.util.Stack;

public class DSA_QS
{
    //push at the bottom of the stack (recursive approach)
    public static void  push_at_bottom(Stack<Integer> s , int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        int top = s.pop();
        push_at_bottom(s,data);
        s.push(top);


    }


    // reverse the stack
    public static void reverse_stack(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;

        int top = s.pop();
        reverse_stack(s);
        push_at_bottom(s,top);


    }
    public static void main(String[] args) {


        Stack s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        push_at_bottom(s, 50);
        push_at_bottom(s, 60);
        reverse_stack(s);

        while(!s.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }


    }
}
