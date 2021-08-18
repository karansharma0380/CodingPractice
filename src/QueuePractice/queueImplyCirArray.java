package QueuePractice;

class QueueCA{
    int[] arr;
    int front, rear;
    int cap;
    QueueCA(int n){
        cap=n;
        front=-1;
        rear=-1;
        arr=new int[cap];
    }

    public boolean isEmpty(){
        return front==-1;
    }

    public boolean isFull(){
        return (rear+1)%cap==front;
    }

    public int size(){
        return (cap-front+rear+1)%cap;
    }

    public void enqueue(int x){
        if(isFull()){
            System.out.println("Over Flow");
        }
        else{
            rear=(rear+1)%cap;
            arr[rear]=x;
            if (front == -1) {
                front=rear;
            }
        }
    }

    public int dequeue(){
        int data=0;
        if(isEmpty()){
            return -1;
        }
        else{
            data=arr[front];
            if(front==rear){
                front=rear=-1;
            }
            else{
                front=(front+1)%cap;
            }
        }

        return data;
    }

    public void getFront(){
        System.out.println(arr[front]);
    }

    public void getRear(){
        System.out.println(arr[rear]);
    }
}
public class queueImplyCirArray {
    public static void main(String[] args) {
        QueueCA qw=new QueueCA(5);
        qw.enqueue(99);
        qw.enqueue(34);
        qw.enqueue(22);
        qw.enqueue(11);
        qw.enqueue(9);
        qw.enqueue(100);
        qw.enqueue(110);
        System.out.println(qw.isFull());
        qw.dequeue();
        qw.dequeue();
        qw.enqueue(1000);
        System.out.println();
        qw.getRear();
    }
}
