package BinarySearchPractice;
/*
Find the ceiling in a sorted array
Given a sorted array and a value x, the ceiling of x is the smallest element in array greater
than or equal to x, and the floor is the greatest element smaller than or equal to x.
 */
public class BinProb9 {
    static int ceil_ele(int[] arr, int ele){
        int n=arr.length;
        int start=0;
        int end=n-1;
        int res=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==ele){
                return arr[mid];
            }
            else if(ele<arr[mid]){
                res=arr[mid];
                end=mid-1;
            }
            else if(ele>arr[mid]){
                start=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 8, 10, 10, 12, 19};
        System.out.println(ceil_ele(arr,5));

    }
}
