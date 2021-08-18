package BinarySearchPractice;
/*
Just note one thing that whenever you see sorted in question, just keep binary search in option of
approaches. Coz they have mentioned sorted for a reason.
 */
public class Binary_search {
    // Time complexity is O(log n) and Space Complexity is O(1)
    static int binsearch1(int[] arr,int ele){
        int n=arr.length;
        int start = 0;
        int end= n-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==ele){
                return mid;
            }
            else if(ele<arr[mid]){
                end = mid-1;
            }
            else if(ele>arr[mid]){
                start = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        System.out.println(binsearch1(arr,312));
    }
}
