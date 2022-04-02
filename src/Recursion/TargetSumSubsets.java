package Recursion;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TargetSumSubsets {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        int tar=scn.nextInt();
        printTargetSumSubsets(arr,0,"",0,tar);
    }

    // set is the subset
    // sos is sum of subset
    // tar is target
    public static void printTargetSumSubsets(int[] arr, int idx, String asf, int sos, int tar) {

       if(idx==arr.length)
       {
           if(sos==tar)
           {
               System.out.println(asf+".");
           }
           return;
       }
       if(sos>tar)
       {
           return;
       }

        //include
        printTargetSumSubsets(arr,idx+1,asf+arr[idx]+", ",sos+arr[idx],tar);
        //not include
        printTargetSumSubsets(arr,idx+1,asf,sos,tar);

    }
}

