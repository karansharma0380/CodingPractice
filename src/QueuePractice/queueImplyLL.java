package QueuePractice;

class Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}

class QueueLL{
    Node front;
    Node rear;
    int size;
    QueueLL(){
        front=rear=null;
        size=0;
    }

    public boolean isEmpty(){
        return front==null;
    }

    public void enqueue(int x){
        Node temp=new Node(x);
        size++;
        if(front==null){
            front=temp;
            rear=temp;
            return;
        }

        rear.next=temp;
        rear=temp;
    }

    public void dequeue(){
        if(front==null){
            return;
        }
        size--;
        front=front.next;
        if (front==null){
            rear=null;
        }
    }

    public void getFront(){
        if(front==null){
            System.out.println("Empty");
            return;
        }
        System.out.print(front.data);
    }

    public void getRear(){
        System.out.print(rear.data);
    }
}
public class queueImplyLL {
    public static void main(String[] args) {
        QueueLL ql=new QueueLL();
        ql.enqueue(100);
        ql.enqueue(67);
        ql.getFront();
        System.out.println();
        ql.getRear();
    }
}

