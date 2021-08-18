package QueuePractice;

class Queuel{
    int[] arr;
    int size;
    int cap;
    int front,rear;

    Queuel(int n){
        cap=n;
        arr=new int[cap];
        size=0;
        front=-1;
        rear=-1;
    }

    public boolean enqueue(int x){
        boolean response=false;
        if(rear!=arr.length-1){
            rear++;
            arr[rear]=x;
            size++;
            response=true;
        }
        return response;
    }
    public boolean dequeue(){
        boolean re=false;
        if(size!=0){
            front++;
            for(int i=0;i< arr.length-1;i++){
                arr[i]=arr[i+1];
            }
            arr[rear]=0;
            size--;
            rear--;
            re=true;
            return re;
        }
        return re;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public int getFront(){
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    public int getRear(){
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }
    public void getElen(){
        int n=arr.length;
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
public class queueImplyArray {
    public static void main(String[] args) {
        Queuel qw=new Queuel(4);
        qw.enqueue(50);
        qw.enqueue(100);
        qw.enqueue(500);
        qw.enqueue(99);
        qw.getElen();
        System.out.println();
        qw.dequeue();
        qw.getElen();
        System.out.println();
        System.out.println(qw.getFront());



    }
}
