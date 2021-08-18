package StackPractice;
import java.util.ArrayList;

class staack{

    private ArrayList<Integer> str;
    int top=-1;

    public staack(){
        str=new ArrayList<Integer>();
    }

    public void push(int x){
        top++;
        str.add(top,x);
    }

    public String tstr(){
        return ""+str.toString();
    }

    public int pop(){
        int re=str.get(top);
        top--;
        return re;
    }

    public int peek(){
        if(str.size()==0){
            System.out.println("Stack is Empty");
        }
        return str.get(top);
    }

    public int sizee(){
        return top+1;
    }

    public boolean isEmp(){
        if(str.size()==0){
            return true;
        }
        else{
            return false;
        }
    }

}
public class StackUsingArray {
    public static void main(String[] args) {
        staack srt=new staack();
        srt.push(99);
        srt.push(100);
        System.out.println(srt.isEmp());
        System.out.println(srt.peek());
        System.out.println(srt.tstr());
        System.out.println(srt.sizee());
    }
}
