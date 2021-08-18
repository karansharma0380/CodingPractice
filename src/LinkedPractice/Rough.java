package LinkedPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Rough {

    static Node rev(Node head){
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

//    static Node pivot(Node head){
//        Node curr=head;
//        while(curr.next!=null){
//            curr=curr.next;
//        }
//        return curr;
//    }
//
//   static Node LamutoLL(Node head){
//        Node curr=head;
//        Node pivot=pivot(head);
//        Node smaller=new Node(-1,head);
//        Node ps=smaller;
//        Node larger=new Node(-1,head);
//        Node pl=larger;
//
//        while(curr!=null){
//            if(curr.data<=pivot.data){
//                ps.next=curr;
//                ps=ps.next;
//            }
//            else{
//                pl.next=curr;
//                pl=pl.next;
//            }
//            curr=curr.next;
//        }
//        ps.next=larger.next;
//        pl.next=null;
//
//        return smaller.next;
//   }
//
    static Node HoarseLL(Node head, int pivot_idx){
        //Pivot Around the mentioned index
        //Finding the Pivot_index
        int idx=0, data=0;
        Node curr=head;
        while(curr!=null){
            if(idx==pivot_idx){
                data=curr.data;
                break;
            }
            curr=curr.next;
            idx++;
        }


        //Actual sorting work
        Node smaller=new Node(-1);
        Node ps=smaller;
        Node larger=new Node(-1);
        Node pl=larger;
        Node pivot=null;
        curr=head;
        idx=0;

        while(curr!=null){
            if(idx==pivot_idx){
                pivot=curr;
            }
            else if(curr.data<=data){
                ps.next=curr;
                ps=ps.next;
            }
            else{
                pl.next=curr;
                pl=pl.next;
            }
            curr=curr.next;
            idx++;
        }
        ps.next=pivot;
        pivot.next=larger.next;
        pl.next=null;

        return smaller.next;
    }

    static int leng(Node head){
        if(head==null){
            return 0;
        }
        int l=0;
        Node curr=head;
        while(curr!=null){
            l++;
            curr=curr.next;
        }
        return l;
    }

    static Node[] HoarseUsedForLL(Node head, int pivotIndex){
        Node smaller=new Node(-1);
        Node larger=new Node(-1);
        Node ps=smaller;
        Node pl=larger;

        Node pivot_ele=head;
        while(pivotIndex-- >0){
            pivot_ele=pivot_ele.next;
        }

        Node curr=head;
        while(curr!=null){
            if(curr.data<=pivot_ele.data){
                ps.next=curr;
                ps=ps.next;
            }
            else{
                pl.next=curr;
                pl=pl.next;
            }
            curr=curr.next;
        }

        ps.next=null;
        pl.next=null;
        pivot_ele.next=null;

        return new Node[]{smaller.next, pivot_ele, larger.next};
    }

    static Node[] QuickSortLL_(Node head) {
        if (head == null || head.next == null) {
            return new Node[]{head, head};
        }

        int length=leng(head);
        int pivot_index=length/2;//We chose mid element to be the pivot element

        //Below we got an array containing segregated list heads and pivot element in the middle
        Node[] segregatedList = HoarseUsedForLL(head,pivot_index);

        Node[] leftsegregatedList = QuickSortLL_(segregatedList[0]);
        Node[] rightsegregatedList = QuickSortLL_(segregatedList[2]);

        return mergesortedLL(leftsegregatedList,segregatedList[1],rightsegregatedList);

    }

    static Node[] mergesortedLL(Node[] leftsegregatedList, Node pivotNode,Node[] rightsegregatedList){

        Node head=null, tail=null;
        //Pivot element cannot be null

        if(leftsegregatedList[0]!=null && rightsegregatedList[0]!=null){
            leftsegregatedList[1].next=pivotNode;
            pivotNode.next=rightsegregatedList[0];
            head=leftsegregatedList[0];
            tail=rightsegregatedList[1];
        }
        else if(leftsegregatedList[0]!=null){
            head=leftsegregatedList[0];
            leftsegregatedList[1].next=pivotNode;
            tail=pivotNode;
        }
        else if(rightsegregatedList!=null){
            head=pivotNode;
            pivotNode.next=rightsegregatedList[0];
            tail=rightsegregatedList[1];
        }
        else{
            head=tail=pivotNode;
        }
        return new Node[] {head,tail};
    }

    // Actual QuickSort function
    static Node quickSort(Node head){
        return QuickSortLL_(head)[0];
    }

    static void revprint(DNode head){
        DNode curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }

    }

    static Node sep(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node zeros=new Node(-1);
        Node pz=zeros;
        Node Ones=new Node(-1);
        Node po= Ones;
        Node Twos=new Node(-1);
        Node pt=Twos;

        Node curr=head;

        while(curr!=null){
            if(curr.data==0){
                pz.next=curr;
                pz=pz.next;
            }
            else if(curr.data==1){
                po.next=curr;
                po=po.next;
            }
            else{
                pt.next=curr;
                pt=pt.next;
            }
            curr=curr.next;
        }

        pz.next=Ones.next;
        po.next=Twos.next;
        pt.next=null;

        return zeros.next;
    }

    static ArrayList<String> subsequence(String str){
        if(str.length()==0){
            ArrayList<String> bres=new ArrayList<String>();
            bres.add("_");
            return bres;
        }

        char ch=str.charAt(0);
        String ress=str.substring(1);
        ArrayList<String> rres=subsequence(ress);

        ArrayList<String> mres=new ArrayList<String>();
        for(String i:rres){
            mres.add("_"+i);
            mres.add(ch+i);
        }
        return mres;
    }


    public static void main(String[] args) {
        Node head=new Node(2);
        Node t1=new Node(1);
        Node t2=new Node(1);
        Node t3=new Node(1);
        Node t4=new Node(0);
        Node t5=new Node(1);
        Node t6=new Node(1);
        Node t7=new Node(2);
        Node t8=new Node(0);
        Node t9=new Node(1);
        Node t10=new Node(0);
        Node t11=new Node(1);

        head.next=t1;
        t1.next=t2;
        t2.next=t3;
        t3.next=t4;
        t4.next=t5;
        t5.next=t6;
        t6.next=t7;
        t7.next=t8;
        t8.next=t9;
        t9.next=t10;
        t10.next=t11;

        DNode head1=new DNode(1);
        DNode r1=new DNode(2);
        DNode r2=new DNode(4);
        DNode r3=new DNode(5);
        DNode r4=new DNode(6);
        DNode r5=new DNode(8);
        DNode r6=new DNode(9);

        head1.next=r1;
        r1.prev=head1;

        r1.next=r2;
        r2.prev=r1;

        r2.next=r3;
        r3.prev=r2;

        r3.next=r4;
        r4.prev=r3;

        r4.next=r5;
        r5.prev=r4;

        r5.next=r6;
        r6.prev=r5;


//        Node.printl(head);
//        System.out.println();

//        HoarseLL(head,5);

//        Node.printl(sep(head));

//        revprint(head1);
//        System.out.println();
//        RevDLL(head1,7);

        String str="abc";
        ArrayList<String> res=subsequence(str);
        System.out.println(res);
    }
}
