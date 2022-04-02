package Recursion;

import java.util.Scanner;

public class Revision {

    public static  void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        anyBaseToDecimal(n,b);
    }

    public static void anyBaseToDecimal(int n, int b)
    {
        int temp=n;
        int count=0;
        while(temp!=0)
        {
            temp=temp/10;
            count++;
        }
        int ans=0;
        while(n!=0)
        {
            int div=(int)Math.pow(10,count-1);
            int digit=n/div;
            ans=ans+digit*(int)Math.pow(b,count-1);
            n=n%div;
            count--;
            System.out.println("here");
        }
        System.out.println(ans);
    }

}
