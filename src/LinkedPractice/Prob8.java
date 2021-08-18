package LinkedPractice;
/*
You are given a Double Link List with one pointer of each node pointing to the next node
just like in a single link list. The second pointer however CAN point to any node in the list
 */

class Node2 {
    int data;
    Node2 next;
    Node2 rando;
    Node2(int x) {
        data = x;
        next = null;
        rando = null;
    }
}

public class Prob8 {

    //Method 2
    /*
    1) Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List,
       create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy
       of N after the Nth node
    2) Now copy the arbitrary link in this fashion.This works because original->next is nothing
       but copy of original and Original->arbitrary->next is nothing but copy of arbitrary.
   --- original->next->arbitrary = original->arbitrary->next;  /TRAVERSE TWO NODES
    3) Now restore the original and copy linked lists in this fashion in a single loop.
       original->next = original->next->next;
       copy->next = copy->next->next;
    4) Make sure that last element of original->next is NULL.
     */
    static Node2 clon(Node2 start) {
        Node2 curr = start, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = new Node2(curr.data);
            curr.next.next = temp;
            curr = temp;
        }
        curr = start;
        while (curr != null) {
            if (curr.next != null)
                curr.next.rando = (curr.rando != null) ? curr.rando.next : null;
            curr = curr.next.next;
        }
        Node2 original = start, copy = start.next;
        temp = copy;
        while (original != null) {
            original.next = original.next.next;
            copy.next = (copy.next != null) ? copy.next.next : null;
            original = original.next;
            copy = copy.next;
        }
        return temp;

}
    public static void main(String[] args) {
        Node2 head1=new Node2(10);
        Node2 temp1=new Node2(5);
        Node2 temp2=new Node2(20);
        Node2 temp3=new Node2(15);
        Node2 temp4=new Node2(20);
        head1.next=temp1;
        head1.rando=temp2;
        temp1.next=temp2;
        temp1.rando=temp3;
        temp2.next=temp3;
        temp2.rando=head1;
        temp3.next=temp4;
        temp3.rando=temp2;
        temp4.rando=temp3;
        System.out.println(clon(head1).data);

    }
}
