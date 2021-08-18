package ArrayPractice.company;
/*
Union and intersection of two array.

************ ASSUMING NO DUPLICATES AND SORTED ***********
Algorithm for Union // O(m+n) :-
1. Use two index variables i and j, initial values i=0 and j=0.
2. if arr1[i] < arr2[j] then print arr1[i] and i++
3. if arr1[i] > arr2[j] then print arr2[j] and j++
4. if arr[i]==arr[j] then print any of them and increment both i&j
5. print remaining elements of the larger array.

Algorithm for Intersection(assuming no duplicates and sorted)// O(m+n):
1. Use two index variables i and j, initial values i=0 and j=0.
2. if arr1[i] < arr2[j] then i++
3. if arr1[i] > arr2[j] then j++
4. if arr[i]==arr[j] then print any of them and increment both i&j

************ ASSUMING THERE IS DUPLICATES AND UN-SORTED ***********
Algorithm for Union:-
1) Take a set & one by one put all values of first array & second array into it
2) Set only contains the unique elements, so it'll have the union of both two arrays
3) Time Complexity: O(n + m) for iterating the both array, where n - first array length,
 m - second array length

Algorithm for Intersection:-
1) Take a set & one by one put all values of first array
2) Now, iterate 2nd array & check if it present in 1st array, put this value in another
  new Set (i.e finalSet)
3) At last, all unique common elements will be present in finalSet
4) Time Complexity: O(n + m) for iterating the both array, where n - first array length,
m - second array length
 */
public class Problem6 {
    static void printunion(int[] arr1, int[] arr2){
        int m=arr1.length;
        int n=arr2.length;
        int i=0,j=0;
        while(i<m && j<n){
            if(arr1[i]<arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
            }
            else if(arr1[i]>arr2[j]){
                System.out.print(arr2[j]+" ");
                j++;
            }
            else {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
        }
        while(i<m){
            System.out.print(arr1[i]+" ");
            i++;
        }
        while(j<n){
            System.out.print(arr2[j]+" ");
            j++;
        }

    }
    static void printintersection(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr1={1,2,4,5,6};
        int[] arr2={2,3,5,7};
        printunion(arr1,arr2);
        System.out.println();
        printintersection(arr1,arr2);
    }
}
