package CircularSLL;

class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}

public class Intro {
    static void printl(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    static Node circu(Node head){
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        return head;
    }
    ////////////////////
    // print circular Linked List elements
    static void piri(Node head){
        Node curr=head.next;
        System.out.print(head.data+" ");
        while(curr!=head){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    // Insert at the beginning O(n)
    static void inser(Node head, int x){
        Node curr=head.next;
        while(curr.next!=head){
            curr=curr.next;
        }
        Node temp=new Node(x);
        curr.next=temp;
        temp.next=head;
        piri(temp);
    }
    // insert at the end O(1)
    static void endin(Node head, int x){
        Node temp=new Node(x);
        temp.next=head.next;
        head.next=temp;
        int t=temp.data;
        temp.data=head.data;
        head.data=t;
        head=temp;
        piri(head);
    }
    // delete head O(1)
    static void delh(Node head){
        head.data=head.next.data;
        head.next=head.next.next;
        piri(head);
    }
    // delete kth node from beginning o(n/k)
    static void delp(Node head, int pos){
        if(pos==1){
            delh(head);
            return;
        }
        Node curr=head;
        for(int i=0;i<pos-2;i++){
            curr=curr.next;
        }
        curr.next=curr.next.next;
        piri(head);
    }


    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);
        Node temp3=new Node(40);
        Node temp4=new Node(50);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        printl(head);
        Node circu1=circu(head);
        System.out.println();
        delp(head,3);
    }
}
