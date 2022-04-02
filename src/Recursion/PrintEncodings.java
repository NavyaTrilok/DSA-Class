package Recursion;

import java.util.Scanner;

public class PrintEncodings {

    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        printEncodings(str,"");

    }

    public static void printEncodings(String str, String asf) {

        if(str.length()==0)
        {
            System.out.println(asf);
            return;
        }

        char ch = str.charAt(0);

        if(ch=='0')
        {
            return;

        }

        //take fist char
        String to_add=(char)('a'+Integer.parseInt(ch+"")-1)+"";

        String ros = str.substring(1);
        printEncodings(ros,asf+to_add);

        if(str.length()>=2)
        {
            String first_two=str.substring(0,2);

            int idx=Integer.parseInt(first_two);

            if(idx>=1 && idx<=26)
            {
                to_add=(char)('a'+idx-1)+"";
                ros=str.substring(2);
                printEncodings(ros,asf+to_add);
            }
        }



    }
}
