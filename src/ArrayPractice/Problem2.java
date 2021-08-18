package ArrayPractice.company;

import java.util.Arrays;

/*
Maximum and minimum of an array using (minimum number of comparisons)
 */
public class Problem2 {
    static class Pair{
        int min;
        int max;
    }
    // Method one is Linear search
    static Pair getminmax(int[] arr) {
        int n=arr.length;
        Pair minmax = new Pair();

        if(n==1){
            minmax.max=arr[0];
            minmax.min=arr[0];
            return minmax;
        }
        if(arr[0]>arr[1]){
                minmax.max=arr[0];
                minmax.min=arr[1];
        }
        else{
                minmax.max=arr[1];
                minmax.min=arr[0];
        }
        for(int i=2;i<n;i++){
                if(arr[i]>minmax.max){
                    minmax.max=arr[i];
            }
                else if(arr[i]<minmax.min){
                    minmax.min=arr[i];
                }
        }
        return minmax;
    }
    public static void main(String[] args) {
        int[] arr={2,1,5,3,55,33,100};
        Pair minmax=getminmax(arr);
        System.out.println(minmax.max);
        System.out.println(minmax.min);
    }
}
