package Tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

class Node{
    int data;
    Node right;
    Node left;

    Node(){

    }

    Node(int data, Node left, Node right){
        this.data=data;
        this.left=left;
        this.right=right;
    }

    Node(int data){
        this.data=data;
        left=right=null;
    }
}
class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
        this.node=node;
        this.state=state;
    }
}

public class ContructTree1 {


    static Node Contruct1(Integer[] arr){
        Stack<Pair> st=new Stack<Pair>();
        Node root=new Node(arr[0]);
        Pair rtp=new Pair(root,1);
        st.push(rtp);


        int idx=0;//help moving in array
        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                idx++;
                if(arr[idx]!=null){
                    Node ln=new Node(arr[idx]);
                    top.node.left=ln;
                    Pair lp=new Pair(ln,1);
                    st.push(lp);
                }
                else{
                    top.node.left=null;
                }
                top.state++;
            }
            else if (top.state==2){
                idx++;
                if(arr[idx]!=null){
                    Node rn=new Node(arr[idx]);
                    top.node.right=rn;
                    Pair rp=new Pair(rn,1);
                    st.push(rp);
                }
                else{
                    top.node.right=null;
                }
                top.state++;
            }
            else{
                st.pop();
            }
        }
        return root;
    }

    static Node Contruct2(int[] arr,Node root,int i){

        if(i<arr.length){
            Node temp=new Node(arr[i]);
            root=temp;

            root.left=Contruct2(arr,root.left,2*i+1);
            root.right=Contruct2(arr,root.right,2*i+2);
        }

        return root;
    }

    static void disp(Node node){
        if(node==null){
            return;
        }
        String str="";
        str+= (node.left==null)? ". ->":node.left.data+"->";
        str+=node.data+"->";
        str+=(node.right==null)? ".":node.right.data;
        System.out.println(str);

        disp(node.left);
        disp(node.right);
    }

    static void preord(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data+" ");
        preord(node.left);
        preord(node.right);
    }
    static void posord(Node node){
        if(node==null){
            return;
        }
        posord(node.left);
        posord(node.right);
        System.out.print(node.data+" ");
    }
    static void inord(Node node){
        if(node==null){
            return;
        }
        inord(node.left);
        System.out.print(node.data+" ");
        inord(node.right);
    }

    static void LevelOrd(Node node){
        Queue<Node> qt=new ArrayDeque<>();
        qt.add(node);

        while(qt.size()>0){
            int m=qt.size();

            for(int i=0;i<m;i++){
                node=qt.remove();
                System.out.print(node.data+" ");

                if(node.left!=null){
                    qt.add(node.left);
                }
                if(node.right!=null){
                    qt.add(node.right);
                }
            }
            System.out.println();
        }
    }

    static void PREINPOS(Node node){
        String pre="";
        String in="";
        String pos="";
        Stack<Pair> st=new Stack<>();
        Pair rtp=new Pair(node,1);
        st.push(rtp);

        while(st.size()>0){
            Pair top=st.peek();
            if(top.state==1){
                pre+=top.node.data +" ";
                top.state++;

                if(top.node.left!=null){
                    Pair lp=new Pair(top.node.left,1);
                    st.push(lp);
                }
            }
            else if(top.state==2){
                in+=top.node.data +" ";
                top.state++;

                if(top.node.right!=null){
                    Pair rp=new Pair(top.node.right,1);
                    st.push(rp);
                }
            }
            else{
                pos+=top.node.data+" ";
                st.pop();
            }
        }

        System.out.println("Pre: "+pre);
        System.out.println("In: "+in);
        System.out.println("Pos: "+pos);
    }


    static ArrayList<Integer> path;
    static boolean findele(Node node, int x){
        if(node==null){
            return false;
        }
        if(node.data==x){
            path.add(node.data);
            return true;
        }

        boolean lt=findele(node.left,x);
        if(lt){
            path.add(node.data);
            return true;
        }
        boolean rt=findele(node.right,x);
        if(rt){
            path.add(node.data);
            return true;
        }

        return false;
    }

    static void kleveldown(Node node, int k){
        Queue<Node> q=new ArrayDeque<>();
        q.add(node);
        int idx=0;

        while(idx<k){
            int size=q.size();

            for(int i=0;i<size;i++){
                node=q.remove();

                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            idx++;
        }
        int n=q.size();
        for(int i=0;i<n;i++){
            System.out.print(q.remove().data+" ");
        }
    }
    static void kleveldownRec(Node node, int k){
        if(node==null || k<0){
            return;
        }

        if(k==0){
            System.out.print(node.data+" ");
        }
        kleveldownRec(node.left,k-1);
        kleveldownRec(node.right,k-1);
    }

    static int maxele(Node node){
        Queue<Node> qt=new ArrayDeque<>();
        qt.add(node);

        while(qt.size()>0){
            Node max=qt.remove();

        }
    }


    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75,62,null,
                    70,null,null,87,null,null,};
        Node root=Contruct1(arr);

//        int[] ar={1,2,3,4,5,6};
//        path=new ArrayList<Integer>();
//        findele(root,70);
//        System.out.println(path);
//        Node root=new Node();
//        root=Contruct2(ar,root,0);
        disp(root);

//        path=new ArrayList<Integer>();
//        findele(root,6);
//        System.out.println(path);
//        kleveldownRec(root,2);

        System.out.println(maxele(root));
//        kleveldown(root,2);

    }
}
