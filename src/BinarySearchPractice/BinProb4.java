package BinarySearchPractice;
/*
Count of an Element in a Sorted Array
 */
public class BinProb4 {
    static int countele(int[] arr, int ele){
        int a=BinProb3.Firstoccur(arr,ele);
        int b=BinProb3.Lastoccur(arr,ele);
        int c=b-a+1;
        return c;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,5,5,6,7,8};
        System.out.println(countele(arr,5));
    }
}
