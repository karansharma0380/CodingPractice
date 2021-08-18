package StackPractice.Advanced;
import java.util.Arrays;
import java.util.Stack;
/*
Find the largest rectangular area possible in a given histogram where the largest rectangle
can be made of a number of contiguous bars. For simplicity, assume that all bars have same
width and the width is 1 unit.
For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}.
The largest possible rectangle possible is 12.
 */
public class P9_MaxAreaHist {
    static int[] NSLeftIndex(int[] arr){
        int n= arr.length;
        int[] left=new int[n];
        Stack<Integer> stck=new Stack<Integer>();
        for(int i=0;i<n;i++){
            if(stck.isEmpty()){
                left[i]=-1;
            }
            else if(!stck.isEmpty() && arr[i]>arr[stck.peek()]){
                left[i]=stck.peek();
            }
            else if(!stck.isEmpty() && arr[i]<arr[stck.peek()]){
                while(!stck.isEmpty() && arr[i]<arr[stck.peek()]){
                    stck.pop();
                }
                if(stck.isEmpty()){
                    left[i]=-1;
                }
                else{
                    left[i]=stck.peek();
                }
            }
            stck.push(i);
        }
        return left;
    }

    static int[] NSRgihtIndex(int[] arr){
        int n= arr.length;
        int[] right=new int[n];
        Stack<Integer> stck=new Stack<Integer>();
        for(int i=n-1;i>=0;i--){
            if(stck.isEmpty()){
                right[i]=n;
            }
            else if(!stck.isEmpty() && arr[i]>arr[stck.peek()]){
                right[i]=stck.peek();
            }
            else if(!stck.isEmpty() && arr[i]<arr[stck.peek()]){
                while(!stck.isEmpty() && arr[i]<arr[stck.peek()]){
                    stck.pop();
                }
                if(stck.isEmpty()){
                    right[i]=n;
                }
                else{
                    right[i]=stck.peek();
                }
            }
            stck.push(i);
        }
        return right;
    }

    static int MAH(int[] arr){
        int n= arr.length;
        int[] r=NSRgihtIndex(arr);
        int[] l=NSLeftIndex(arr);
        int[] width=new int[n];
        int[] area=new int[n];
        for(int i=0;i<n;i++){
            width[i]=r[i]-l[i]-1;
        }
        for(int i=0;i<n;i++){
            area[i]=arr[i]*width[i];
        }

        int max=area[0];
        for(int i=1;i<n;i++){
            if(area[i]>max){
                max=area[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={6,2,5,4,5,1,6};
        System.out.println(Arrays.toString(arr));
        int ans=MAH(arr);
        System.out.println(ans);
    }
}
