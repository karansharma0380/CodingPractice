package LinkedPractice;

class Node {
    int data;
    Node next;
    Node(int x) {
        data = x;
        next = null;
    }
    Node() {
    }
    Node(int x, Node next){
        this.data=x;
        this.next=next;
    }
    public static void printl(Node head){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
}

class DNode{
    int data;
    DNode next;
    DNode prev;
    DNode(int x){
        data=x;
        next=null;
        prev=null;
    }
}

