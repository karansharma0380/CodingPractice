package StackPractice.Advanced;

import java.util.Arrays;

public class P11_RainWaterTrapping {
    static void RainTrap(int[] arr){
        int n=arr.length;
        int[] max_r=new int[n];
        int[] max_l=new int[n];

        max_l[0]=arr[0];
        for(int i=1;i<n;i++){
            max_l[i]=Math.max(max_l[i-1],arr[i]);
        }

        max_r[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            max_r[i]=Math.max(max_r[i+1],arr[i]);
        }

        int water=0;
        int[] w=new int[n];
        for(int i=0;i<n;i++){
            w[i]=Math.min(max_l[i],max_r[i])-arr[i];
            water+=Math.min(max_l[i],max_r[i])-arr[i];
        }

        System.out.println(water);
        System.out.println(Arrays.toString(w));

    }
    public static void main(String[] args) {
        int[] arr = {3, 0, 2, 0, 4};
        RainTrap(arr);

    }
}
