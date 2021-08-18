package StackPractice;

import java.util.Stack;

public class PostfixEval {
    static int PostEva(String str){
        Stack<Integer> stck=new Stack<Integer>();
        int x=0,y=0;
        char[] ch=str.toCharArray();
        for(char c:ch){
            if (c >= '0' && c <= '9') {
                stck.push(Integer.parseInt(String.valueOf(c)));
            }else{
                y= stck.pop();
                x=stck.pop();
                switch (c){
                    case '+':
                        stck.push(x+y);
                        break;
                    case '-':
                        stck.push(x-y);
                        break;
                    case '*':
                        stck.push(x*y);
                        break;
                    case '/':
                        stck.push(x/y);
                        break;
                }
            }
        }
        return stck.pop();
    }
    public static void main(String[] args) {
        String t="345+*612+/-";
        System.out.println(PostEva(t));
    }
}
