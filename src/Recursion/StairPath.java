package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class StairPath {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<String> paths = getStairPaths(0,n);

        System.out.println(paths);

    }

    public static ArrayList<String> getStairPaths(int idx, int n) {

        if(idx==n)
        {
            ArrayList<String> ba = new ArrayList();
            ba.add("");
            return ba;

        }
        if(idx>n)
        {
            ArrayList<String> ba = new ArrayList<>();
            return ba;
        }

        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> sans = getStairPaths(idx+1,n);

        for(int i=0;i<sans.size();i++)
        {
            String s = sans.get(i);
            String path = "1"+s;
            ans.add(path);

        }

        ArrayList<String> sans2 = getStairPaths(idx+2,n);

        for(int i=0;i<sans2.size();i++)
        {
            String s = sans2.get(i);
            String path = "2"+s;
            ans.add(path);

        }

        ArrayList<String> sans3 = getStairPaths(idx+3,n);

        for(int i=0;i<sans3.size();i++)
        {
            String s = sans3.get(i);
            String path = "3"+s;
            ans.add(path);

        }

        return ans;
    }
}
