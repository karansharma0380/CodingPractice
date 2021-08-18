package ArrayPractice.company;
import java.util.Arrays;
/*
Sort an array of 0s, 1s and 2s
Input: {0, 1, 2, 0, 1, 2}
Output: {0, 0, 1, 1, 2, 2}

Ans:- 1)Just use sort function but this will take O(nlongn) time.
      2)See below solution for O(N) time.
 */
public class Problem4 {
    static void meth2(int[] arr){
        int n=arr.length;
        int low=0;
        int high=n-1;
        int mid=0;
        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    int t=arr[mid];
                    arr[mid]=arr[low];
                    arr[low]=t;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int c=arr[mid];
                    arr[mid]=arr[high];
                    arr[high]=c;
                    high--;
                    break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr={0, 1, 2, 0, 1, 2};
        meth2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
