package QueuePractice.Advance;

public class MaximumInSubarraySizeK {
    static void MaxK(int[] arr, int k){
        int n=arr.length;
        for(int i=0;i<n-k+1;i++){
            int mx=arr[i];
            for(int j=i+1;j<i+k;j++){
                mx=Math.max(mx,arr[j]);
            }
            System.out.print(mx+" ");
        }
    }
    public static void main(String[] args) {
        int[] a={10,8,5,12,15,7,6};
        MaxK(a,3);
    }
}
