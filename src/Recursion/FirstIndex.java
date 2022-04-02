package Recursion;

import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1;
        arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int x= scn.nextInt();
        int ans = FirstIndex(arr1,0, x);
        System.out.println(ans);

    }

    public  static int FirstIndex(int[] arr, int idx,int x)
    {
        if(idx==arr.length)
        {
            return -1;
        }
        int fi_aage=FirstIndex(arr,idx+1,x);
        if(arr[idx]==x)
        {
            return idx;
        }
        return fi_aage;
    }
}
