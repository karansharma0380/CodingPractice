package Tree.BinaryTree;
import Tree.Node;

import java.util.Stack;

public class Traversal {
    static void height1(int[] arr){
        int n=arr.length;
        Node root;

        Stack<Node> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i]==-1){
                st.pop();
            }
            else{
                Node t = null;
                t.key=arr[i];
                if(st.size()==0){
                    st.push(t);
                }
                else{

                }
            }
        }

    }
    public static void main(String[] args) {
        Node root=new Node(30);
        root.left=new Node(40);
        root.right=new Node(50);
    }

}
