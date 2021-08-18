package BinarySearchPractice;
/*
How many times a sorted array is rotated
suppose array is = {2,5,6,8,11,12,15,18}
not after rotation={11,12,15,18,2,5,6,8}(This will be given to you)
 */
public class BinProb5 {
    static int no_Rotat(int[] arr){
        int n=arr.length;
        int start=0;
        int end=n-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int next= (mid+1)%n;
            int prev= (mid-1+n)%n;
            if(arr[mid]<arr[next] && arr[mid]<arr[prev]){
                return mid;
            }
            if(arr[0]<=arr[mid]){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr={2,5,6,8,11,12,13,15};
        int[] arr1={13,15,2,5,6,8,11,12};
        int[] arr2={6,8,11,12,13,15,2,5};
        System.out.println("Rotated "+no_Rotat(arr)+" Times");
        System.out.println("Rotated "+no_Rotat(arr1)+" Times");
        System.out.println("Rotated "+no_Rotat(arr2)+" Times");

    }

}
