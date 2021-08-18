package Tree.BinaryTree;

import java.util.ArrayList;

public class KlevelFar {
    static ArrayList<Node> path;
    static boolean findele(Node node, int x){
        if(node==null){
            return false;
        }
        if(node.data==x){
            path.add(node);
            return true;
        }

        boolean lt=findele(node.left,x);
        if(lt){
            path.add(node);
            return true;
        }
        boolean rt=findele(node.right,x);
        if(rt){
            path.add(node);
            return true;
        }

        return false;
    }
    static void kleveldownRec(Node node, int k, Node blocker){
        if(node==null || k<0 || node==blocker){
            return;
        }

        if(k==0){
            System.out.print(node.data+" ");
        }
        kleveldownRec(node.left,k-1,blocker);
        kleveldownRec(node.right,k-1,blocker);
    }

    static void KlevelFar(Node node,int data, int k){
        path=new ArrayList<>(); //[8,4,2,1]
        findele(node,data);
        for(int i=0;i<path.size();i++) {
            kleveldownRec(path.get(i), k - i, (i == 0) ? null : path.get(i - 1));
        }
    }

    static int leafn(Node node){
        if(node==null){
            return 0;
        }
        if(node.left==null && node.right==null){
            return 1;
        }

        int lln=leafn(node.left);
        int rln=leafn(node.right);

        return lln+rln;
    }

    public static void main(String[] args) {
        int[] ar={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        Node root=new Node();
        root=ContructTree1.Contruct2(ar,root,0);
        ContructTree1.disp(root);
        System.out.println();
//        KlevelFar(root,8,3);
        System.out.println(leafn(root));
    }
}
