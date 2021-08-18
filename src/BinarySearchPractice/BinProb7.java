package BinarySearchPractice;
/*
Finding an element in nearly sorted array.
 */
public class BinProb7 {
    static int modified_bin(int[] arr, int ele){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start + (end-start)/2;
            if(ele==arr[mid]){
                return mid;
            }
            if(mid-1>=start && arr[mid-1]==ele){
                return mid-1;
            }
            if(mid+1<=end && arr[mid+1]==ele){
                return mid+1;
            }
            else if(ele<arr[mid]){
                end=mid-2;
            }
            else if(ele>arr[mid]){
                start=mid+2;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr2={5,10,30,20,40};
        System.out.println(modified_bin(arr2,40));
    }
}
