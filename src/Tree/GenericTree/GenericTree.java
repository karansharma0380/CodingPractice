package Tree.GenericTree;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class GenericTree {
    public static class GNode {
        int data;
        ArrayList<GNode> children = new ArrayList<>();

        GNode(){};

        GNode(int data){
            this.data=data;
        }
    }

    public static GNode contruc(int[] arr){
        GNode root =new GNode();
        Stack<GNode> st=new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==-1){
                st.pop();
            }
            else{
                GNode t=new GNode();
                t.data=arr[i];

                if(st.size()>0){
                    st.peek().children.add(t);
                }
                else{
                    root=t;
                }
                st.push(t);
            }
        }

        return root;
    }

    public static void display(GNode root){
        String str=root.data+"->";
        for(GNode child: root.children){
            str+=child.data+",";
        }
        str+=".";
        System.out.println(str);

        for(GNode child: root.children){
            display(child);
        }

    }

    public static int sizee(GNode root){
        int m=0;

        for(GNode child: root.children){
            int ch=sizee(child);
             m=m+ch;

        }
        m=m+1;

        return m;
    }

    public static int maxii(GNode node){
        int mxi=Integer.MIN_VALUE;

         for(GNode child:node.children){
             int m=maxii(child);
             mxi=Math.max(mxi,m);
         }

         mxi=Math.max(node.data,mxi);

        return mxi;
    }

    public static int height(GNode node){
        int h=0;

        for(GNode child: node.children){
            int n=height(child);
            h=Math.max(h,n);
        }

        h=h+1;

        return h;
    }

    static void levelOrd(GNode node){
        Queue<GNode> qt=new ArrayDeque<>();
        qt.add(node);

        while(qt.size()>0){
            node=qt.remove();
            System.out.println(node.data);

            for(GNode child:node.children){
                qt.add(child);
            }
        }

    }

    static void LevelOrdNewLine(GNode node){
        Queue<GNode> pq=new ArrayDeque<>();
        pq.add(node);

        Queue<GNode> cq=new ArrayDeque<>();
        while(pq.size()>0){
            node=pq.remove();
            System.out.print(node.data+" ");

            for(GNode child:node.children){
                cq.add(child);
            }

            if(pq.size()==0){
                pq=cq;
                cq=new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    static void LONLZigZag(GNode node){
        Stack<GNode> ps=new Stack<>();
        ps.push(node);
        int level=1;

        Stack<GNode> cs=new Stack<>();
        while(ps.size()>0){
            node=ps.pop();
            System.out.print(node.data+" ");

            if(level%2!=0){
                for(GNode child:node.children){
                    cs.push(child);
                }
            }
            else{
                for(int i=node.children.size()-1;i>=0;i--){
                    GNode child=node.children.get(i);
                    cs.push(child);
                }
            }

            if(ps.size()==0){
                level++;
                ps=cs;
                cs=new Stack<>();
                System.out.println();
            }
        }

        }

    static void LevelOrdSQ(GNode node){
        Queue<GNode> q=new ArrayDeque<>();
        q.add(node);
        q.add(new GNode(-1));

        while(q.size()>0){
            node=q.remove();
            if(node.data!=-1){
                System.out.print(node.data+" ");

                for(GNode child:node.children){
                    q.add(child);
                }
            }
            else{
                if(q.size()>0){
                    q.add(node);
                    System.out.println();
                }

            }
        }

    }

    static void LevelOrdSQ2(GNode node){

    }


    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80,
                110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        GNode root=contruc(arr);
        LevelOrdSQ(root);

    }
}
