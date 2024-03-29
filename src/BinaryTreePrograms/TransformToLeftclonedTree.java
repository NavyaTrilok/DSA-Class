package BinaryTreePrograms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class TransformToLeftclonedTree {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static Node createLeftCloneTree(Node root){
        // write your code here
        if(root==null)
        {
            return null;
        }

        Node lc=createLeftCloneTree(root.left);
        Node rc=createLeftCloneTree(root.right);

        Node clone=new Node(root.data,null,null);

        clone.left=lc;
        root.left=clone;
        root.right=rc;

        return root;
    }

    public static Node transBackFromLeftClonedTree(Node root)
    {
        if(root==null)
        {
            return null;
        }

        root.left=transBackFromLeftClonedTree(root.left.left);
        root.right=transBackFromLeftClonedTree(root.right);

        return root;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (values[i].equals("n") == false) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);
        root = createLeftCloneTree(root);
        root=transBackFromLeftClonedTree(root);
        display(root);
    }

}
/*
15
50 25 12 n n 37 n n 75 62 n n 87 n n
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
. <- 37 -> .
62 <- 75 -> 87
. <- 62 -> .
. <- 87 -> .

 */