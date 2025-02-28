package Basic_Problems;
import java.util.*;
public class b_Traversal_techninques {
    static class BNode {

        int data;
        BNode left;
        BNode right;

        BNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int ind;  // update ind at every recursion

        public static BNode buildTree(int[] nodes) {

            if (ind >= nodes.length) {
                return null;
            }
            int val = nodes[ind++];

            if (val == -1) {
                return null;
            }
           BNode newNode = new BNode(val);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        void preOrder(BNode root) {
            if (root != null) {
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }

        }

        void inOrder(BNode root) {
            if (root != null) {

                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
            }

        }

        void postOrder(BNode root) {
            if (root != null) {

                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data + " ");
            }

        }
        void levelOrder(BNode root){
            if(root == null){
                return ;
            }
            Queue<BNode> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()){
                BNode currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                       q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        BinaryTree tree = new BinaryTree();

        BNode root = BinaryTree.buildTree(nodes);
        System.out.println(root.data+" ");
        System.out.println("Pre-order traversal of tree-> ");
        tree.preOrder(root);
        System.out.println("\nIn-order traversal of tree-> ");
        tree.inOrder(root);
        System.out.println("\nPost-order traversal of tree-> ");
        tree.postOrder(root);
        System.out.println("\nLevel-order traversal of tree-> ");
        tree.levelOrder(root);


    }
}
