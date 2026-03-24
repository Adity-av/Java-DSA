import java.util.*;
public class binaryTreesPart1 {
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
    static class BinaryTree{
        static int idx=-1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode= new Node(nodes[idx]);
            newNode.left=buildTree(nodes);
            newNode.right=buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root){
            if(root==null) return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void inOrder(Node root){
            if(root==null) return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        public static void postOrder(Node root){
            if(root==null) return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        
        public static void levelOrder(Node root){
            if(root==null) return;
            Queue<Node> q= new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
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
        public static int height(Node root){
            if(root==null) return 0;
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh,rh)+1;
        }
        public static int count(Node root){
            if(root==null) return 0;
            int leftCount=count(root.left);
            int rightCount=count(root.right);
            return leftCount+rightCount+1;
        }
        public static int sumOfNodes(Node root){
            if(root==null) return 0;
            int leftSum=sumOfNodes(root.left);
            int rightSum=sumOfNodes(root.right);
            return leftSum+rightSum+root.data;
        }
        public static int diameter1(Node root){
            if(root==null) return 0;
            int leftHt=height(root.left);
            int leftDiam=diameter1(root.left);
            int rightHt=height(root.right);
            int rightDiam=diameter1(root.right);
            int selfDiam=leftHt+rightHt+1;
            return Math.max(selfDiam,Math.max(leftDiam,rightDiam));
        }   
        static class Info{
            int diam;
            int ht;
            public Info(int diam, int ht){
                this.ht=ht;
                this.diam=diam;
            }
        }
        public static Info diameter2(Node root){
            if(root==null){
                return new Info(0,0);
            }
            Info leftInfo=diameter2(root.left);
            Info rightInfo=diameter2(root.right);
            int diam=Math.max(leftInfo.ht+rightInfo.ht+1,Math.max(rightInfo.diam,leftInfo.diam));
            int ht=Math.max(leftInfo.ht,rightInfo.ht)+1;
            return new Info(diam,ht);
        }
    }
    public static void main(String[] args) {
        // int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree=new BinaryTree();
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.right=new Node(6);
        root.right.left=new Node(7);
        // System.out.println(tree.height(root));
        // System.out.println(tree.count(root));
        // System.out.println(tree.sumOfNodes(root));
        // System.out.println(tree.diameter1(root));
        // System.out.println(tree.diameter2(root).diam);
        // Node root=tree.buildTree(nodes);
        // System.out.println(root.data);
        // tree.preOrder(root);
        // System.out.println();
        // tree.inOrder(root);
        // System.out.println();
        // tree.postOrder(root);
        // System.out.println();
        // tree.levelOrder(root);
        // tree.root=
    }
}
