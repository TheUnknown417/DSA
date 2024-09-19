import java.util.ArrayList;
import java.util.Scanner;

class mera_Stack
{

    private ArrayList<Integer> meray_stack_ki_list ;


    public mera_Stack() {
        meray_stack_ki_list = new ArrayList<>();
    }

    public Boolean isEmpty()
    {
        return meray_stack_ki_list.isEmpty();

    }

    public int size()
    {
        return meray_stack_ki_list.size();

    }

    //Top
    public  int Top()
    {
        if (isEmpty()) {
            System.out.println("Hai he kuch nahi");
            return -1;
        }
        else
        {
            return meray_stack_ki_list.get(size()-1) ;

        }

    }


    //add element
    public void push (int value)
    {
        meray_stack_ki_list.add(value);
        System.out.println(value + " stack k top pr hai !");
    }

    //remove element
    public int pop () {
        int bahir_aya ;
        if (isEmpty()) {
            System.out.println("Hai he kuch Nahi");
            return -1;
        } else {
            bahir_aya = meray_stack_ki_list.remove(size() - 1);
            System.out.println(bahir_aya + " popped from stack.");
            return bahir_aya;
        }

    }





    }

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        mera_Stack meraStack = new mera_Stack();

        boolean exit = false;

        while (!exit) {

            System.out.println("\n--- Stack Operations Menu ---");

            System.out.println("1. Push to Stack");

            System.out.println("2. Pop from Stack");

            System.out.println("3. Peek at Stack");

            System.out.println("4. Check if Stack is Empty");

            System.out.println("5. Get Stack Size");

            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();



            switch (choice) {

                case 1:

                    System.out.print("Enter a value to push onto the stack: ");

                    int value = scanner.nextInt();

                    meraStack.push(value);

                    break;

                case 2:

                    meraStack.pop();

                    break;

                case 3:

                    int topElement = meraStack.Top();

                    if (topElement != -1) {

                        System.out.println("Top element is: " + topElement);

                    }

                    break;

                case 4:

                    if (meraStack.isEmpty()) {

                        System.out.println("The stack is empty.");

                    } else {

                        System.out.println("The stack is not empty.");

                    }

                    break;

                case 5:

                    System.out.println("The size of the stack is: " + meraStack.size());

                    break;

                case 6:

                    exit = true;

                    System.out.println("Exiting...");

                    break;

                default:

                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");

            }

        }



        scanner.close();

    }




}