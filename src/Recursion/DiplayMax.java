package Recursion;

import java.util.Scanner;

public class DiplayMax {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1;
        arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        int ans = maxofArray(arr1,0);
        System.out.println(ans);

    }

    public static int maxofArray(int[] arr, int idx){
        if(idx==arr.length)
        {
            return Integer.MIN_VALUE;
        }
        int max_after_idxp1 = maxofArray(arr,idx+1);
        if(arr[idx]>max_after_idxp1)
        {
            return arr[idx];
        }
        else
        {
            return max_after_idxp1;
        }

    }
}
