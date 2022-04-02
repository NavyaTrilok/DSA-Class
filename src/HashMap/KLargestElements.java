package HashMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {

    public static void main (String[] args) throws IOException
    {
        Scanner scn= new Scanner(System.in);
        int n = scn.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        solve(n,num,k);
    }
    // -----------------------------------------------------
    // This is a functional problem. Only this function has to be written.
    // This function takes as input an array,n length of array and k.
    // It should print required output.
    public static void solve(int n,int[] arr,int k){
        //Write your code here
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        for(int i=0;i<n;i++)
        {
            pq.add(arr[i]);

            if(pq.size()>k)
            {
                pq.remove();
            }
        }

        ArrayList<Integer> al = new ArrayList<>();//putting elements in arraylist to traverse from reverse order
        //because priorityqueue always gives smallest

        while(pq.size()>0)
        {
            al.add(pq.remove());
        }
        for(int i=k-1;i>=0;i--)
        {
            System.out.println(al.get(i)+" ");
        }
    }

}
/*
8
44 -5 -2 41 12 19 21 -6
2
44
41

 */