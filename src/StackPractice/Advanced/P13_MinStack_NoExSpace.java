package StackPractice.Advanced;
import java.util.Stack;

/*
Design a Data Structure SpecialStack that supports all the stack operations like
push(), pop(), getMin() which should return minimum element from the SpecialStack.
All these operations of SpecialStack must be O(1).
 */
class Stack_n{
    Stack<Integer> stck;
    int min_ele;
    Stack_n(){
        stck=new Stack<Integer>();
    }

    void push(int x){
        if(stck.isEmpty()){
            stck.push(x);
            min_ele=x;
        }
        else{
            if(x>=stck.peek()){
                stck.push(x);
            }
            else if(x<stck.peek()){
                stck.push(2*x-min_ele);
                min_ele=x;
            }
        }
    }

    void pop(){
        if(stck.isEmpty()){
            return;
        }
        else{
            if(stck.peek()>=min_ele){
                stck.pop();
            }
            else if(stck.peek()<min_ele){
                min_ele=2*min_ele- stck.peek();
                stck.pop();
            }
        }
    }

    int top(){
        if(stck.isEmpty()){
            return -1;
        }
        else{
            if(stck.peek()>=min_ele){
                stck.peek();
            }
            else if(stck.peek()<min_ele){
                return min_ele;
            }
        }
        return 0;
    }

}
public class P13_MinStack_NoExSpace {
    public static void main(String[] args) {

    }
}
