package LinkedPractice;
/*
Delete a node with only pointer given to it.

 a random address to a node of the linked list is given and the user needs to delete the
 node of the given address. The address can point to any random node in-between a linked list.

 Note- last node cannot be given.
 */
public class Prob4 {
    static void inbet(Node head){
        Node ptr=head;
        ptr.data=ptr.next.data;
        ptr.next=ptr.next.next;

        Node.printl(head);
    }


    public static void main(String[] args) {
        Node head=new Node(11);
        Node temp1=new Node(12);
        Node temp2=new Node(13);
        Node temp3=new Node(14);
//        Node temp4=new Node(15);
//        Node temp5=new Node(16);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
//        temp3.next=temp1;
//        temp4.next=temp5;
        Node.printl(head);
        System.out.println();
        inbet(temp2);
    }
}
