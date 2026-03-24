import java.util.*;
public class BSTPart1 {
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
    public static Node insert(Node root, int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }else{
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root==null) return false;
        if(root.data == key) return true;
        if(root.data>key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root==null) return null;
        if(root.data < val){
            root.right=delete(root.right, val);
        }else if(root.data > val){
            root.left=delete(root.left, val);
        }else{
            // case 1: val is leaf node
            if(root.left==null && root.right==null){
                return null;
            }

            //case 2: val has 1 child;
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }

            //case 3: val has 2 childs
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        if(root.left==null && root.right==null){
            return root;
        }
        return findInorderSuccessor(root.left);
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root==null) return;
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }else if(root.data<k1){
            printInRange(root.right, k1, k2);
        }else{
            printInRange(root.left, k1, k2);
        }
    }

    public static void printArrayList(ArrayList<Integer> arr){
        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            printArrayList(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max){
        if(root==null) return true;
        if(min!=null && root.data<=min.data){
            return false;
        }else if(max!=null && root.data>=max.data){
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        int values[]={8,5,3,6,10,11,14};
        Node root=null;
        for(int val : values){
            root = insert(root,val);
        }
        // inOrder(root);
        // System.out.println();

        // int key=4;
        // System.out.println(search(root,key));
        // inOrder(root);
        // System.out.println();
        // int val=7;
        // delete(root,val);
        // inOrder(root);
        // System.out.println();
        // printInRange(root, 2, 5);
        // ArrayList<Integer> path=new ArrayList<>();
        // printRoot2Leaf(root, path);
        // System.out.println(isValidBST(root, null, null));
    }
}
