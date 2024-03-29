package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class LargestAreaHistogram {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }


        int[] nsl = nextSmallerleft(a);
        int[] nsr = nextSmallerRight(a);

            //int area =0;
        int maxArea =0;
            for(int i=0;i<n;i++)
            {
                int height=a[i];
                int width=nsr[i]-nsl[i]-1;

                int area=height*width;
                maxArea=Math.max(area,maxArea);

            }

            System.out.println(maxArea);
        }





    public static int[] nextSmallerleft(int[] arr)
    {
        int n=arr.length;
        Stack<Integer> st = new Stack<>();

        int[] nsl = new int[n];
        nsl[0]=-1;

        //st.push(0);

        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }

            if(st.size()==0)
            {
                nsl[i]=-1;
            }
            else
            {
                nsl[i]=st.peek();
            }

            st.push(i);
        }

        return nsl;

    }


    public static int[] nextSmallerRight(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        int[] nsr = new int[n];
        nsr[0] = n;
        st.push(n - 1);


        for (int i = n - 2; i >= 0; i--) {
            while (st.size() != 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);

        }
        return nsr;
    }

}
