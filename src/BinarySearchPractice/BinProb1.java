package BinarySearchPractice;
/*
Binary search on descending array
 */
public class BinProb1 {
    static int RevBin(int[] arr, int ele){
        int n=arr.length;
        int start=0;
        int end=n-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(ele==arr[mid]){
                return mid;
            }
            else if(ele<arr[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={7,6,5,4,3,2,1};
        System.out.println(RevBin(arr,5));
    }
}
