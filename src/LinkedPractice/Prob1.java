package LinkedPractice;

public class Prob1 {
    static Node revg(Node head, int g){
        Node curr=head;
        Node prev=null;
        Node next=null;
        int c=0;
        while(curr!=null && c<g){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            c++;
        }
        if(next!=null){
            Node rest_head=revg(next,g);
            head.next=rest_head;
        }
        return prev;
    }

    static Node revy(Node head, int k){
        Node curr=head, prevFirst=null;
        boolean isFirstPass=true;

        int n=5;
        int x=(n/k);
        int b=0;
        while(curr!=null && b<x){
            Node first=curr, prev=null;
            b++;
            int count=0;
            while(curr!=null && count<k){
                Node next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }
            if(isFirstPass){
                head=prev;
                isFirstPass=false;
            }
            else{
                prevFirst.next=prev;
            }
            prevFirst=first;

        }
        return head;
    }

    public static void main(String[] args) {
        Node head=new Node(11);
        Node temp1=new Node(12);
        Node temp2=new Node(13);
        Node temp3=new Node(14);
        Node temp4=new Node(15);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        Node.printl(head);
        System.out.println();
        Node.printl(revy(head,3));
    }
}
