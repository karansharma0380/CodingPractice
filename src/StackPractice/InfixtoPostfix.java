package StackPractice;

import java.util.Stack;

public class InfixtoPostfix {
    static int getPriority(char c){
        if(c=='^'){
            return 3;
        }
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
    static void Infipost(String str) {
        Stack<Character> stck = new Stack<Character>();
        String postfix = "";
        char[] ch = str.toCharArray();
        for(char c:ch){
            if(c!='+' && c!='-' && c!='*' && c!='/' && c!='('&& c!=')'&& c!='^'){
                postfix=postfix+c;
            } else if(c=='('){
                stck.push(c);
            }else if(c==')'){
                while(stck.isEmpty()==false){
                    char t=stck.pop();
                    if(t!='('){
                        postfix=postfix+t;
                    }
                    else{
                        break;
                    }
                }
            }else if(c=='+'||c=='-'||c=='*'||c=='/'|| c=='^'){
                if(stck.isEmpty()==true) {
                    stck.push(c);
                }else{
                    while(stck.isEmpty()==false){
                        char t=stck.pop();
                        if(t=='('){
                            stck.push(t);
                            break;
                        }else if(t=='+'||t=='-'||t=='*'||t=='/'|| t!='^'){
                            if(getPriority(t)<getPriority(c)){
                                stck.push(t);
                                break;
                            }else{
                                postfix=postfix+t;
                            }
                        }
                    }
                    stck.push(c);
                }
            }
        }
        while(stck.isEmpty()==false){
            char t=stck.pop();
            postfix=postfix+t;
        }
        System.out.println(postfix);
    }


    public static void main(String[] args) {
        String t="3*(4+5)-6/(1+2)";
        String ts="(a-(b^c))+(d)";
        Infipost(ts);
    }
}
