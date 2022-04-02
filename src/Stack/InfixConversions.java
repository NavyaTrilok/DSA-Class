package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixConversions {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        printPreStuff(exp);
    }

    public static void printPreStuff(String exp)
    {
        Stack<String> pre = new Stack<>();
        Stack<String> pos = new Stack<>();

        Stack<Character> operators = new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);

            if(ch=='(')
            {
                operators.push(ch);
            }
            else if((ch>='a' && ch<='z') || (ch>='0' && ch<='9'))
            {
                pre.push(ch+"");
                pos.push(ch+"");
            }
            else if(ch=='+'||ch=='-'||ch=='*'||ch=='/')
            {
                while(operators.size()>0 && precedence(ch)<=precedence(operators.peek()))
                {
                    char op=operators.pop();

                    String pre2=pre.pop();
                    String pre1=pre.pop();

                    String pre_res=op+pre1+pre2;
                    pre.push(pre_res);

                    String pos2=pos.pop();
                    String pos1=pos.pop();

                    String pos_res=pos1+pos2+op;
                    pos.push(pos_res);
                }
                operators.push(ch);
            }
            else if(ch==')')
            {
                while(operators.peek()!='(')
                {
                    char op=operators.pop();

                    String pre2=pre.pop();
                    String pre1=pre.pop();

                    String pre_res=op+pre1+pre2;
                    pre.push(pre_res);

                    String pos2=pos.pop();
                    String pos1=pos.pop();

                    String pos_res=pos1+pos2+op;
                    pos.push(pos_res);
                }
            }
        }

        while(operators.size()>0)
        {
            char op=operators.pop();

            String pre2=pre.pop();
            String pre1=pre.pop();

            String pre_res=op+pre1+pre2;
            pre.push(pre_res);

            String pos2=pos.pop();
            String pos1=pos.pop();

            String pos_res=pos1+pos2+op;
            pos.push(pos_res);
        }
        System.out.println(pos.peek());
        System.out.println(pre.peek());

    }

    public static int precedence(char ch)
    {
        if(ch=='*'|| ch=='/')
        {
            return 2;
        }
        else if(ch=='+' || ch=='-')
        {
            return 1;
        }
        return 0;//just to remove ->Add return statement error
    }
}
