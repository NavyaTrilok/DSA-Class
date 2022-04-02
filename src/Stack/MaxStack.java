package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaxStack {
    public static class MaxStack1 {
        Stack<Integer> data;
        int max;

        public MaxStack1() {
            data = new Stack<>();

        }

        public void push(int x) {
            if(data.size()==0)
            {
                max=x;
                data.push(x);
            }
            else if(x>max)
            {
                int push_val=x+max;
                max=x;
                data.push(push_val);
            }
            else
            {
                data.push(x);
            }
        }

        public int pop() {
            //return 0;
            if(data.size()==0)
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else if(data.peek()>max)
            {
                int maxN=max;
                int y=data.peek();
                int maxO=maxN+y;
                max=maxO;
                data.pop();
                return maxN;
            }
            else
            {
                return data.pop();
            }
        }

        public int top() {
            int rv=data.peek();
            if(data.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            else if(data.peek()>max)
            {
                return max;
            }
            else
            {
                return data.peek();
            }

        }

        public int peekMax() {
            int rv=data.peek();
            if(data.size()==0)
            {
                System.out.println("Stack underflow");
                return -1;
            }
            else if(data.peek()>max)
            {
                return max;
            }
            else
            {
                return data.peek();
            }
        }

        public int popMax() {
            if(data.size()==0)
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else if(data.peek()>max)
            {
                int maxN=max;
                int y=data.peek();
                int maxO=maxN+y;
                max=maxO;
                data.pop();
                return maxN;
            }
            else
            {
                return data.pop();
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        MaxStack1 maxst = new MaxStack1();

        while (read.ready()) {
            String []inp = read.readLine().split(" ");

            switch (inp[0]) {
                case "pop":
                    System.out.println(maxst.pop());
                    break;
                case "top":
                    System.out.println(maxst.top());
                    break;
                case "popMax":
                    System.out.println(maxst.popMax());
                    break;
                case "peekMax":
                    System.out.println(maxst.peekMax());
                    break;
                case "push":
                    maxst.push(Integer.parseInt(inp[1]));
                    break;
            }

        }

    }

}
