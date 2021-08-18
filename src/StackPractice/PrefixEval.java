package StackPractice;
import java.util.Stack;

public class PrefixEval {
    static char[] rev1(String st){
        int n=st.length();
        char[] ch=st.toCharArray();
        int i=0,j=n-1;
        while(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
        return ch;
    }

    static void PrefEval(String str){
        Stack<Integer> stck=new Stack<Integer>();
        char[] ch=rev1(str);
        int x=0,y=0;
        for(char c:ch){
            if(c!='+'&&c!='-'&&c!='*'&&c!='/'){
                stck.push(Integer.parseInt(String.valueOf(c)));
            }else {
                y=stck.pop();
                x=stck.pop();
                switch (c){
                    case '+':
                        stck.push(x+y);
                        break;
                    case '*':
                        stck.push(x*y);
                        break;
                    case'/':
                        stck.push(x/y);
                        break;
                    case '-':
                        stck.push(x-y);
                }
            }
        }
        System.out.println(stck.pop());
    }

    public static void main(String[] args) {
        String a="+*523";
        System.out.println(rev1(a));
        PrefEval(a);

    }
}
