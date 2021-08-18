package StackPractice.Advanced;

public class P7_NSR {
    static void NextSmallRight(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int next = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.print(next + " ");
        }
    }
    /*
    easy stack implementation
     */
    public static void main(String[] args) {
        int[] arr={6,2,5,4,5,1,6};
        NextSmallRight(arr);
    }
}
