package Trees;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Tree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[] arr)
    {
        Node root=new Node();
        root.data=arr[0];

        Stack<Node> st=new Stack<>();
        st.push(root);

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==-1)
            {
                st.pop();
            }
            else
            {
                Node n = new Node();
                n.data=arr[i];

                Node top=st.peek();

                top.children.add(n);

                st.push(n);
            }
        }
        return root;
    }

    public static void display(Node root)
    {
        System.out.print(root.data+" -> ");

        for(int i=0;i<root.children.size();i++)
        {
            Node child=root.children.get(i);
            System.out.print(child.data+" ");
        }
        System.out.println(".");

        for(int i=0;i<root.children.size();i++)
        {
            display(root.children.get(i));
        }
    }
    public static void main(String[] args) throws Exception {

        int[] arr={10,50,60,-1,-1,20,70,-1,80,120,-1,-1,90,130,-1,-1,-1,30,-1,40,100,-1,110,-1,-1,-1};
        Node root = construct(arr);
        //int sz = size(root);
        //System.out.println(sz);
        display(root);
    }

}
