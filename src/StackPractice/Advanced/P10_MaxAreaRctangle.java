package StackPractice.Advanced;

import java.util.Arrays;

/*
Input:
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
Output :
1 1 1 1
1 1 1 1
Explanation :
The largest rectangle with only 1's is from
(1, 0) to (2, 3) which is
1 1 1 1
1 1 1 1
 */
public class P10_MaxAreaRctangle {
    static void MAR(int n , int m, int[][] arr){
        int[] out=new int[m];
        for(int j=0;j<m;j++){
            out[j]=arr[0][j];
        }
        int max=P9_MaxAreaHist.MAH(out);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    out[j]=0;
                }
                else{
                    out[j]=out[j]+arr[i][j];
                }
            }
        }
        System.out.println("Max area of Rectangle: "+max);
    }
    public static void main(String[] args) {
        int A[][] = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        MAR(4,4,A);
    }
}
