package StackPractice;
import java.util.Stack;

public class BalancedParen1 {
    static void Balan(String str) {
        Stack<Character> stck= new Stack<Character>();
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='('||str.charAt(i)=='['||str.charAt(i)=='{'){
                stck.push(str.charAt(i));
            }
            else if((stck.isEmpty()==false) &&
                    (str.charAt(i)==')' && stck.peek()=='(')||
                    (str.charAt(i)==']' && stck.peek()=='[')||
                    (str.charAt(i)=='}' && stck.peek()=='{')){
                stck.pop();
            }else{
                stck.push(str.charAt(i));
            }
        }
        if(stck.isEmpty()==true){
            System.out.println("Balanced");
        }
        else{
            System.out.println("Un-balanced");
        }
    }


    public static void main(String[] args) {
        String tr;
        tr="{}";
        Balan(tr);

    }
}
