package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class FindInGenericTree {
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

    public static boolean find(Node node, int data) {
        // write your code here
        /*LinkedList<Node> que = new LinkedList<>();
        que.addLast(root);
        //int flag==0;
        while(que.size()>0)
        {
            int size=que.size();
            while(size-->0)
            {
                Node t=que.removeFirst();
                if(t.data==data)
                {
                    return true;
                }
                for(Node child : t.children)
                {
                    que.addLast(child);
                }
            }

        }
        return false;*/
        if(node.data==data)
        {
            return true;
        }
        boolean ans=false;
        for(Node child:node.children)
        {
            ans=ans||find(child,data);
        }
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

        int data = Integer.parseInt(br.readLine());

        Node root = construct(arr);
        boolean flag = find(root, data);
        System.out.println(flag);
        // display(root);
    }


}
/*
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
120
true
 */