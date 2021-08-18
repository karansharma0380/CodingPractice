package BinarySearchPractice;
/*
Ques:- Search in a row wise and column wise sorted matrix
Given an n x n matrix and a number x, find the position of x in the matrix if it is present in it.
Otherwise, print “Not Found”. In the given matrix, every row and column is sorted in increasing
order. The designed algorithm should have linear time complexity.

Input: mat[4][4] = { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48},
                      {32, 33, 39, 50}};
              x = 29
Output: Found at (2, 1)

Ans:-
Algorithm:
1. Let the given element be x, create two variable i = 0, j = m-1 as index of row and column
                                   j=m-1
                                    |
                                    |
            i=0 --> { {10, 20, 30, 40},
                      {15, 25, 35, 45},
                      {27, 29, 37, 48}}; n x m

2. Run a loop until ( (i>=0 && i<n) && (j>=0 && j<m) )
3. Check if the current element is greater than x then decrease the count of j.
                  if(arr[i][j]>ele) then j--;
Exclude the current column.
4. Check if the current element is less than x then increase the count of i.
                  if(arr[i][j]<ele) then i++
Exclude the current row.
5. If the element is equal then print the position and end.
                  if(arr[i][j]==ele) then return i,j;
 */
public class BinProb15 {
    public static void main(String[] args) {
        System.out.println("Karan Sharma");
    }
}
