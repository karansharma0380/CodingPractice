package StackPractice.Advanced;
/*
Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should
use only one array, i.e., both stacks should use the same array for storing elements.
Following functions must be supported by twoStacks.
push1(int x) –> pushes x to first stack
push2(int x) –> pushes x to second stack
pop1() –> pops an element from first stack and return the popped element
pop2() –> pops an element from second stack and return the popped element
Implementation of twoStack should be space efficient.
 */
public class P1_2stck1arrr {
    int[] arr;
    int cap, top1,top2;

    P1_2stck1arrr(int n){
        arr=new int[n];
        cap=n;
        top1=-1;
        top2=cap;
    }

    void push1(int x){
        if(top1<top2-1){
            top1++;
            arr[top1]=x;
        }
        else{
            System.out.print("Overflow");
        }
    }

    void push2(int x){
        if(top1<top2-1){
            top2--;
            arr[top2]=x;
        }
        else{
            System.out.print("Overflow");
        }
    }

    int pop1(){
        if(top1>=0){
            int r=arr[top1];
            top1--;
            return r;
        }
        else{
            return -1;
        }
    }

    int pop2(){
        if(top2<cap){
            int r=arr[top2];
            top2++;
            return r;
        }
        else{
            return -1;
        }
    }

    void disp(){
        for (int i=0;i<cap;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        P1_2stck1arrr ts=new P1_2stck1arrr(6);
        ts.push1(10);
        ts.push1(20);
        ts.push1(30);
        ts.push2(10);
        ts.push2(20);
        ts.push2(30);
        ts.push1(555);
        ts.disp();

    }
}
