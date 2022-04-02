package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumStack {
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }


        int size() {

            return allData.size();
        }

        void push(int val) {

            if(allData.size()==0)
            {
                allData.push(val);
                minData.push(val);
            }
            else if(val<=minData.peek())
            {
                allData.push(val);
                minData.push(val);
            }
            else
            {
                allData.push(val);
            }

        }

        int pop() {

            if(allData.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }

            int rv=allData.pop();

            if(rv==minData.peek())
            {
                minData.pop();
            }

            return rv;
        }

        int top() {
            // write your code here
            if(allData.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            else
            {
                return allData.peek();
            }

        }

        int min(){
            if(minData.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }

            return minData.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

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
            } else if(str.startsWith("min")){
                int val = st.min();
                if(val != -1){
                    System.out.println(val);
                }
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
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
top
min
pop
quit

Output
11
2
11
4
2
4
2
2
2
8
5
8
5
5
5
20
10
20
10
10
10

 */