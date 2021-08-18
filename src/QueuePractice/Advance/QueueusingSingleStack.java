package QueuePractice.Advance;

import java.util.Stack;

class Queue1Stack{
    Stack<Integer> stck=new Stack<Integer>();

    public void add_d(int x){
        stck.push(x);
    }

    public int removee(){
        if(stck.size()==1){
            return stck.pop();
        }
        int cur_val=stck.pop();
        int r=removee();
        stck.push(cur_val);
        return r;
    }
}
public class QueueusingSingleStack {
    public static void main(String[] args) {
        Queue1Stack st=new Queue1Stack();
        st.add_d(10);
        st.add_d(20);
        System.out.println(st.removee());
    }
}
