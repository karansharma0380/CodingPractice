package ArrayPractice.company;

import static java.lang.System.*;

public class ArrayPractice {
    static void swap(int []arr, int i, int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
// putting zero to end and maintaining order of array
    static void zeroEnd(int []arr){
            int n = arr.length;
            for(int i=0; i<n-1; i++){
                if(arr[i]==0){
                    for(int j=i+1;j<n;j++){
                        if(arr[j]!=0){
                            swap(arr,i,j);
                            break;
                        }
                    }
                }
            }
            for (int i : arr) {
                out.print(i + " ");
            }
        }
    static void zeroEnd1(int []arr){
            int count=0;
            int n = arr.length;
            for(int i=0;i<n-1;i++){
                if(arr[i]!=0){
                    swap(arr, i,count);
                    count++;
                }
            }
            for(int i=0; i<n; i++) {
                out.print(arr[i] + " ");
            }
        }
// Leader of the array
    static void Leader1(int []arr){
            int n = arr.length;
            for(int i=0; i<n;i++){
                boolean flag = false;
                for(int j=i+1; j<n;j++){
                    if(arr[i]<=arr[j]){
                        flag = true;
                        break;
                    }
                }
                if(flag==false){
                    out.print(arr[i]+" ");
                }
            }
        }
    static void Leader2(int []arr){
            int n = arr.length;
            out.print(arr[n-1]+" ");
            int mar = arr[n-1];
            for(int i=n-2;i>=0;i--){
                if(arr[i]>mar){
                    out.print(arr[i]+" ");
                    mar = arr[i];
                }
            }
        }
// Max value of arr[j]-arr[i] s.t. j>i
    static void maxsub(int []arr){
            int n = arr.length;
            int res = arr[1]-arr[0];
            for(int i=0; i<n-1;i++) {
                for (int j = i + 1; j <n; j++) {
                    res = Math.max(res, arr[j] - arr[i]);
                }
            }
            out.println(res);
        }
    static void maxsub1(int []arr){
            int n = arr.length;
            int res = arr[1]-arr[0];
            int minval = arr[0];
            for(int j=1; j<n;j++){
                res = Math.max(res, arr[j]-minval);
                minval = Math.min(minval, arr[j]);
            }
            out.print(res);
        }
// Stock, buy and sell
    static int sto(int []arr){
            int n = arr.length;
            int profit =0;
            for(int i=1;i<=n-1;i++){
                if(arr[i]>arr[i-1]) {
                    profit += arr[i] - arr[i-1];
                }
            }
            return profit; //cumulative adding the difference and eventually getting the diff between peak
                          // and valley
            // make graph
        }
// Rainwater Problem
    static int rainwater(int []arr){
            int n = arr.length; //O(n^2) casue we computed lMax and rmax for every element in the array
            int res = 0;
            for(int i=1;i<n-1;i++){
                int lMax = arr[i];
                for(int j=0;j<i;j++){
                    lMax = Math.max(lMax,arr[j]);
                }
                int rMax= arr[i];
                for(int j=i+1;j<n;j++){
                    rMax = Math.max(rMax, arr[j]);
                }
                res = res + (Math.min(lMax,rMax)-arr[i]);
            }
            return res;
        }
    static int rainwater2(int []arr){
            int n = arr.length;// O(N) coz we have pre computed the lMax and rMax for every element
            int[] lMax = new int[n];
            int[] rMax = new int[n];
            int res = 0;

            lMax[0] = arr[0];
            for(int i=1;i<n;i++){
                lMax[i] = Math.max(arr[i],lMax[i-1]);
            }
            rMax[n-1]=arr[n-1];
            for(int i=n-2;i>=0;i--){
                rMax[i]=Math.max(arr[i],rMax[i+1]);
            }
            for(int i=1;i<n-1;i++){
                res+=Math.min(lMax[i],rMax[i])-arr[i];
            }
            return res;
        }
// Maximum consecutive 1's
    static int conseOnes(int[] arr){
            int n = arr.length;
            int curr=0;
            int res =0;
            for(int i=0;i<n;i++){
                if(arr[i]==0){
                    curr=0;
                }
                else{
                    curr++;
                    res = Math.max(res,curr);
                }
            }
            return res;
        }
//Maximum sum of sub-Array
    static int maxsumSub(int []arr){
            int n = arr.length; // O(n^2)
            int res = arr[0];
            for(int i=0;i<n;i++){
                int curr=0;
                for(int j=i;j<n;j++){
                    curr = curr +arr[i];
                    res = Math.max(res,curr);
                }
            }
            return res;
        }
    static int Kadanes(int []arr){
            int n=arr.length; //O(N) Kadane's Algorithm
            int res = arr[0];
            int maxEnding =arr[0];
            for(int i=1;i<n;i++){
                maxEnding = Math.max(maxEnding+arr[i], arr[i]);
                res = Math.max(res,maxEnding);
            }
            return res;
        }
    static int maxsubevod(int[] arr){
            int n = arr.length;
            int res = 1;
            for(int i=0;i<n;i++){
                int cur =1;
                for(int j=i+1;j<n;j++){
                    if((arr[j]%2==0 && arr[j-1]%2!=0) || (arr[j]%2!=0 && arr[j-1]%2==0)){
                        cur++;
                    }
                    else{
                        break;
                    }
                }
                res=Math.max(res,cur);
            }
            return res;
        }
    static int maxsubevod2(int[] arr){
            int n=arr.length;
            int res =1;
            int cur=1;
            for(int i=1;i<n;i++){
                if((arr[i]%2==0 && arr[i-1]%2!=0) || (arr[i]%2!=0 && arr[i-1]%2==0)){
                    cur++;
                    res=Math.max(res,cur);
                }
                else{
                    cur=1;
                }
            }
            return res;
        }
    static int maxcircular(int []arr){
            int n = arr.length;
            int kadane = Kadanes(arr);
            if (kadane<0){
                return kadane;
            }
            int arr_sum=0;
            for (int i=0;i<n;i++){
                arr_sum += arr[i];
                arr[i]=-arr[i];
            }
            int max_sum = arr_sum + Kadanes(arr);
            return Math.max(max_sum, kadane);
        }
    static int Maj_ele(int[] arr){
            int n=arr.length; // O(N^2)
            int count =1;
            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]==arr[j]){
                        count++;
                    }
                }
                if(count>n/2){
                    return i;
                }
            }
            return -1;
        }
    static int Maj_ele2(int[] arr){
            int n =arr.length; // O(N) it is called Moore's Voting Algorithm
            int res=0, count=1;
            for(int i=1;i<n;i++){
                if(arr[res]==arr[i]){
                    count++;
                }
                else{
                    count--;
                }
                if(count==0){
                    res=i;
                    count=1;
                }
            }
            count=0;
            for(int i=0;i<n;i++){
                if(arr[res]==arr[i]){
                    count++;
                }
            }
            if(count<n/2){
                return -1;
            }
            return res;
        }
