package HashMap;
import java.io.*;
import java.util.*;

public class LongestConsecutiveSequenceOfElements {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int[] arr= new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }

        HashSet <Integer> set = new HashSet<>();

        for(int i=0;i<n;i++)
        {
            set.add(arr[i]);
        }

        int sp=-1;
        int max_len=0;
        for(int i=0;i<n;i++)//searching for starting point
        {
            int key=arr[i];

            if(set.contains(key-1)==false){
                int len=1;

                while(set.contains(key+len))
                {
                    len++;
                }
                if(len>max_len)
                {
                    max_len=len;
                    sp=key;
                }
            }
        }
        for(int i=0;i<max_len;i++)
        {
            System.out.println(sp+i);
        }
    }
}
/*
17
12 5 1 2 10 2 13 7 11 8 9 11 8 9 5 6 11

output
5 6 7 8 9 10 11 12 13
*/