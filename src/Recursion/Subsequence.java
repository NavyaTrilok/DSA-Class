package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Subsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn=new Scanner(System.in);

        String str = scn.nextLine();
        ArrayList<String> ans = gss(str);

        System.out.println(ans);
    }

    public static ArrayList<String> gss(String str) {
        if(str.length()==0) {

            ArrayList<String> al = new ArrayList<>();
            al.add("");
            return al;
        }

        ArrayList<String> sans = gss(str.substring(1));

        char first_char=str.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for(int i=0;i<sans.size();i++)
        {
            String s=sans.get(i);
            ans.add(s);
        }

//including first char
        for(int i=0;i<sans.size();i++)
        {
            String s =sans.get(i);
            s=first_char+s;
            ans.add(s);
        }
        return ans;
    }
}



