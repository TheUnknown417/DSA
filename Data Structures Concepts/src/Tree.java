import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }

    }

    static int index = -1 ;

    // from an array of values
    public Node Build_Tree(int data[])
    {
        index++;
        if(index > data.length || data[index]==-1)
        {
            return null;
        }
        Node newnode = new Node(data[index]);
        newnode.left = Build_Tree(data);
        newnode.right = Build_Tree(data);

        return newnode ; // will return the root Node

    }

    // left to right approach
    public Node Bild_Tree_LevelOrder(int data [] , int i )
    {
        Node root = null ;

        if(i > data.length )
        {
            root = new Node(data[i]);

            root.left = Bild_Tree_LevelOrder(data,2*i+1);
            root.right = Bild_Tree_LevelOrder(data,2*i+2);
        }
        return root ;
    }

    //Traversals

    public void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public void preorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public void postorder(Node root)
    {
        if(root==null)
        {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }


   public void level_order(Node root)
   {
       Queue<Node> q = new LinkedList<>() ;
       q.add(root);
       q.add(null);

       while(!q.isEmpty())
       {
           Node currnode = q.remove() ;

           if(currnode== null)
           {
               System.out.println();
               if(q.isEmpty())
               {
                   break;
               }
               else
               {
                   q.add(null);
               }
           }

           else
           {
               System.out.print(currnode.data + " ");

               if(currnode.left != null)
               {
                   q.add(currnode.left);
               }
               if(currnode.right != null)
               {
                   q.add(currnode.right);
               }


           }
       }

   }

   public int count_nodes(Node root)
   {
       if(root==null) // base case
           return 0 ;

       int count_leftNodes = count_nodes(root.left);
       int count_rightNodes = count_nodes(root.right);

       return  count_leftNodes + count_rightNodes + 1 ;


   }

    public int count_nodes_sum(Node root)
    {
        if(root==null) // base case
            return 0 ;


        int count_left_sum = count_nodes_sum(root.left);
        int count_right_sum = count_nodes_sum(root.right);


        return  count_left_sum+ count_right_sum + root.data ;


    }

    public int height(Node root)
    {
        if(root==null)
        {
            return 0 ;
        }

        int left_height = height(root.left);
        int right_height = height(root.right);

        int total_height = Math.max(left_height , right_height) + 1 ;

        return total_height ;
    }

    public int diameter(Node root)
    {
        // number of nodes between the longest distance
        // this function has a time complexity 0(n^2)
        if(root==null)
        {
            return 0 ;
        }


        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = height(root.left) + height(root.right) + 1 ;

        return Math.max(diameter3 , Math.max(diameter1 , diameter2));

    }

    static class TreeInfo {
        int height ;
        int diameter;

        TreeInfo(int h , int d)
        {
            this.diameter= d ;
            this.height = h ;
        }
    }

    public TreeInfo Efficient_diameter(Node root)
    {
        if(root == null)
        {
            return new TreeInfo(0,0) ;

        }


        TreeInfo left = Efficient_diameter(root.left);
        TreeInfo right = Efficient_diameter(root.right);

        int height = Math.max(left.height , right.height)+ 1 ;

        int diam1 = left.diameter ;
        int diam2= right.diameter ;
        int diam3 = left.height + right.height + 1;

        int my_diam = Math.max(diam3 , Math.max(diam1 , diam2));

        TreeInfo my_info = new TreeInfo(height , my_diam);
        return my_info ;
    }



    public static void main(String[] args) {

        Tree tree = new Tree();
        int data [] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1} ;
        Node root = tree.Build_Tree(data) ;
        //System.out.println(root.data);

     /* tree.inorder(root);
      System.out.println();
      tree.preorder(root);
      System.out.println();
      tree.postorder(root);
      */

        tree.level_order(root);

        System.out.println("Number of Nodes in Tree : " + tree.count_nodes(root));
        System.out.println("Height of Tree : " + tree.height(root));
        System.out.println("Diameter of Tree : " + tree.diameter(root));
        System.out.println("Diameter of Tree : " + tree.Efficient_diameter(root).diameter);



    }


}
