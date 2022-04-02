package LinkedLists;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class LinkedListToStack {
    public static class LLToStackAdapter {
        LinkedList<Integer> list;

        public LLToStackAdapter() {
            list = new LinkedList<>();
        }


        int size() {
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }


        int pop() {
            return list.removeFirst();

        }


        int top() {
            // write your code here
            return list.getFirst();

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToStackAdapter st = new LLToStackAdapter();

        String str = br.readLine();
        while(str.equals("quit") == false){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            }
            str = br.readLine();
        }
    }
}
/*
push 10
push 20
push 5
push 8
push 2
push 4
push 11
top
11
size
7
pop
11
top
4
size
6
pop
4
top
2
size
5
pop
2
top
8
size
4
pop
8
top
5
size
3
pop
5
top
20
size
2
pop
20
top
10
size
1
pop
10
quit

 */