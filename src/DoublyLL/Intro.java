package DoublyLL;
/*
Doubly Linked List programs
 */
class Node{
    int data;
    Node prev;
    Node next;
    Node(int x){
        data=x;
        prev=null;
        next=null;
    }
}

public class Intro {
    static void prin(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    // Insert at the beginning
    static Node begiins(Node head, int data){
        Node temp=new Node(data);
        temp.next=head;
        if (head != null) {
            head.prev=temp;
        }
        return temp;
    }
    // Insert at the end
    static Node endins(Node head, int data){
        Node temp=new Node(data);
        if(head==null){
            return temp;
        }
        Node curr=head;
        while (curr.next != null) {
            curr=curr.next;
        }
        curr.next=temp;
        temp.prev=curr;
        return head;
    }
    // Reverse the LL
    static void rev(Node head){
        if (head==null || head.next==null){
            System.out.println(head);
        }
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            prev=curr.prev;
            curr.prev=curr.next;
            curr.next=prev;
            curr=curr.prev;
        }
        prin(prev);
    }
    // Delete first Node theta(1)
    static Node Delh(Node head){
        if(head==null){
            return head;
        }
        if(head.next==null){
            return null;
        }
        Node temp=head.next;
        head.next=null;
        temp.prev=null;
        return temp;
    }
    // delete the last node
    static Node Delend(Node head){
        if(head==null){
            return head;
        }
        if(head.next==null){
            head=null;
            return head;
        }
        Node curr=head;
        while(curr.next.next!=null){
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }
    //Making circular double linkedlist
    static Node Circu(Node head){
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=head;
        head.prev=curr;
        return head;
    }

    public static void main(String[] args) {
        Node head=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);
        Node temp3=new Node(40);
        head.next=temp1;
        head.prev=null;
        temp1.prev=head;
        temp1.next=temp2;
        temp2.prev=temp1;
        temp2.next=temp3;
        temp3.prev=temp2;
        prin(head);
//        System.out.println();
//        prin(begiins(head,99));
//        System.out.println();
//        prin(endins(head,99));
        System.out.println();
        System.out.println(Circu(head).prev.data);


    }
}
