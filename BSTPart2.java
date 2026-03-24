import java.util.*;
public class BSTPart2 {
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
        if(root.data>val){
            root.left=insert(root.left, val);
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Node createBST(int arr[], int st, int end){
        if(st>end){
            return null;
        }
        int mid=(end+st)/2;
        Node root=new Node(arr[mid]);
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    public static Node createBST(ArrayList<Integer> arr, int st, int end){
        if(st>end){
            return null;
        }
        int mid=(end+st)/2;
        Node root=new Node(arr.get(mid));
        root.left=createBST(arr, st, mid-1);
        root.right=createBST(arr, mid+1, end);
        return root;
    }
    
    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        
        int size=leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max=Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || root.data >=rightInfo.min){
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }

    public static void inorderList(Node root, ArrayList<Integer> arr){
        if(root==null) return;
        inorderList(root.left, arr);
        arr.add(root.data);
        inorderList(root.right, arr);
    }

    public static void mergeArr(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr){
        int i=0, j=0;
        while(i!=arr1.size() && j!=arr2.size()){
            if(arr1.get(i)<arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i!=arr1.size()){
            arr.add(arr1.get(i));
            i++;
        }
        while(j!=arr2.size()){
            arr.add(arr2.get(j));
            j++;
        }
    }
    static int sum=0;
    public static void rangeSum(Node root, int L, int R){
        if(root==null){
            return;
        }
        if(root.data>L) rangeSum(root.left, L, R);
        if(root.data>=L && root.data<=R){
            sum+=root.data;
        }
        if(root.data<R) rangeSum(root.right, L, R);
    }
    public static void main(String[] args) {
        // int values[]={8,5,3,6,10,11,14};
        // Node root=null;
        // for(int val : values){
        //     root=insert(root,val);
        // }
        // inorder(root);
        // int arr[]={3,5,6,8,10,11,12};
        // createBST(arr, 0, arr.length-1);
        // Node root=createBST(arr, 0, arr.length-1);
        // inorder(root);

        /*
                            50
                          /    \
                        30      60
                       /  \    /  \
                      5   20  45  70
                                 /  \
                                65  80
        */
       Node root=new Node(50);
       root.left=new Node(30);
       root.left.left=new Node(5);
       root.left.right=new Node(20);

       root.right=new Node(60);
       root.right.right=new Node(70);
       root.right.left=new Node(45);
       root.right.right.left=new Node(65);
       root.right.right.right=new Node(80);

    //    Info info=largestBST(root);
    //    System.out.println("largest BST size = "+maxBST);

    /*
        ques. merge 2 BSTs
                    2              9
                  /   \          /   \
                 1     4        3     12 
    */
    // Node BST1=new Node(2);
    // BST1.left=new Node(1);
    // BST1.right=new Node(4);
    // Node BST2=new Node(9);
    // BST2.left=new Node(3);
    // BST2.right=new Node(12);
    // ArrayList<Integer> arr1= new ArrayList<>();
    // ArrayList<Integer> arr2= new ArrayList<>();
    // ArrayList<Integer> arr=new ArrayList<>();
    // inorderList(BST1, arr1);
    // inorderList(BST2, arr2);
    // mergeArr(arr1, arr2, arr);
    // Node root=createBST(arr, 0, arr.size()-1);
    // inorder(root);
    //practice ques1. We have a Binary Search Tree consisting of N nodes and two positive integers L and R, 
    // the task is to find the sum of values of all the nodes that lie in the range [L, R]..
    rangeSum(root, 15, 50);
    System.out.println(sum);
    }
}
