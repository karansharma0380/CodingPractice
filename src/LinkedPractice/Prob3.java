package LinkedPractice;

/*
Detect and remove the Loop from the Linked List
 */

/*
Use Floyd cycle Detection algorithm
1.
 */
public class Prob3 {
    static void DecRem(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("Loop detected");
                break;
            }
        }
        if(slow!=fast){
            System.out.println("No Loop Found");
            return;
        }
        slow=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
        Node.printl(head);
    }
    // Find the Length of the loop.
    static void LenLoop(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("Loop detected");
                break;
            }
        }
        if(slow!=fast){
            System.out.println("No Loop");
            return;
        }
        int leng=1;
        fast=fast.next;
        while(fast!=slow){
            leng++;
            fast=fast.next;

        }
        System.out.println(leng);
    }
    // Find the first node of the loop.
    static void FirNod(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("Loop Detected");
                break;
            }
        }
        if(slow!=fast){
            System.out.println("No loop");
            return;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println("First Node of Loop is: "+slow.data);

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
        temp3.next=temp1;
//        temp4.next=temp5;
//        Node.printl(head);
//        System.out.println();
        FirNod(head);
    }
}
