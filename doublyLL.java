public class doublyLL {
    public class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=next;
            this.prev=prev;
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
        head.prev=newNode;
        head=newNode;
    }

    //print
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data +"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //remove
    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    //add Last
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        size++;
    }
    public int removeLast(){
        if(head==null){
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;
        }
        if(head.next==null){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=tail.data;
        Node curr=tail.prev;
        tail=curr;
        tail.next=null;
        size--;
        return val;
    }

    //reverse the doubly linked list
    public void reverse(){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    
    public static void main(String[] args) {
        doublyLL dll=new doublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.err.println(dll.size);
        // dll.removeFirst();
        dll.addLast(4);
        // dll.print();
        // System.err.println(dll.size);
        // dll.removeLast();
        // dll.print();
        // System.err.println(dll.size);
        dll.reverse();
        dll.print();
    }
}
