package ArrayPractice;
import java.util.Arrays;

public class Problem7 {
    static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static int lead1(int[] arr) {
        int n = arr.length;
        int res=0;
        for(int i=0;i<n;i++){
            int cur=0;
            for(int j=i;j<n;j++){
                if(arr[j]==1){
                    cur++;
                }
                else{
                    break;
                }
            }
            res=Math.max(res,cur);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={0,1,1,1,0,1,1};
        System.out.println(lead1(arr));
    }
}
