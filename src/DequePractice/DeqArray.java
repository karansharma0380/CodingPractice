package DequePractice;

class DeqAR{
    int[] arr;
    int front;
    int rear;
    int size;
    int cap;
    DeqAR(int n){
        cap=n;
        arr=new int[cap];
        front=-1;
        rear=-1;
    }

    public boolean isEmpty(){
        return (front==-1 && rear==-1);
    }

    public boolean isFull(){
        return ((front==0 && rear==cap-1) || (front==rear+1));
    }

    public void EnqFront(int x){
        if(isFull()){
            System.out.println("OverFlow");
        }
        else{
            if(isEmpty()){
                front=rear=0;
                arr[front]=x;
            }
            else if(front==0){
                front=cap-1;
                arr[front]=x;
            }
            else{
                front--;
                arr[front]=x;
            }
        }
    }

    public void EnqRear(int x){
        if(isFull()){
            System.out.println("OverFlow");
        }
        else{
            if(isEmpty()){
                front=rear=0;
                arr[rear]=x;
            }
            else if(rear==cap-1){
                rear=0;
                arr[rear]=x;
            }
            else{
                rear++;
                arr[rear]=x;
            }
        }
    }

    public void deqFront(){
        if(isEmpty()){
            System.out.println("UnderFlow");
        }
        else if(front==rear){
            System.out.println("Deleted Element: "+arr[front]);
            front=rear=-1;
        }
        else if(front==size-1){
            System.out.println("Deleted Element: "+arr[front]);
            front=0;
        }
        else{
            System.out.println("Deleted Element: "+arr[front]);
            front++;
        }
    }

    public void deqRear(){
        if(isEmpty()){
            System.out.println("UnderFlow");
        }
        else if(front==rear){
            System.out.println("Deleted Element: "+arr[rear]);
            front=rear=-1;
        }
        else if(rear==0){
            System.out.println("Deleted Element: "+arr[rear]);
            rear=cap-1;
        }
        else{
            System.out.println("Deleted Element: "+arr[rear]);
            rear--;
        }
    }

    public void disp(){
        int i=front;
        while( i!=rear){
            System.out.print(arr[i]+" ");
            i=(i+1)%cap;
        }
        System.out.print(arr[i]);
    }

}
public class DeqArray {
    public static void main(String[] args) {
        DeqAR dq=new DeqAR(4);
        dq.EnqFront(10);
        dq.EnqFront(20);
        dq.EnqRear(90);
        dq.EnqRear(80);
        dq.disp();
    }
}
