package BinarySearchPractice;
/*
Find the floor of the given element in the sorted array
Given a sorted array and a value x, the floor of x is the largest element in array smaller
than or equal to x.
 */
public class BinProb8 {
    static int floor_ele(int[] arr, int ele){
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
                end=mid-1;
            }
            else if(ele>arr[mid]){
                res=arr[mid];
                start=mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1, 2, 8, 10, 10, 12, 19};
        System.out.println(floor_ele(arr,5));

    }
}
