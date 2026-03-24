import java.util.LinkedList;

public class practiceLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=next;
        }
    }
    public static Node head;

    public static Node getIntersectionNode(Node head1,Node head2){
        while(head1!=null){
            Node curr=head2;
            while(curr!=null){
                if(head1==curr){
                    return curr;
                }
                curr=curr.next;
            }
            head1=head1.next;
        }
        return null;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void deleteMAfterNNodes(int m,int n){
        Node curr=head;
        while(curr!=null){
            int mm=m;
            int nn=n;
            while(mm>1){
                if(curr==null)break;
                curr=curr.next;
                mm--;
            }
            if(curr==null){
                return;
            }
            Node next=curr.next;
            while(nn>0){
                if(next==null) break;
                next=next.next;
                nn--;
            }
            curr.next=next;
            curr=next;
        }
    }
    public static void swapNodes(int x,int y){
        if(x==y) return;
        Node prevX=null,currX=head;
        while(currX!=null && currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }
        Node prevY=null,currY=head;
        while(currY!=null && currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }
        if(currX==null ||  currY==null) return;
        if(prevX!=null){
            prevX.next=currY;
        }else{
            head=currY;
        }
        if(prevY!=null){
            prevY.next=currX;
        }else{
            head=currX;
        }
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;
    }
    public static void main(String[] args) {
        practiceLL ll=new practiceLL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        // ll.addLast(5);
        // ll.addLast(6);
        // ll.addLast(7);
        // ll.addLast(8);
        // ll.addLast(9);
        ll.print();
        // Node head1, head2;
        // head1 = new Node(10);
        // head2 = new Node(3);
        // Node newNode = new Node(6);
        // head2.next = newNode;
        // newNode = new Node(9);
        // head2.next.next = newNode;
        // newNode = new Node(15);
        // head1.next = newNode;
        // head2.next.next.next = newNode;
        // newNode = new Node(30);
        // head1.next.next = newNode;
        // head1.next.next.next = null;
        // Node intersectionPoint= ll.getIntersectionNode(head1, head2);
        // if (intersectionPoint == null) {
        // System.out.print(" No Intersection Point \n");
        // }else {
        //     System.out.print("Intersection Point: "+ intersectionPoint.data);
        // }

        // int m=2;
        // int n=2;
        // deleteMAfterNNodes(m,n);

        int x=2;
        int y=4;
        ll.swapNodes(x,y);
        ll.print();
    }
}
