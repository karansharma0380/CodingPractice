package QueuePractice.Advance;
import java.util.Queue;
import java.util.LinkedList;
/*
Stack using Queue has two solution
1. Costly Push
2. Costly Pop
 */
class CostlyPush{
    Queue<Integer> q1=new LinkedList<Integer>();
    Queue<Integer> q2=new LinkedList<Integer>();

    CostlyPush(){

    }

    public void push(int a){
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(a);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    public int pop(){
        if(q1.isEmpty()){
            return -1;
        }
        int d=q1.remove();
        return d;
    }

}

class CostlyPop {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    int size;

    CostlyPop() {
        size=0;
    }

    public void push(int a){
        q1.add(a);
        size++;
    }

    public int pop(){
        while(size!=1){
            q2.add(q1.remove());
            size--;
        }
        int d=q1.remove();
        while(!q2.isEmpty()){
            size=0;
            q1.add(q2.remove());
            size++;
        }
        return d;
    }

    public void disp(){
        System.out.print(q1);
    }
}

public class StackusingQueue {
    public static void main(String[] args) {
//        CostlyPush ps=new CostlyPush();
        CostlyPop ps=new CostlyPop();
        ps.push(10);
        ps.push(20);
        ps.push(30);
        ps.pop();
        ps.disp();
    }
}
