public class Doubly_CLL {
    // Node class for Circular Doubly Linked List

     Node head = null;
     Node tail= null ;

    class Node {
        int value;
        Node previous;
        Node next;

        // Constructor to initialize node with value
        public Node(int value) {
            this.value = value;
            this.previous = null;
            this.next = null;
        }
    }


        // Shuru main insert karne ka method
        public void addAtStart(int value) {
            Node newNode = new Node(value);

            if (head == null) { // Agar list khali ho
                head = newNode;
                tail = newNode;
                head.next = head;
                head.previous = head;
            } else {
                newNode.next = head;
                newNode.previous = tail;
                head.previous = newNode;
                tail.next = newNode;
                head = newNode; // Head ko naya node set karo
            }
        }

        // End par insert karne ka method
        public void addAtEnd(int value) {
            Node newNode = new Node(value);

            if (head == null) { // Agar list khali ho
                head = newNode;
                tail = newNode;
                head.next = head;
                head.previous = head;
            } else {
                newNode.previous = tail;
                newNode.next = head;
                tail.next = newNode;
                head.previous = newNode;
                tail = newNode; // Tail ko naya node set karo

            }
        }

        // Koi bhi specific position par insert karne ka method
        public void addAtPosition(int value, int position) {
            if (position == 1) {
                addAtStart(value);
            } else {
                Node newNode = new Node(value);
                Node current = head;
                int currentPosition = 1;

                while (current.next != head && currentPosition<position - 1) {
                    current = current.next;
                    currentPosition++;
                }

                if (currentPosition != position - 1) {
                    System.out.println("Position galat hai ");
                } else if (current == tail) {
                    addAtEnd(value); // End pe add karna hai
                } else {
                    newNode.next = current.next;
                    newNode.previous = current;
                    current.next.previous = newNode;
                    current.next = newNode;
                }
            }
        }

        // Shuru mein se node delete karna
        public void removeFromStart() {
            if (head == null) {
                System.out.println("List khali hai");
            } else if (head == tail) { // Agar ek hi node ho
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.previous = tail;
                tail.next = head;
            }
        }

        // End mein se node delete karna
        public void removeFromEnd() {
            if (head == null) {
                System.out.println("List khali hai");
            } else if (head == tail) { // Agar ek hi node ho
                head = null;
                tail = null;
            } else {
                tail = tail.previous;
                tail.next = head;
                head.previous = tail;
            }
        }

        // Kisi specific position se node delete karna
        public void removeFromPosition(int position) {
            if (head == null) {
                System.out.println("List khali hai");
            } else if (position == 1) {
                removeFromStart();
            } else {
                Node current = head;
                int currentPosition = 1;

                while (current.next != head && currentPosition < position) {
                    current = current.next;
                    currentPosition++;
                }

                if (currentPosition != position) {
                    System.out.println("Position galat hai");
                } else if (current == tail) {
                    removeFromEnd();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
            }
        }

        // List ko forward direction mein traverse karna
        public void traverseForward() {
            if (head == null) {

                System.out.println("List khali hai");
            } else {
                Node current = head;
                do {
                    System.out.print(current.value +"");
                    current = current.next;
                } while (current != head);
                System.out.println();
            }
        }

        // List ko backward direction mein traverse karna
        public void traverseBackward() {
            if (tail == null) {
                System.out.println("List khali hai");
            } else {
                Node current = tail;
                do {
                    System.out.print(current.value + "");
                    current = current.previous;
                } while (current != tail);
                System.out.println();
            }
        }


    // Main class for testing Circular Doubly Linked List

        public static void main(String[] args) {

           Doubly_CLL circularList = new Doubly_CLL() ;

// Shuru aur end pe kuch values add karna
            circularList.addAtStart(10);
            circularList.addAtEnd(20);
            circularList.addAtEnd(30);
            circularList.addAtStart(5);
            circularList.addAtPosition(15, 3);

// List ko traverse karna
            circularList.traverseForward();
            circularList.traverseBackward();

// Delete karna aur list ko dobara check karna
            circularList.removeFromStart();
            circularList.traverseForward();

            circularList.removeFromEnd();
            circularList.traverseForward();

            circularList.removeFromPosition(2);
            circularList.traverseForward();
        }

}
