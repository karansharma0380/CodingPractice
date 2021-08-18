package LinkedPractice;
/*
Pairwise swap Nodes of a Linked List
 */
public class Prob7 {
    // Changing the data in the nodes
    static void pairswap(Node head){
        Node curr=head;
        while(curr!=null && curr.next!=null){
            int tem=curr.data;
            curr.data=curr.next.data;
            curr.next.data=tem;
            curr=curr.next.next;
        }
        Node.printl(head);
    }
    // Changing the references
//    static void pairsweep(Node head){
//        Node curr=head;
//
//    }
    public static void main(String[] args) {
        Node head1=new Node(11);
        Node temp1=new Node(12);
        Node temp2=new Node(13);
        Node temp3=new Node(14);
        Node temp4=new Node(15);
//        Node temp5=new Node(16);
        head1.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
//        temp4.next=temp5;
        Node.printl(head1);
        System.out.println();
        pairswap(head1);
    }
}
