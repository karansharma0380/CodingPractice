package BinarySearchPractice;
/*
Finding an element in rotated sorted array
 */
public class BinProb6 {
    static int biny(int[] arr,int start, int end, int ele){
        int n=arr.length;

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
    static int elesort(int[] arr, int ele){
        int end=arr.length -1;
        int index = BinProb5.no_Rotat(arr);
        int a=biny(arr,0,index-1,ele);
        int b=biny(arr,index,end,ele);
        if(a!=-1){
            return a;
        }
        else if(b!=-1){
            return b;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] arr2={6,8,11,12,13,15,2,5};
        System.out.println(elesort(arr2,11));
    }
}
