package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathJumps {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        System.out.println(getMazePaths(0,0,n-1,m-1));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        if(sr==dr && sc==dc)
        {
            ArrayList<String> ba = new ArrayList<>();
            ba.add("");
            return ba;
        }

        //hor jumps
        ArrayList<String> ans = new ArrayList<>();

        for(int h_jumps=1;sc+h_jumps<=dc;h_jumps++)
        {
            ArrayList<String> sans = getMazePaths(sr,sc+h_jumps,dr,dc);

            for (String s : sans) {
                ans.add("h" +h_jumps+ s);
            }
        }


        //ver jumps
        for(int v_jumps=1;sr+v_jumps<=dr;v_jumps++)
        {
            ArrayList<String> sans = getMazePaths(sr+v_jumps,sc,dr,dc);

            for (String s : sans) {
                ans.add("h" +v_jumps+ s);
            }


        }

        //dia jumps
        for(int d_jumps=1;sc+d_jumps<=dc && sr+d_jumps<=dr;d_jumps++)
        {
            ArrayList<String> sans = getMazePaths(sr+d_jumps,sc+d_jumps,dr,dc);

            for (String s : sans) {
                ans.add("h" +d_jumps+ s);
            }

        }
        return ans;
    }

}
