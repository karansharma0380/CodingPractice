package LinkedPractice;
/*
Merge two sorted Linked List
 */
public class Prob10 {
    /*
    Time complexity
    If length of a LL be m
    if length of b LL be n
    Then combined is O(m+n) and O(1)
    it is not theta(m+n) because if one list is null then to return other non null list
    will take constant time.
     */
    static void merg(Node a, Node b){
        if(a==null){
            Node.printl(b);
        }
        if(b==null){
            Node.printl(a);
        }
        Node head=null;
        Node tail=null;
        if(a.data<=b.data){
            head=a;
            tail=a;
            a=a.next;
        }
        else{
            head=b;
            tail=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.data<=b.data){
                tail.next=a;
                tail=a;
                a=a.next;
            }
            else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if(a==null){
            tail.next=b;
        }
        else{
            tail.next=a;
        }
        Node.printl(head);
    }
    public static void main(String[] args) {
        Node head1=new Node(10);
        Node temp1=new Node(20);
        Node temp2=new Node(30);
        Node temp3=new Node(40);
        head1.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        Node head2=new Node(5);
        Node tem1=new Node(15);
        Node tem2=new Node(17);
        Node tem3=new Node(18);
        Node tem4=new Node(35);
        head2.next=tem1;
        tem1.next=tem2;
        tem2.next=tem3;
        tem3.next=tem4;
        Node.printl(head1);
        System.out.println();
        Node.printl(head2);
        System.out.println();
        merg(head1,head2);
    }
}
