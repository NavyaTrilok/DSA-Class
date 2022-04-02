package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixEvaluation {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        // code
        System.out.println(evaluate(exp));
    }

    public static int evaluate(String exp)
    {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);

            if(ch=='(')
            {
                operators.push(ch);
            }
            else if(ch>='0' && ch<='9')
            {
                operands.push(ch-'0');
            }
            else if (ch=='+' || ch=='-' || ch=='*' || ch=='/')
            {
                while (operators.size()>0 && precedence(ch)<=precedence(operators.peek()))
                {
                    char op=operators.pop();
                    int opd2=operands.pop();
                    int opd1=operands.pop();

                    int res=cal(opd1,opd2,op);

                    operands.push(res);
                }
                operators.push(ch);
            }
            else if(ch==')')
            {
                while(operators.peek()!='(')
                {
                    char op=operators.pop();
                    int opd2=operands.pop();
                    int opd1=operands.pop();

                    int res=cal(opd1,opd2,op);

                    operands.push(res);
                }
                operators.pop();
            }
        }
        while(operators.size()>0)
        {
            char op=operators.pop();
            int opd2=operands.pop();
            int opd1=operands.pop();

            int res=cal(opd1,opd2,op);

            operands.push(res);
        }

        return operands.peek();
    }

    public static int cal(int a, int b, char op)
    {
        if(op=='/')
            return  a/b;
        else if(op=='*')
            return a*b;
        else if(op=='-')
            return a-b;
        else
            return a+b;

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
        return 3;//just to remove ->Add return statement error
    }
}
