package StackPractice.Advanced;
import java.util.Stack;
/*
Design a Data Structure SpecialStack that supports all the stack operations like
push(), pop(), getMin() which should return minimum element from the SpecialStack.
All these operations of SpecialStack must be O(1).

 */
 class Sup_stack{
    Stack<Integer> s;
    Stack<Integer> sup_s;
    Sup_stack(){
        s=new Stack<Integer>();
        sup_s=new Stack<Integer>();
    }
    void push(int a){
        s.push(a);
        if(sup_s.isEmpty() || sup_s.peek()>=a){
            sup_s.push(a);
        }
    }

    int pop(){
        if(s.isEmpty()){
            return -1;
        }
        int ans=s.pop();
        if(sup_s.peek()==ans){
            sup_s.pop();
        }
        return ans;
    }

    int getMin(){
        if(sup_s.isEmpty()){
            return -1;
        }
        return sup_s.peek();
    }
}
public class P12_MinStack_EXSpace {

    public static void main(String[] args) {
        Sup_stack st=new Sup_stack();
        st.push(99);
        int p=st.getMin();
        System.out.println(p);

    }
}
