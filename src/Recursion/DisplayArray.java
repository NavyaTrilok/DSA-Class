package Recursion;

import java.util.Scanner;

public class DisplayArray {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1;
        arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }
        displayArr(arr1,0);
    }

    public static void displayArr(int[] arr, int idx){

        if(idx==arr.length)
        {
            return;
        }

        displayArr(arr,idx+1);
        System.out.println(arr[idx]);

    }

}
