package StackPractice.Advanced;

import java.util.ArrayList;
import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of n daily price quotes for
a stock and we need to calculate span of stock’s price for all n days.
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive
days just before the given day, for which the price of the stock on the current day is less than
or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the
span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
public class P3_StockSpan {
    //  O(N^2) solution
    static void stckspan(int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int span=1;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<=arr[i]){
                    span++;
                }
                else{
                    break;
                }

            }
            System.out.print(span+" ");
        }
    }
    // Using stack
    static void stckspann(int [] arr) {
    }
    public static void main(String[] args) {
        int[] arr= { 11, 13, 21, 3 };
        stckspann(arr);
    }
}
