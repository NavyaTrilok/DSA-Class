package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args)throws Exception  {
        Scanner sc = new Scanner(System.in);
        String exp= sc.nextLine();
        System.out.println(isBalanced(exp));
    }

    public static boolean isBalanced(String exp) {

        Stack<Character> st = new Stack<>();
        char popped='a';
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);

            if(ch == '('||ch=='['||ch=='{')
            {
              st.push(ch);
            }
            else if(ch == ')'||ch==']'||ch=='}')
            {
                if(st.size()==0)
                    return false;

                if(ch==']' && st.peek()!='[')
                    return false;
                if(ch==')' && st.peek()!='(')
                    return false;
                if(ch=='}' && st.peek()!='{')
                    return false;

                st.pop();
            }
        }
        if(st.size()!=0)
            return false;
        else
            return true;

    }

}
