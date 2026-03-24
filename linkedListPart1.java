import java.util.LinkedList;

public class linkedListPart1 {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
        System.out.println("null");
    }
    public void add(int idx,int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }
        int i=0;
        size++;
        Node currNode=head;
        while(i!=idx-1){  
            currNode=currNode.next;
            i++;
        }
        newNode.next=currNode.next;
        currNode.next=newNode;
    }
    public int removeFirst(){
        if(size==0){
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if (size==0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        Node prev=head;
        while(prev.next.next!=null){
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;

    }
    public int itrSearch(int target){
        int i=0;
        Node currNode=head;
        while(currNode!=null){
            if(currNode.data==target){
                return i;
            }
            currNode=currNode.next;
            i++;
        }
        return -1;
    }
    public int recSearch(int target,int i,Node currNode){
        if(currNode==null){
            return -1;
        }
        if(currNode.data==target){
            return i;
        }
        return recSearch(target, i+1, currNode.next);
        
    }
    public void reverse(){ //O(n)
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public void removeNthNode(int n){
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return;
        }
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean palindromeOrNot(){
        if(head==null || head.next==null) return true;
        Node midNode=findMid(head);
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;
        while(left!=null && right!=null){
            if(left.data != right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    public static void main(String[] args) {
        linkedListPart1 ll=new linkedListPart1();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        ll.add(2,3);
        // System.out.println(ll.size);
        // ll.removeFirst();
        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.itrSearch(5));
        // System.out.println(ll.recSearch(5,0,head));
        // ll.reverse();
        // ll.removeNthNode(3);
        System.out.println(ll.palindromeOrNot());
        ll.print();
    }
    
}
