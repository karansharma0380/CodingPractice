package StackPractice;

import java.util.Stack;

public class InfixtoPrefix {
    static int getPriority(char c){
        if(c=='+'||c=='-'){
            return 1;
        }
        else if(c=='*'||c=='/'){
            return 2;
        }
        else{
            return 0;
        }
    }
    static void infitoPre(String str){
        Stack<Character> stck = new Stack<Character>();
        String prefix="";
        char[] ch=str.toCharArray();
        int n=ch.length-1;
        for(int i=n;i>=0;i--){
            if(ch[i]!='+'&&ch[i]!='-'&&ch[i]!='*'&&ch[i]!='/'&&ch[i]!='('&&ch[i]!=')'&&ch[i]!='^'){
                prefix=prefix+ch[i];
            }else if(ch[i]==')'){
                stck.push(ch[i]);
            }else if(ch[i]=='('){
                while(stck.isEmpty()==false){
                    char t=stck.pop();
                    if(t!=')'){
                        prefix=prefix+t;
                    }
                    else{
                        break;
                    }
                }
            }else if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/'||ch[i]=='^'){
                if(stck.isEmpty()==true){
                    stck.push(ch[i]);
                }
                else{
                    while(stck.isEmpty()==false){
                        char t=stck.pop();
                        if(t==')'){
                            stck.push(t);
                            break;
                        }else if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/'||ch[i]=='^'){
                            if(getPriority(t)<getPriority(ch[i])){
                                stck.push(ch[i]);
                                break;
                            }
                            else{
                                prefix=prefix+t;
                            }
                        }
                    }
                    stck.push(ch[i]);
                }
            }
        }
        while (stck.isEmpty() == false) {
            prefix=prefix+stck.pop();
        }
        char[] p1=PrefixEval.rev1(prefix);
        System.out.println(p1);
    }
    public static void main(String[] args) {
        String t="x+y*(z-w)";
        infitoPre(t);
    }
}
