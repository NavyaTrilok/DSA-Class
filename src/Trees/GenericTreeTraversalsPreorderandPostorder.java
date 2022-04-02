package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeTraversalsPreorderandPostorder {
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

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node){

        System.out.println("Node Pre" + node.data);

        for(int i=0;i<node.children.size();i++)
        {
            Node child=node.children.get(i);
            System.out.println("Edge Pre"+node.data+"--"+child.data);

            traversals(child);

            System.out.println("Edge Post"+node.data+"--"+child.data);


        }
        System.out.println("Node Post"+node.data);
    }

    public static void main(String[] args) throws Exception {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }*/

        int[] arr={10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};

        Node root = construct(arr);
        traversals(root);
    }

}
/*
Node Pre10
Edge Pre10--20
Node Pre20
Node Post20
Edge Post10--20
Edge Pre10--30
Node Pre30
Edge Pre30--50
Node Pre50
Node Post50
Edge Post30--50
Edge Pre30--60
Node Pre60
Node Post60
Edge Post30--60
Node Post30
Edge Post10--30
Edge Pre10--40
Node Pre40
Node Post40
Edge Post10--40
Node Post10
 */