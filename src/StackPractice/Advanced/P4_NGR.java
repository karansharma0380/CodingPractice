package StackPractice.Advanced;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
// Nearest greater to the right
public class P4_NGR {
    static void revstr(ArrayList arr) {
        int n = arr.size();
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(arr.get(i) + " ");
        }
    }

    // O(n^2) conceptually not looking good
    static void NGRsol1(int[] arr){
        int n=arr.length;
        ArrayList<Integer> ar1=new ArrayList<Integer>(n);
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if (arr[i] < arr[j])
                {
                    ar1.add(arr[j]);
                    break;
                }
                ar1.add(-1);
            }
        }
        ar1.add(-1);
        System.out.println(ar1);
    }
    // O(n^2) conceptually strong answer
    static void NGRsol2(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int next=-1;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    next=arr[j];
                    break;
                }
            }
            System.out.print(next+" ");
        }
    }
    // O(N)
    static void NextGrRight(int[] arr){
        int n=arr.length;
        ArrayList<Integer> art=new ArrayList<Integer>();
        Stack<Integer> stk=new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
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
        int[] arr= { 11, 13, 21, 3 };
        System.out.println(Arrays.toString(arr));
        NGRsol1(arr);
        NGRsol2(arr);
        System.out.println();
        NextGrRight(arr); // Just reverse this
    }
}
