package ArrayPractice.company;

import java.util.Arrays;

/*
Move all negative numbers to beginning and positive to end with constant extra space

Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
Output: -12 -13 -5 -7 -3 -6 11 6 5
 */
public class Problem5 {
    static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static void meth0(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                for(int j=i+1;j<n;j++){
                    if(arr[j]<0){
                        swap(arr,i,j);
                        break;
                    }
                }
            }
        }
    }
    static void meth1(int[] arr) {
        // O(N) time and O(1) space this is Two-Pointer Approach
        int n = arr.length;
        int start=0;
        int end=n-1;
        while(start<=end) {
            if (arr[start] < 0 && arr[end] < 0) {
                start++;
            }
            else if (arr[start] >= 0 && arr[end] < 0) {
                int t = arr[start];
                arr[start] = arr[end];
                arr[end] = t;
                start++;
                end--;
            }
            else if (arr[start] >= 0 && arr[end] > 0){
                end--;
        }
            else{
                start++;
                end--;
            }

        }
    }
    static void meth2(int[] arr) {
        // O(N) time and O(1) space Using Single Pointer
        int n = arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]<0){
                swap(arr,i,count);
                count++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={-12, 11, -13, -5, 6,0, -7, 5, -3, -6,-7,12,12};
        int[] arr1={5,4,3,0,0,3,0,3};
        System.out.println("Real Array: "+Arrays.toString(arr));
        meth1(arr);
        System.out.println("O(N) Two pointer:   "+Arrays.toString(arr));//Not working with zero
        meth2(arr);
        System.out.println("O(N) keeping count: "+Arrays.toString(arr));
        meth0(arr);
        System.out.println("O(N^2) solution:    "+Arrays.toString(arr));
    }
}
