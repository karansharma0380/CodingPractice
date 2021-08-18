package Sorting;

import java.util.Arrays;

public class MergSort {

    static int[] Mergefunc(int[] a, int[] b){
        int m=a.length;
        int n=b.length;
        int i=0,j=0, k=0;
        int[] c=new int[m+n];

        while(i<m && j<n){
            if(a[i]<b[j]){
                c[k]=a[i];
                i++;
                k++;
            }
            else{
                c[k]=b[j];
                j++;
                k++;
            }
        }
        while(i<m){
            c[k]=a[i];
            i++;
            k++;
        }
        while(j<n){
            c[k]=b[j];
            j++;
            k++;
        }
        return c;
    }

    static int[] mergji(int[] arr, int l, int r){
        if(l==r){
            int[] b=new int[1];
            b[0]=arr[l];
            return b;
        }
        int m=l+(r-l)/2;
        int[] a1= mergji(arr,l,m);
        int[] a2=mergji(arr,m+1,r);
        int[] res=Mergefunc(a1,a2);

        return res;
    }

    public static void main(String[] args) {
//        int[] a={2,5,12,18,20};
//        int[] b={7,9,11,15,25,28,30,35};
//
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//
//        Mergefunc(a,b);

        int[] x={5,3,2,1};

        System.out.println(Arrays.toString(mergji(x,0,3)));
    }
}
