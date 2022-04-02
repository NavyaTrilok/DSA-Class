package Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class TwoStacksInAnArray {

   /* public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;
        Stack<Integer> st1= new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        public TwoStack(int cap) {
            // write your code here


                }
        }

        int size1() {
            // write your code here
            return st1.size;

        }

        int size2() {
            // write your code here
            return st2.size;
        }

        void push1(int val) {
            // write your code here
            if(arr.length<st1.size+st2.size)
            {
                st1.push(val);
            }
            else {
                System.out.println("stack overflow");

            }

        }

        void push2(int val) {
            // write your code here
            if(arr.length<st1.size+st2.size)
            {
                st1.push(val);
            }
            else {
                System.out.println("stack overflow");

            }
        }

        int pop1() {
            // write your code here
        }

        int pop2() {
            // write your code here
        }

        int top1() {
            // write your code here
        }

        int top2() {
            // write your code here
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TwoStack st = new TwoStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push1(val);
            } else if (str.startsWith("pop1")) {
                int val = st.pop1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top1")) {
                int val = st.top1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size1")) {
                System.out.println(st.size1());
            } else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push2(val);
            } else if (str.startsWith("pop2")) {
                int val = st.pop2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top2")) {
                int val = st.top2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size2")) {
                System.out.println(st.size2());
            }
            str = br.readLine();
        }
    }*/

}
