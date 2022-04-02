package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }
    public static int height(Node root)
    {
        int h=-1;

        for(Node child:root.children)
        {
            h=Math.max(h,height(child));
        }
        return h+1;
    }


    public static int diameter(Node root)
    {
        int mh=-1;
        int smh=-1;
        int dia=-1;

        for(Node child:root.children)
        {
            int h=height(child);

            if(h>=mh)
            {
                smh=mh;
                mh=h;
            }else if(h>smh)
            {
                smh=h;
            }
        }
        dia=mh+smh+2;

        for(Node child:root.children)
        {
            dia=Math.max(dia,diameter(child));
        }
        return dia;
    }

    static int global_dia;
    public static int diameter2(Node root)
    {
        int mh=-1;
        int smh=-1;

        for(Node child: root.children)
        {
            int height=diameter2(child);

            if (height>mh)
            {
                smh=mh;
                mh=height;
            }else if(height>smh)
            {
                smh=height;
            }
        }

        int dia=mh+smh+2;
        global_dia=Math.max(global_dia,dia);

        return mh+1;
    }

    public static int[] diameter3(Node root)
    {
        int mh=-1;
        int smh=-1;
        int dia=-1;
        for(Node child:root.children)
        {
            int[] height_dia=diameter3(child);
            int height=height_dia[0];
            dia=Math.max(dia,height_dia[1]);

            if(height>mh)
            {
                smh=mh;
                mh=height;
            }
            else if(height>smh)
            {
                smh=height;
            }
        }

        dia=Math.max(dia,mh+smh+2);

        int[] ans=new int[2];
        ans[0]=mh+1;
        ans[1]=dia;

        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        // write your code here
        int dia=diameter(root);
       //System.out.println(dia);
        global_dia=0;
        //diameter2(root);
        //System.out.println(global_dia);
        int[] ans = diameter3(root);
        System.out.println(ans[1]);
    }

}
/*
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
4
 */