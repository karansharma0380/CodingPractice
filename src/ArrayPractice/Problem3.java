package ArrayPractice.company;
/*
Print left rotation of array by D places in O(n) time and O(1) space
 */
import java.util.Arrays;

public class Problem3 {
    static void Rotat(int[] arr){
        int n=arr.length;
        int temp=arr[0];
        for(int i=1;i<n;i++){
            arr[i-1]=arr[i];
        }
        arr[n-1]=temp;
    }
    static void meth1(int[] arr, int d){
        int n=arr.length;
        for(int i=0;i<d;i++){
            Rotat(arr);
        }
        // This method take O(N)+O(d) =O(N+d) = O(N)
    }
    static void meth2(int[] arr, int d){
        int n=arr.length;
        int[] temp= new int[d];
        for(int i=0;i<d;i++){
            temp[i]=arr[i];
        }
        for(int i=d;i<n;i++){
            arr[i-d]=arr[i];
        }
        for(int i=0;i<d;i++){
            arr[n-d+i]=temp[i];
        }
        // Time complexity is O(d)+O(n-d)+O(d) = O(d+ n-d +d) = O(2d+n-d) = O(n-d) = O(n)
       // Space Complexity is O(d)
    }
    static void rev1(int[] arr, int start, int end){
        while(start<end){
            int t=arr[start];
            arr[start]=arr[end];
            arr[end]=t;
            start++;
            end--;
        }
    }
    static void meth3(int[] arr, int ele){
        int n=arr.length;
        int d = ele%n;
        rev1(arr,0,d-1);
        rev1(arr, d,n-1);
        rev1(arr,0,n-1);
        // Time Complexity is O(d)+O(n-d)+O(n) = O(2n) = O(n)
        // Space Complexity is O(1)
    }
    public static void main(String[] args) {
        int[] arr={2,1,99,5,0,45,32};
        System.out.println(Arrays.toString(arr));
//        meth1(arr,2);
//        System.out.println(Arrays.toString(arr));
        meth3(arr,12);
        System.out.println(Arrays.toString(arr));
    }
}
