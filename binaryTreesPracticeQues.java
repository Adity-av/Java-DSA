public class binaryTreesPracticeQues {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static boolean uniValued(Node root){
        if(root==null) return true;
        if(root.left!=null && root.data!=root.left.data){
            return false;
        }
        if(root.right!=null && root.data!=root.right.data){
            return false;
        }
        return uniValued(root.left) && uniValued(root.right);
    }

    public static Node invertTree(Node root){
        if(root == null) return null;
        Node left=invertTree(root.left);
        Node right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static Node deleteLeafNodes(Node root, int x){
        if(root==null) return null;
        root.left=deleteLeafNodes(root.left, x);
        root.right=deleteLeafNodes(root.right, x);
        if(root.left==null && root.right==null && root.data==x){
            return null;
        }
        return root;
    }
    public static void main(String[] args) {
        // Node root=new Node(1);
        // root.left=new Node(2);
        // root.right=new Node(3);
        // root.left.left=new Node(4);
        // root.left.right=new Node(5);
        // root.right.left=new Node(6);
        // root.right.right=new Node(7);
        // System.out.println(uniValued(root));
        // preOrder(root);
        // invertTree(root);
        // System.out.println();
        // preOrder(root);
        int x=3;
        Node root=new Node(1);
        root.left=new Node(3);
        root.right=new Node(3);
        root.left.left=new Node(3);
        root.left.right=new Node(2);
        preOrder(root);
        System.out.println();
        deleteLeafNodes(root, x);
        preOrder(root);
    }
}
