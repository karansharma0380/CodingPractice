package LinkedPractice;
/*
LRU Cache Design:-
Cache is memory close to CPU, has very less access time but small in size compared to
RAM.

Since is cache is really fast we need efficient utilization of this small memory and LRU
is one of the technique useful for this purpose.

LRU stands for Least Recently Used and it uses the concept called temporal locality,
which means that an item accessed now will be likely to accessed in near future.
In LRU we keep the recently accessed item in cache and we remove the least recently
accessed item when space is needed.
 */

class LRUCache{
    int[] arr;
    LRUCache(int n){
        arr= new int[n];
    }
}
public class Prob9 {

    public static void main(String[] args) {
        LRUCache LRc= new LRUCache(4);
        int[] inpu={10,20,10,30,40,50,30,40,60,30};

    }
}
