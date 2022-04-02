package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SlidingWindowMaximum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        int[] ans = slidingWindow(a,k);

        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
        // code
    }

    public static int[] slidingWindow(int[] arr, int k)
    {
        int n=arr.length;
        int[] ngr=nextGreaterRight(arr);
        int[] ans = new int[n-k+1];

        int j=0;
        for(int i=0;i<=arr.length-k;i++)
        {
            if(j<i)
            {
                j=i;
            }
            while(ngr[j]<i+k)
            {
                j=ngr[j];
            }

            //System.out.println(arr);
            ans[i]=arr[j];
        }
        return ans;
    }

    public static int[] nextGreaterRight(int[] arr)
    {
        int n=arr.length;
        int[] ngr=new int[n];
        Stack<Integer> st = new Stack<>();
        ngr[n-1]=n;
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            while(st.size()!=0 && arr[i]>=arr[st.peek()])
            {
                st.pop();
            }
            if(st.size()==0)
            {
                ngr[i]=n;
            }
            else
            {
                ngr[i]=st.peek();
            }
            st.push(i);
        }
        return ngr;
    }

}
