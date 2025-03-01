package Basic_Problems;

public class Height_Count_Sum_tree {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinTree {
        static int ind;  // update ind at every recursion

        public static Node buildTree(int[] nodes) {

            if (ind >= nodes.length) {
                return null;
            }
            int val = nodes[ind++];

            if (val == -1) {
                return null;
            }
            Node newNode = new Node(val);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh)+1;

        }
        int count(Node root){
            if(root == null){
                return 0;
            }
            int rcount = count(root.right);
            int lcount = count(root.left);
            return rcount+lcount+1;
        }
        int nSum(Node root){
            if(root == null){
                return 0;
            }
            int lsum = nSum(root.left);
            int rsum = nSum(root.right);
            return rsum+lsum+root.data;

        }

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        BinTree tree = new BinTree();
        BinTree.ind = 0;
        Node root = BinTree.buildTree(nodes);
       int h =  tree.height(root);
        System.out.println("height of tree-> "+h);
        int c =  tree.count(root);
        System.out.println("Nodes of tree-> "+c);
        int s =  tree.nSum(root);
        System.out.println("sum of all tree nodes data-> "+s);

    }

}
