package BinarySearchPractice;
/*

 */
public class BinProb12 {
    static int binfind1(int[] arr,int ele){
        int n=arr.length;
        int start = 0;
        int end= n-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==ele){
                return arr[mid];
            }
            else if(ele<arr[mid]){
                end = mid-1;
            }
            else if(ele>arr[mid]){
                start = mid+1;
            }
        }
        int a=Math.abs(ele-arr[start]);
        int b=Math.abs(ele-arr[end]);
        int c = Math.min(a,b);
        return c;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,7};
        System.out.println(binfind1(arr,6));
    }
}
