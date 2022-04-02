package Recursion;

import java.util.Scanner;

public class LastIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1;
        arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int x= scn.nextInt();
        int ans = LastIndex(arr1,0, x);
        System.out.println(ans);

    }

    public  static int LastIndex(int[] arr, int idx,int x)
    {
       // int pi=0;
        if(idx==arr.length)
        {
            return -1;
        }

        int li_aage=LastIndex(arr,idx+1,x);

        if(arr[idx]!=x)
        {
            return li_aage;
        }
        else
        {
            if(li_aage==-1)
            {
                return idx;
            }
            else
            {
                return li_aage;
            }
        }

    }
}
