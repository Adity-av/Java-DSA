import java.util.LinkedList;

public class linkedListPart2 {
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
    public void addLast(int n){
        if(head==null){
            head.data=n;
            return;
        }
        Node value=new Node(n);
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=value;

    }
    public void addFirst(int n){
        Node newNode=new Node(n);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void print(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println("null");
    }
    public boolean cycleOrNot(){//Floyd's Cycle Finding Algorithm(CFA)
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle){
            slow=head;
            Node prev=null;
            while(slow!=fast){
                slow=slow.next;
                prev=fast;
                fast=fast.next;
            }
            prev.next=null;
        }
        return;
    }

    private Node getMid(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1,Node head2){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        while(head1!=null){
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //left & right half MS(merge sort)
        Node rightHead=mid.next;
        mid.next=null;
        Node newLeft=mergeSort(head);
        Node newRight=mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);
    }
    public void zigZag(Node head){
        //find mid
        Node slow =head;
        Node fast =head.next;
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow;
        // reverse .2nd half
        Node curr=mid.next;
        Node prev=null;
        mid.next=null;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        Node left=head;
        Node right=prev;
        Node nextL,nextR;
        while(left!=null && right!=null){
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;
            left=nextL;
            right=nextR;
        }
    }
    public static void main(String[] args) {
        // linkedListPart2 ll=new linkedListPart2();
        // ll.head=new Node(1);
        // Node temp=new Node(2);
        // head.next=temp;
        // ll.head.next.next=new Node(3);
        // ll.head.next.next.next=temp;
        // // ll.print();
        // System.out.println(ll.cycleOrNot());
        // ll.removeCycle();
        // ll.print();
        // System.out.println(ll.cycleOrNot());

        // ll.addLast(1);
        // ll.addLast(2);
        // System.out.println(ll);
        // ll.removeLast();
        // ll.removeFirst();
        // LinkedList<Integer> ll=new LinkedList<>();
        linkedListPart2 ll=new linkedListPart2();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        // ll.print();
        // ll.head=ll.mergeSort(ll.head);
        ll.zigZag(head);
        ll.print();
    }
}
