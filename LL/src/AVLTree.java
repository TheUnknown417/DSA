import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}

public class AVLTree {
    Node root; // root of AVL Tree

    // helper to get height
    public int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // helper to get balance factor
    public int balance(Node node) {
        return (node == null ? 0 : height(node.left) - height(node.right));
    }

    // to determine successor
    Node findmin(Node node)
    {
        if(node == null) {

            System.out.println("Nothing in the tree");
            return null ;
        }
        while(node.left != null)
        {
            node = node.left;
        }
        return node ;
    }
    Node findmax(Node node)
    {
        while(node.right != null)
            node = node.right;
        return node ;
    }
    // Rotations

    Node rigth_rotate(Node p) {
        Node c = p.left;
        Node t2 = c.right;

        // performing rotations
        c.right = p;
        p.left = t2;

        // update heights
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;


        return c;  // the new root
    }

    Node left_rotate(Node c) {
        Node p = c.right;
        Node t2 = p.left;

        // performing rotations
        p.left = c;
        c.right = t2;

        // update heights
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;


        return p;  // the new root
    }

    Node insert_AVl(Node node, int data) {
        // normal BST insertion
        if (node == null)
            return new Node(data);
        else if (data < node.data)
            node.left = insert_AVl(node.left, data);
        else if (data > node.data)
            node.right = insert_AVl(node.right, data);
        else
            return node; // no duplicates

        // update height of this node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Determine balance factor for this node AND 4-cases
        int balance = balance(node);


        //LL case
        if (balance > 1 && data < node.left.data)
            return rigth_rotate(node);

        //LR case
        if (balance > 1 && data > node.left.data) {
            node.left = left_rotate(node.left);
            return rigth_rotate(node);
        }

        // RR case
        if (balance < -1 && data > node.right.data)
            return left_rotate(node);

        //RL case
        if (balance < -1 && data < node.right.data) {
            node.right = rigth_rotate(node.right);
            return left_rotate(node);
        }

        return node; // return the unchanged node

    }

    public Node delete_AVL(Node root , int data) {
        // standard BST deletion

        if (root == null) {
            System.out.println("The tree is empty");
            return null;
        }

        if (data < root.data)
            root.left = delete_AVL(root.left, data);

        else if (data > root.data)
            root.right = delete_AVL(root.right, data);

        else // element to be del found !!
        {
            if (root.left == null && root.right == null) // no child
                return null;

            if (root.left == null)
                return root.right;
            // one child
            if (root.right == null)
                return root.left;

            // Two children
            Node temp = findmax(root.left);
            root.data = temp.data;
            root.left = delete_AVL(root.left, temp.data);

        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = balance(root);


        // 4-case rotations
        if (balance > 1) {
            if (balance(root.left) >= 0)  // LL case
                return rigth_rotate(root);

            root.left = left_rotate(root.left)    ;     // LR case
            return rigth_rotate(root);
        }

        if (balance < -1)
        {
            if (balance(root.right) <= 0)  // RR case
                return left_rotate(root);

            root.right = rigth_rotate(root.right)    ;     // RL case
            return left_rotate(root);
        }

        return root ; // return unchanged root

    }




    void level_order(Node node) {
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        q.add(null);

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr == null) {
                System.out.println();

                if (q.isEmpty())
                    break;
                else
                    q.add(null);

            } else {
                System.out.print(curr.data + ", ");

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);

            }


        }
    }




    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // Insert nodes into the AVL tree
        System.out.println("Inserting nodes into the AVL tree...");
        int[] valuesToInsert = {10, 20, 30, 40, 50, 25};
        for (int value : valuesToInsert) {
            tree.root = tree.insert_AVl(tree.root, value);
        }
        System.out.println("Level-order traversal after insertion:");
        tree.level_order(tree.root);

        // Delete nodes from the AVL tree
        System.out.println("\nDeleting nodes from the AVL tree...");
        int[] valuesToDelete = { 20, 25};
        for (int value : valuesToDelete) {
            System.out.println("\nDeleting " + value + "...");
            tree.root = tree.delete_AVL(tree.root, value);
            System.out.println("Level-order traversal after deleting " + value + ":");
            tree.level_order(tree.root);
        }
    }
}