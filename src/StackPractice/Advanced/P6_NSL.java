package StackPractice.Advanced;

public class P6_NSL {
    static void LeftSmallEle(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int next=-1;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    next=arr[j];
                    break;
                }
            }
            System.out.print(next+" ");
        }
    }
    /*
    Stack se easy implementation hai do it your way
     */
    public static void main(String[] args) {
        int[] arr={6,2,5,4,5,1,6};
        LeftSmallEle(arr);

    }
}
