package Sorting;

public class MergSortLL {
//    static Node midNode(Node head){
//        Node slow=head;
//        Node fast=head;
//
//        while(fast.next!=null && fast.next.next!=null){
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//
//        return slow;
//    }
//
//    static Node Merg2SortedLL(Node a, Node b){
//        if(a==null || b==null){
//            return (a!=null)?a:b;
//        }
//        Node head=null;
//        Node tail=null;
//
//        if(a.data<b.data){
//            head=a;
//            tail=a;
//            a=a.next;
//        }
//        else{
//            head=b;
//            tail=b;
//            b=b.next;
//        }
//
//        while(a!=null && b!=null){
//            if(a.data<b.data){
//                tail.next=a;
//                tail=tail.next;
//                a=a.next;
//            }
//            else{
//                tail.next=b;
//                tail=tail.next;
//                b=b.next;
//            }
//        }
//
//        if(a==null){
//            tail.next=b;
//        }
//        else{
//            tail.next=a;
//        }
//        return head;
//    }
//
//    static Node MergsortLL(Node head){
//        //Base Condition
//        if(head==null || head.next==null){
//            return head;
//        }
//        // Breaking the List into 2 parts.
//        Node mid=midNode(head);
//        Node nhead=mid.next;
//        mid.next=null;
//
//        //Actual MergSort-------------
//
//        //First part of the list
//        Node l1=MergsortLL(head);
//
//        //Second part of the List
//        Node l2=MergsortLL(nhead);
//
//        //merging the two parts of LL
//        Node res=Merg2SortedLL(l1,l2);
//
//        return res;
//    }

    public static void main(String[] args) {

    }

}
