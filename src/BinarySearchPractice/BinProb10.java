package BinarySearchPractice;
/*
Smallest alphabet greater than a given character
Given a list of sorted characters consisting of both Uppercase and Lowercase Alphabets and a
particular target value, say K, the task is to find the smallest element in the list that is
larger than K.
Letters also wrap around. For example, if K = ‘z’ and letters = [‘A’, ‘r’, ‘z’], then the answer
 would be ‘A’.
 */
public class BinProb10 {
    static char nextGreatestAlphabet(char[] arr, char ele) {
        int n=arr.length;
        int start=0;
        int end=n-1;
        int res=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ele==arr[mid]){
                start=mid+1;
            }
            else if(ele>arr[mid]){
                start=mid+1;
            }
            else if(ele<arr[mid]){
                end=mid-1;
                res= mid;
            }
        }
        return arr[res];
    }

    public static void main(String[] args) {
        char[] arr1={'a','b','e'};
        char a1='c';
        System.out.println(nextGreatestAlphabet(arr1,a1));

    }
}
