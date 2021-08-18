package DequePractice;

import java.util.Deque;
import java.util.LinkedList;

public class DeqJav {
    public static void main(String[] args) {
        Deque<Integer> dq=new LinkedList<Integer>();
        dq.offerFirst(10);
        dq.offerFirst(20);
        dq.offerFirst(30);
        dq.offerLast(40);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

    }
}
