package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MinimumStackConstantSpace {

    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if(data.size()==0)
            {
                min=val;
                data.push(val);
            }
            else if(val<min)
            {
                int push_val=val+(val-min);
                min=val;
                data.push(push_val);
            }
            else
            {
                data.push(val);
            }

        }

        int pop() {

            if(data.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            else if(data.peek()<min)
            {
                int minN=min;
                int x = data.peek();
                int minO=2*minN-x;
                min=minO;
                data.pop();
                return minN;

            }
            else
            {
                return data.pop();
            }

        }

        int top() {
            // write your code here
            if(data.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            else if(data.peek()<min)
            {
                return min;
            }
            else
            {
                return data.peek();
            }
        }

        int min() {
            if(data.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
