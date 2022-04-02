package HashMap;

import java.io.*;
import java.util.*;

public class GetCommonElements2 {
    public static void main(String[] args) throws Exception {
        //Write your code here
        Scanner scn = new Scanner(System.in);

        int n1=scn.nextInt();

        int[] arr1=new int[n1];

        for(int i=0;i<n1;i++)
        {
            arr1[i]=scn.nextInt();
        }

        int n2=scn.nextInt();

        int[] arr2=new int[n2];

        for(int i=0;i<n2;i++)
        {
            arr2[i]=scn.nextInt();
        }

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n1;i++)
        {
            int key = arr1[i];

            if(map.containsKey(key)){
                int old_fre=map.get(key);
                map.put(key,old_fre+1);
            }
            else
            {
                map.put(key,1);
            }
        }
        for(int i=0;i<n2;i++)
        {
            int key=arr2[i];

            if(map.containsKey(key)){
                int fre=map.get(key);

                if(fre>0){
                    System.out.println(key);
                }

                map.put(key,fre-1);
            }
        }
    }
}
/*
7 1 1 2 2 2 3 5 7 1 1 1 2 2 4 5
output
1 1 2 2 5
 */