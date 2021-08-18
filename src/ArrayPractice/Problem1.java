package ArrayPractice.company;
import java.util.Arrays;
/*
Write a program to reverse an array or string.
 */
public class Problem1 {
    // Iterative way
    static void rev1(int[] arr){
        int n=arr.length;
        int i=0;
        int j=n-1;
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    // Recursive Way
    static void rev2(int[] arr, int i, int j){
        int n=arr.length;
        if(i<j){
            return;
        }
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        rev2(arr,i+1,j-1);
    }

    public static void main(String[] args) {
        String s1 = "Karan";
        int[] arr = {1,2,3,4,4,5};
        int n= arr.length;
        int j=n-1;
        int i=0;
        System.out.println("Actual Array: "+ Arrays.toString(arr));
        rev1(arr);
        System.out.println("Iterative Way: "+Arrays.toString(arr));
        rev2(arr,i,j);
        System.out.println("Recursive Way: "+Arrays.toString(arr));
    }
}
