package LinkedPractice;
/*
Intersection Point of two Linked Lists

5-6-7-10-9-11-12
     /
   9

There intersection is 10.
 */
/*
Method 1 Using Hashset
1. Create an empty Hashset hs.
2. Traverse the first list and put all of its address in the hs. [O(m) time and O(m) space]
3. Traverse the second list and look for every node in hs.[O(n) time]
   As soon as we find a node present in the hs, we return value of it.
   Total time- O(m+n) and O(m) aux space

 */

/*
Method 2
1. count the nodes of both the list let it be c1 & c2
2. Traverse the bigger list abs(c1-c2) times.
3. Traverse both the lists simultaneously until we see common node.

 */
public class Prob6 {
    static void inter(Node head1, Node head2){
        // Easy method2 imple not doing.
    }
    public static void main(String[] args) {
        Node head1=new Node(11);
        Node temp1=new Node(12);
        Node temp2=new Node(13);
        Node temp3=new Node(14);
        Node temp4=new Node(15);
        Node temp5=new Node(16);
        head1.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;

        Node head2=new Node(9);
        Node tep1=new Node(10);
        head2.next=tep1;
        tep1.next=temp3;
        Node.printl(head1);
        System.out.println();
        Node.printl(head2);
    }
}
