package BinarySearchPractice;
/*
First and Last Occurrences of an element
 */
public class BinProb3 {
    static int Firstoccur(int[] arr, int ele){
        int n=arr.length;
        int start=0;
        int end=n-1;
        int res=0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(ele==arr[mid]){
                res=mid;
                end=mid-1;
            }
            else if(ele<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return res;
    }
    static int Lastoccur(int[] arr, int ele){
        int n=arr.length;
        int start=0;
        int end=n-1;
        int res=0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(ele==arr[mid]){
                res=mid;
                start=mid+1;
            }
            else if(ele<arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,5,5,6,7,8};
        System.out.println(Firstoccur(arr,5));
        System.out.println(Lastoccur(arr,5));
    }
}
