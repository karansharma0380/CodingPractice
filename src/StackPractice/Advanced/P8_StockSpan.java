package StackPractice.Advanced;
import java.util.Arrays;
import java.util.Stack;


public class P8_StockSpan {
    // O(N^2)
    static void Stock_span(int[] arr){
        int n= arr.length;
        for(int i=0;i<n;i++){
            int count=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>=arr[j]){
                    count++;
                }
                else{
                    break;
                }
            }
            System.out.print(count+" ");
        }
    }
    // O(N)
    static void Stock_span1(int[] arr){
        int n= arr.length;
        Stack<Integer> stck=new Stack<Integer>();
        int[] out2=new int[7];
        for(int i=0;i<n;i++){
            if(stck.isEmpty()){
                out2[i]=-1;
            }
            else if(!stck.isEmpty() && arr[i]<arr[stck.peek()]){
                out2[i]=stck.peek();
            }
            else if(!stck.isEmpty() && arr[i]>arr[stck.peek()]){
                while(!stck.isEmpty() && arr[i]>arr[stck.peek()]){
                    stck.pop();
                }
                if(stck.isEmpty()){
                    out2[i]=-1;
                }
                else{
                    out2[i]=stck.peek();
                }
            }
            stck.push(i);
        }

        for(int i=0;i<n;i++){
            out2[i]=i-out2[i];
        }
        System.out.println(Arrays.toString(out2));
    }

    public static void main(String[] args) {
        int[] arr={100,80,60,70,60,75,85};
        System.out.println(Arrays.toString(arr));
        Stock_span(arr);
        System.out.println();
        Stock_span1(arr);

    }
}
