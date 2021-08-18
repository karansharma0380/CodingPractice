package StackPractice;
import java.util.EmptyStackException;

public class StackUsingLL {

    private Node top;
    private int size=0;

    private class Node{
        int data;
        Node next;
        Node (int x){
            data=x;
            next=null;
        }
    }
    public void push(int x){
        if (top == null)
        {
            top = new Node(x);
        }
        Node temp=new Node(x);
        temp.next=top;
        top=temp;
        size++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int re= top.data;
        top=top.next;
        size--;
        return re;
    }

    public void disp(){
        Node curr=top;
        while (curr != null) {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
    }
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public static void main(String[] args) {

        StackUsingLL str=new StackUsingLL();
        str.push(10);
        str.push(20);
        str.push(30);
        str.push(40);
        str.push(50);
        str.pop();
        System.out.println(str.size());
    }
}
