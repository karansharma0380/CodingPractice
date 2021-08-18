package RecursionPractice;

/*
1 to n
 */
public class Problem2 {
    static void prob2(int n){
        if (n==0){
            return;
        }
        prob2(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        prob2(4);
    }
}
