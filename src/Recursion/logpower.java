package Recursion;

import java.util.Scanner;

public class logpower {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

        int x = scn.nextInt();
        int n = scn.nextInt();
        int ans = powerfunction(x,n);
        System.out.println(ans);

    }

    public static int powerfunction(int x, int n)
    {
        if(n==0)
            return 1;
        int xpownb2=powerfunction(x,n/2);
        int ans=xpownb2*xpownb2;
        if(n%2!=0)
        {
            ans=ans*x;
        }
        return ans;
    }
}
