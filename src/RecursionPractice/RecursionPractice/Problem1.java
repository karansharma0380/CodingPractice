package RecursionPractice;
/*
Print n to 1
 */
public class Problem1 {
    static int prob1(int n){
        if(n==0){
            return 0;
        }
        System.out.print(n + " ");
        return prob1(n-1);
    }
    public static void main(String[] args) {
        prob1(4);
    }
}
