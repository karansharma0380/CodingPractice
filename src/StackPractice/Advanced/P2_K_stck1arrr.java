package StackPractice.Advanced;
/*
Create a data structure kStacks that represents k stacks. Implementation of kStacks should use
only one array, i.e., k stacks should use the same array for storing elements. Following
functions must be supported by kStacks.

push(int x, int sn) –> pushes x to stack number ‘sn’ where sn is from 0 to k-1
pop(int sn) –> pops an element from stack number ‘sn’ where sn is from 0 to k-1

Method 1 (Divide the array in slots of size n/k)
A simple way to implement k stacks is to divide the array in k slots of size n/k each, and
fix the slots for different stacks, i.e., use arr[0] to arr[n/k-1] for first stack, and
arr[n/k] to arr[2n/k-1] for stack2 where arr[] is the array to be used to implement two stacks
 and size of array be n.

The problem with this method is inefficient use of array space. A stack push operation may
result in stack overflow even if there is space available in arr[]. For example, say the k
is 2 and array size (n) is 6 and we push 3 elements to first and do not push anything to second
second stack. When we push 4th element to first, there will be overflow even if we have space
for 3 more elements in array.

Method 2 (A space efficient implementation)
The idea is to use two extra arrays for efficient implementation of k stacks in an array.
This may not make much sense for integer stacks, but stack items can be large for example
stacks of employees, students, etc where every item is of hundreds of bytes. For such large
stacks, the extra space used is comparatively very less as we use two integer arrays as extra
space.

Following are the two extra arrays are used:
1) top[]: This is of size k and stores indexes of top elements in all stacks.
2) next[]: This is of size n and stores indexes of next item for the items in array data[].
           Here data[] is actual array that stores the elements of k stacks.
All entries in top[] are initialized as -1 to indicate that all stacks are empty.
All entries next[i] are initialized as i+1 because all slots are free initially and pointing
to next slot.

Together with k stacks, a stack of free slots in arr[] is also maintained. The top of this
stack is stored in a variable ‘free’.
 */
public class P2_K_stck1arrr {
    int[] next;// stores the next empty index value and helps in chaining
    int[] data;// array to store actual elements
    int[] top;// store indexes of top elements of stacks

    int n,k;// k represents the total no of stack
    int sn;// sn denotes the stack no. on which we have to perform the operation
    int free;// store current free index

    P2_K_stck1arrr(int k, int n){
        this.n=n;
        this.k=k;
        free=0;

        data=new int[n];

        top=new int[k];
        for(int i=0;i<k;i++){
            top[i]=-1;
        }

        next=new int[n];
        for(int i=0;i<n-1;i++){
            next[i]=i+1;
        }
        next[n-1]=-1;
    }

    void push(int item, int sn){
        if(isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        // Update Free
        int i=free;
        free=next[i];
        // Update next[]
        next[i]=top[sn];
        //Update top
        top[sn]=i;
        //put items
        data[i]=item;
    }

    boolean isEmpty(int sn){
        if(top[sn]==-1){
            return true;
        }
        else{
            return false;
        }
    }

    boolean isFull(){
        if(free==-1){
            return true;
        }
        else{
            return false;
        }
    }

    int pop(int sn){
        if(isEmpty(sn)){
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }
        // i= index of top in the stack number
        int i=top[sn];
        // change top to store next of previous top
        top[sn]=next[i];
        // Attach the prev top the beginning of free list
        next[i]=free;
        free=i;

        return data[i];
    }
    public static void main(String[] args) {
        P2_K_stck1arrr ks = new P2_K_stck1arrr(3, 10);

        ks.push(15, 2);
        ks.push(45, 2);

        // Let us put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);

        // Let us put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);

        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));

    }
}
