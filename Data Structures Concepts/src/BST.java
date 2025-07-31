import java.util.LinkedList;
import java.util.Queue;

public class BST {
    Node root;

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void insert_iteration(int data) {

        if (root == null) {
            root = new Node(data);
            System.out.println("Node inserted as root into BST" + data);
            return;
        }
        Node temp = root;

        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Duplicates not allowed. Enter a different value.");
                return;
            }

            if (data < temp.data) {
                if (temp.left == null) {
                    temp.left = new Node(data);
                    System.out.println("Node inserted into BST" + data);
                    return;
                }

                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = new Node(data);
                    System.out.println("Node inserted into BST" + data);
                    return;
                }

                temp = temp.right;

            }
        }

    }

    public void insert(int data) {
        root = insertrec(root, data);
    }

    Node insertrec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // traversing

        if (data < root.data) {
            root.left = insertrec(root.left, data);
        } else if (data > root.data) {
            root.right = insertrec(root.right, data);

        }
        return root;

    }

    public void inorder() {
        inorderrec(root);
    }

    void inorderrec(Node root) {
        if (root != null) {
            inorderrec(root.left);
            System.out.println(root.data);
            inorderrec(root.right);
        }
    }

    public void preorder() {
        preorderrec(root);
    }

    void preorderrec(Node root) {
        if (root != null) {
            System.out.println(root.data);
            inorderrec(root.left);
            inorderrec(root.right);
        }
    }

    public void postorder() {
        postorderrec(root);
    }

    void postorderrec(Node root) {
        if (root != null) {

            inorderrec(root.left);
            inorderrec(root.right);
            System.out.println(root.data);
        }
    }

    void level_order(Node root) // using a queue
    {
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                System.out.println();

                if (q.isEmpty())
                    break;
                else
                    q.add(null);
            } else {
                System.out.print(curr.data + ",");

                if (curr.left != null)
                    q.add(curr.left);

                if (curr.right != null)
                    q.add(curr.right);

            }

        }
    }

    int findmax(Node root) {

        if (root == null) {
            System.out.println("tree is empty");
            return Integer.MAX_VALUE;
        }

        if (root.right == null) {
            return root.data;
        }

        return findmax(root.right);

    }

    Node findmin(Node root) {

        if (root == null) {
            System.out.println("tree is empty");
            return root;
        }

        while (root.left != null) {
            root = root.left;
        }
        return root;

    }

    int height(Node root) {
        if (root == null)
            return 0;   // if height is determined by number of nodes
        // return -1 ; // if height is determined by number of edges

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int total_height = Math.max(leftHeight, rightHeight) + 1;
        return total_height;

    }

    void search_iterative(int data) {
        if (root == null) {
            System.out.println("Nothing to search");
            return;
        }

        Node temp = root;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element " + data + " found");
                return;
            } else if (data < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        System.out.println("Sorry Element " + data + " Not found");

    }

    boolean search_recursive(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;

        if (key < root.data)
            return search_recursive(root.left, key);
        else
            return search_recursive(root.right, key);


    }

    public Node delete_node(Node root, int key) {
        if (root == null)   // tree is empty
            return root;

        if (key < root.data) {
            root.left = delete_node(root.left, key);
        } else if (key > root.data) {
            root.right = delete_node(root.right, key);
        } else // node to be del found
        {
            if (root.left == null && root.right == null) // leaf Node
            {
                return null;
            } else if (root.left == null) // one child
            {
                return root.right;
            } else if (root.right == null) // one child
            {
                return root.left;
            } else                      // two child
            {
                Node temp = findmin(root.right); // successor
                root.data = temp.data;        // replace with successor
                root.right = delete_node(root.right, temp.data); // delete successor
            }

        }

            return root ;
    }


    public static void printTree(Node root, int space) {
        int COUNT = 5; // Adjust space between levels
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process the right child first
        printTree(root.right, space);

        // Print the current node
        System.out.println();
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data);

        // Process the left child
        printTree(root.left, space);
    }

    public static void main(String[] args) {
        BST bst = new BST();
//        bst.insert(90);
//        bst.insert(30);
//        bst.insert(40);
//        bst.insert(10);
//        bst.insert(20);
//        bst.insert(50);
//        bst.insert(100);
//
//        bst.inorder();
//        System.out.println(bst.findmax(bst.root));
//        System.out.println(bst.findmin(bst.root));



        bst.insert_iteration(15);
        bst.insert_iteration(9);
        bst.insert_iteration(20);
        bst.insert_iteration(7);
        bst.insert_iteration(11);
        bst.insert_iteration(19);
        bst.insert_iteration(21);
        bst.insert_iteration(21);

        printTree(bst.root, 5);
        System.out.println();
        bst.search_iterative(19);

        if(bst.search_recursive(bst.root, 11) )
            System.out.println("found in tree");
        else
            System.out.println("Not found");


        System.out.println("height of Tree : " +bst.height(bst.root));
        bst.level_order(bst.root);

        bst.delete_node(bst.root, 15);

        printTree(bst.root, 5);

    }
}



