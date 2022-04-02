package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingInterval {

    public static void main(String[] args) throws Exception {
        // write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }

        mergeOverlappingIntervals(arr);
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Arrays.sort(arr,(int[] a, int[] b)->{
            return  a[0] -b[0];
        });

        Stack<int[]> intervals = new Stack<>();
        intervals.push(arr[0]);
        int n = arr.length;
        for(int i=1;i<n;i++)
        {
            int st=arr[i][0];
            int et=arr[i][1];

            if(intervals.peek()[1]>=st)
            {
                int[] last_interval=intervals.pop();
                int[] merged=new int[2];

                merged[0]=last_interval[0];
                merged[1]=Math.max(et,last_interval[1]);

                intervals.push(merged);
            }
            else
            {
                intervals.push(arr[i]);
            }

        }
        Stack<int[]> temp = new Stack<>();

        while(intervals.size()>0)
        {
            temp.push(intervals.pop());
        }
        while(temp.size()>0)
        {
            int[] inter=temp.pop();
            System.out.println(inter[0]+" "+inter[1]);
        }

    }
}
/*
6
22 28
1 8
25 27
14 19
27 30
5 12

Output
1 12
14 19
22 30
 */