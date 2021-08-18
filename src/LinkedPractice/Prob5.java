package LinkedPractice;
/*
Segregate the even and odd linked list
 */
public class Prob5 {
    static void seg(Node head){
        Node es=null; Node eE=null;
        Node os=null; Node oE=null;
        Node curr;
        for(curr=head;curr!=null;curr=curr.next){
            int x=curr.data;
            if(x%2==0){
                if(es==null){
                    es=curr;
                    eE=es;
                }
                else{
                    eE.next=curr;
                    eE=eE.next;
                }
            }
            else{
                if(os==null){
                    os=curr;
                    oE=os;
                }
                else{
                    oE.next=curr;
                    oE=oE.next;
                }
            }
        }

        if(os==null || es==null){
            return;
        }
        eE.next=os;
        oE.next=null;
        Node.printl(es);
    }

    public static void main(String[] args) {
        Node head=new Node(11);
        Node temp1=new Node(12);
        Node temp2=new Node(13);
        Node temp3=new Node(14);
        Node temp4=new Node(15);
        Node temp5=new Node(16);
        head.next=temp1;
        temp1.next=temp2;
        temp2.next=temp3;
        temp3.next=temp4;
        temp4.next=temp5;
        Node.printl(head);
        System.out.println();
        seg(head);
    }
}