// Find maximum (or minimum) sum of a sub-array of size k
// Sliding Window problem
    static int slid(int []arr, int k){
            int n=arr.length; //O(N*K)
            int res=0;
            for(int i=0;i<=(n-k);i++){
                int cur=0;
                for(int j=i;j<i+k;j++){
                    cur+=arr[j];
                }
                res=Math.max(cur,res);
            }
            return res;
        }
    static int slid2(int []arr, int k) {
            int n = arr.length; // O(k)+O(n-k)= O(n-k)~O(N)
            int cur_sum=0;
            for(int i=0; i<k;i++){
                cur_sum+=arr[i];
            }
            int mx = cur_sum;
            for(int i=k;i<n;i++){
                cur_sum+=(arr[i]-arr[i-k]);
                mx=Math.max(cur_sum, mx);
            }
            return mx;
        }
    static boolean slid3(int []arr, int k, int sum){
        int n = arr.length; //array, window size and sum is given if a window with sum exist return true
        int curr_sum=0;
        for(int i=0;i<k;i++){
            curr_sum+=arr[i];
        }
        if(curr_sum==sum){
            return true;
        }
        else{
            for(int i=k;i<n;i++) {
                curr_sum += arr[i] - arr[i - k];
                if(curr_sum==sum){
                    return true;
                }
            }
            return false;
        }
    }
