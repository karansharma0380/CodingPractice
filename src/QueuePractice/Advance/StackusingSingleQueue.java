package QueuePractice.Advance;
/*
Stack using single queue
 */
import java.util.LinkedList;
import java.util.Queue;

class StackSingleQueue{
    Queue<Integer> q=new LinkedList<Integer>();

    public void push(int x){
        q.add(x);
        for(int i=0;i< q.size()-1;i++){
            int p=q.remove();
            q.add(p);
        }
    }

    public void disp(){
        System.out.println(q);
    }

    public int pop(){
        if(q.isEmpty()){
            return -1;
        }
        int p=q.remove();
        return p;
    }
}

public class StackusingSingleQueue {
    public static void main(String[] args) {
        StackSingleQueue ssq=new StackSingleQueue();
        ssq.push(10);
        ssq.push(20);
//        ssq.push(30);
        ssq.disp();
        System.out.println(ssq.pop());
    }
}
