package StackPractice.Advanced;
import java.util.ArrayList;
import java.util.Stack;
//Next greater to left
public class P5_NGL {

    // O(N^2)
    static void NextGrLeft(int[] arr){
        int n=arr.length;
        int next=-1;
        System.out.print(next+" ");
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]<arr[j]){
                    next=arr[j];
                    break;
                }
            }
            System.out.print(next+" ");
        }
    }
    //O(N)
    static void NextGrLeft1(int[] arr){
        int n= arr.length;
        Stack<Integer> stk=new Stack<Integer>();
        ArrayList<Integer> art=new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(stk.isEmpty()){
                art.add(-1);
            }
            else if(!stk.isEmpty() && stk.peek()>arr[i]){
                art.add(stk.pop());
            }
            else if(!stk.isEmpty() && stk.peek()<=arr[i]){
                while(!stk.isEmpty() && stk.peek()<=arr[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    art.add(-1);
                }
                else{
                    art.add(stk.peek());
                }
            }
            stk.push(arr[i]);
        }
        System.out.println(art);
        }
    public static void main(String[] args) {
        int[] arr= { 1,3,2,4 };
        NextGrLeft(arr);
        System.out.println();
        NextGrLeft1(arr);
    }
}
