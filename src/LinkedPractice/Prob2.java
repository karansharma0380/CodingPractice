package LinkedPractice;

import java.util.HashSet;

/*
Detect a loop in linked list
 */
class Node1{
    int data;
    Node1 next;
    boolean visited;
    Node1(int x){
        int data=x;
        next=null;
        visited=false;
    }
}

public class Prob2 {
    //Naive solution using 2 Loops -- O(N*N) [More time]
    static void deloop(Node head){
        Node curr;
        boolean flag=false;
        for(curr=head;curr!=null;curr=curr.next){
            Node c;
            for(c=head;c!=curr;c=c.next){
                if(c==curr.next){
                    System.out.print("Loop exists");
                    flag=true;
                    break;
                }
            }
            if(flag==true){
                break;
            }
        }
        if(curr==null){
            System.out.println("No loop exist");
        }
    }
    // Modification in the structure of Linked List O(N) [Modified structure takes extra space]
    static void modif(Node1 head){
        Node1 curr=head;
        while(curr!=null && curr.next!=null){
            curr.visited=true;
            if(curr.next.visited==true){
                System.out.println("Loop exists");
                break;
            }
            else{
                curr=curr.next;
            }
        }
        if(curr==null || curr.next==null){
            System.out.println("No Loop present");
        }
    }
    // Change the reference of Node to the temp Node method -- O(N) [Destroy the LL but tell ans]
    static void tem(Node head){
        Node curr=head;
        Node tep=new Node();
        while(curr!=null){
            if(curr.next==tep){
                System.out.println("Loop exits");
            }
            else if(curr.next==null){
                System.out.println("No loop");
            }
            Node curr_next=curr.next;
            curr.next=tep;
            curr=curr_next;
        }
    }
    // using hashmap/hashing-- O(N) time & O(N) space [Space issue]
    static void hush(Node head){
        HashSet<Node> hs=new HashSet<Node>();
        boolean flag=false;
        for(Node curr=head;curr!=null;curr=curr.next){
            if(hs.contains(curr)){
                System.out.println("Loop exist");
                flag=true;
                break;
            }
            hs.add(curr);
        }
        if(flag==false){
            System.out.println("No Loop");
        }
    }
    //Floyd's Cycle Detection
    /*
    1. fast pointer will enter the loop before or at same time as slow pointer.
    2. Let fast_p be k distance ahead of slow_p enters the loop where K>=0
    3. This distance keeps on increasing by one in every movement of both pointers
    4. When distance becomes length of cycle, the meet

    Time complexity -----------
    In a Linked List
    (a). if length of loop is n then time taken will be O(n), But how?
          When the slow_p is at the node on entry of loop then fast_p will already be in
          loop, and dist between them will be K(no. of edges),, when value of k becomes
          equal to value of n then the both the pointers will be at the same node.
     (b). to traverse the Linked list that out of the loop has suppose m length then the
            time will be O(m)
     (c). total time = O(m) + O(n) and O(m+n) is length of LL
     */
    static boolean floyd(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
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
        hush(head);
    }
}
