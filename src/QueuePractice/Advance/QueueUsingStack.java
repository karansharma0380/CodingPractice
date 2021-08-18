package QueuePractice.Advance;

import java.util.Stack;

class Queue_addCostly{
    Stack<Integer> st1=new Stack<Integer>();
    Stack<Integer> st2=new Stack<Integer>();

    public void add_d(int x){
        if(st1.isEmpty()){
            st1.push(x);
        }
        else{
            while(!st1.isEmpty()){
                st2.push(st1.pop());
            }
            st1.push(x);
            while(!st2.isEmpty()){
                st1.push(st2.pop());
            }
        }
    }

    public void disp(){
        System.out.println(st1);
    }

    public int popp(){
        if(st1.isEmpty()){
            return -1;
        }
        int x=st1.pop();
        return x;
    }
}

class Queue_removeCostly{
    Stack<Integer> st1=new Stack<Integer>();
    Stack<Integer> st2=new Stack<Integer>();

    public void add_d(int x){
        st1.push(x);
    }

    public int removee(){
        if(st1.isEmpty()){
            return -1;
        }
        for(int i=0;i<st1.size();i++){
            st2.push(st1.pop());
        }
        int d=st1.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return d;
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {
        Queue_removeCostly stq=new Queue_removeCostly();
        stq.add_d(1);
        stq.add_d(5);
        stq.add_d(3);
        System.out.println(stq.removee());
        stq.add_d(2);
        System.out.println(stq.removee());
    }
}
