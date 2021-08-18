package BinarySearchPractice;

import java.sql.SQLOutput;

/*
Order Agnostic Search- Don't know whether order is ascending or descending.
 */
public class BinProb2 {
    static void agnoSearch(int[] arr, int ele){
        int n=arr.length;
        if(n==1){
            if(ele==arr[0]){
                System.out.println(0);
            }
            else{
                System.out.println("Element not found!!!");
            }
        }
        else if(n==2){
            if(ele==arr[0]){
                System.out.println(0);
            }
            else if(ele==arr[1]){
                System.out.println(1);
            }
            else{
                System.out.println("Element not found!!!");
            }
        }
        else if(n>2){
            if(arr[0]>arr[1]){
                System.out.println(BinProb1.RevBin(arr,ele));
            }
            else if(arr[0]<arr[1]){
                System.out.println(Binary_search.binsearch1(arr,ele));
            }
            else{
                System.out.println("Element not found!!!!");
            }
        }

    }
    public static void main(String[] args) {
        int[] arr={7,6};
        agnoSearch(arr,99);
    }
}