/* Find sub-array with given sum in an unsorted array of non-negative numbers). if elements are negative then
   sliding window won't work.
   We can solve this using hash table (it will work even if there is -ve numbers) but
   it will take O(N) time
*/
    static void slid4(int []arr, int sum){
        int n = arr.length; // O(n^2)

        for(int i=0;i<n;i++){
            int csum=0;
            for(int j=i;j<n;j++){
                csum+=arr[j];
                if(csum==sum){
                    out.println("True");
                }
            }
        }
    }

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
/* Prefix sum Technique */
//Given a fixed array and multiple queries of following types on the array, how efficiently perform these queries
/* Array = {2,8,3,9,6,5,4} and queries are getSum(0,2), getSum(1,3), getSum(2,6)
    Output - 13  20  27
    Our O(N) solution is :

    int sum=0;
    for(int i=l; i<=r; i++){
           sum+=arr[i];
    }
    return sum;

    But we want these queries to be answered in O(1) time.

    For this we will create a prefix sum array, it is an array which contains the sum of all the elements till i at
    the ith index.   Array = {2,8,3,9,6,5,4} and prefix sum array pf = {2,10,13,22,28,33,37}

 */
static void fillPrefixSum(int arr[]){
    int n = arr.length;
    int prefixSum[] = new int[n];
    prefixSum[0] = arr[0];
    for (int i = 1; i < n; i++)
        prefixSum[i] = prefixSum[i - 1] + arr[i];

    for (int i = 0; i < n; i++)
        System.out.print(prefixSum[i] + " ");

}
/* Find if there is an equilibrium point in the given array. (1. Naive and 2. Using prefix sum technique)*/
static boolean equi(int arr[]) {
    int n = arr.length;
    int l_sum=0;
    int r_sum=0;

    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            l_sum+=arr[j];
        }
        for(int k=i+1;k<n;k++){
            r_sum+=arr[k];
        }
        if(l_sum==r_sum){
            return true;
        }
    }
    return false;
}
/* Algo:- 1. Calculate the sum. before this initialize l_sum=0 and r_sum=0;
          2. r_sum = sum
          3. for each element:
                a. Subtract a[i] from the right sum
                b. Compare rsum and lsum
                c. Add a[i] to lsum
 */
static boolean equi1(int arr[]) {
    int n = arr.length; //O(N) time and O(1) space
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }
    int r_sum=sum;
    int l_sum = 0;
    for (int i = 0; i < n; i++) {
        r_sum = r_sum - arr[i];
        if (l_sum == r_sum) {
            out.println("Index is: "+i);
            return true;
        }
        l_sum += arr[i];
    }
    return false;
}
/* 1. Find the maximum appearing element in the given ranges.
r1 = {1,2,5,15}
r2 = {5,8,7,18}
So here we have four ranges 1-5, elements are {1,2,3,4,5}
                            2-8, elements are {2,3,4,5,6,7,8}
                            5-7, elements are {5,6,7}
                            15-18 elements are {15,16,17}
So maximum appearing element is 5(appearing in three ranges)

For this we can use Hashmap(easily solve the problem) but time- O(n*m) and space is O(n)
more efficient still finding couldn't understand from the vide

!! Homework
2. Check if the given array can be divided into three parts with equal sum
3. check if there is a sub-array with the 0 sum.
4. Find the longest sub-array with equal no. of 0's and 1's(super imp)

note 3 & 4 have many variations supper imp, mostly prefix sum ques come with binding of hashing concept
 */

    public static void main(String []args) {
        int arr[] = { 4,2,-2};

    }
}
