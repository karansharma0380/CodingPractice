package com.company;

class Minheap{
    int []arr;
    int size;
    int cap;
    Minheap(int c){
        arr = new int[c];
        size=0;
        cap = c;
    }
    int left(int i){
        return 2*i+1;
    }
    int right(int i){
        return 2*i+2;
    }
    int parent(int i){
        return (i-1)/2;
    }

    void insert(int x){
        if(size == cap){
            return;
        }
        size++;
        arr[size-1] = x;
        int i = size-1;
        while(i!=0 && (arr[parent(i)] <= arr[i])){
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i=parent(i);
        }
    }

    void minHeapify(int i){
        int lt = left(i);
        int rt = right(i);
        int small = i;
        if(lt<size && arr[lt]<arr[i]){
            small = lt;
        }
        if(rt<size && arr[rt]<arr[small]){
            small = rt;
        }
        if(small!=i){

        }
        int temp = arr[i];
        arr[i] = arr[small];
        arr[small] = temp;
        minHeapify(small);
    }

    void deckey(int i, int x){
        arr[i] = x;
        while(i!=0 && arr[i]<arr[parent(i)]){
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)]=temp;
            i=parent(i);
        }
    }
    void buildHeapify(){

    }
}

public class HeapPractice {

    public static void main(String[] args) {

    }
}
