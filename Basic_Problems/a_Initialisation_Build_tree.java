package Basic_Problems;

public class a_Initialisation_Build_tree {
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


    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        BinTree tree = new BinTree();
        BinTree.ind = 0;
        Node root = BinTree.buildTree(nodes);
        System.out.println(root.data+" ");



    }
}
