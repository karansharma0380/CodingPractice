package BinarySearchPractice;
/*
Binary Search on Answer that is binary search on un-sorted array.
Ques1 - Finding the peak element problem.
A peak element is an element that is strictly greater than its neighbors.
If the array contains multiple peaks, return the index to any of the peaks.

Ques2 - Find the maximum element in an array which is first increasing and then decreasing
Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50
This is called Bitonic Array
 */
public class BinProb13 {
    static int Peak_Element(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < n - 1) {
                if (arr[mid] > arr[mid] + 1 && arr[mid] > arr[mid] - 1) {
                    return mid;
                }
                else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else if (mid == 0) {
                if (arr[0] > arr[1]) {
                    return 0;
                }
                else {
                    return 1;
                }
            }
            else if (mid == n - 1) {
                if (arr[n - 1] > arr[n - 2]) {
                    return n - 1;
                }
                else {
                    return n - 2;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={5,5,5,5,5};
        System.out.println(Peak_Element(arr));
    }
}
