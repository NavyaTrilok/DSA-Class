package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CelebrityProblem {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }

        findCelebrity(arr);

    }

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        int n= arr.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++)
        {
            st.push(i);
           // i++;
        }

        while(st.size()>1)
        {
            int a=st.pop();
            int b=st.pop();
            if(arr[a][b]==1)//a knows b
            {
                st.push(b);
            }
            else
            {
                st.push(a);
            }
        }

        int poss=st.peek();

        for(int i=0;i<n;i++)
        {
            if(i==poss)
            {
                continue;
            }
            if(arr[i][poss]!=1)
            {
                System.out.println("none");
                return;
            }
            if(arr[poss][i]!=0)
            {
                System.out.println("none");
                return;
            }
        }

        System.out.println(poss);
    }
}
/*
4
0000
1011
1101
1110
Output
0
 */