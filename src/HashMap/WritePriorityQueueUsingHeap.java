package HashMap;
import java.io.*;
import java.util.*;

public class WritePriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        public  void swap(int i,int j)
        {
            int iEle=data.get(i);
            int jEle=data.get(j);

            data.set(i,jEle);
            data.set(j,iEle);
        }

        public  void upHeapify(int idx)
        {
            if(idx==0) return;

            int pi=(idx-1)/2;

            if(data.get(pi)>data.get(idx)){
                swap(pi,idx);
                upHeapify(pi);
            }

        }

        public void add(int val) {
                data.add(val);

                upHeapify(data.size()-1);
        }

        public int remove() {
            if(data.size()==0){
                System.out.println("Underflow");
                return -1;
            }

            int rv = data.get(0);

            swap(0,data.size()-1);
            data.remove(data.size()-1);

            downHeapify(0);
            return rv;
        }

        public  void downHeapify(int idx)
        {
            int lci=2*idx+1;
            int rci=2*idx+2;

            int mini=idx;

            if(lci<data.size() && data.get(lci)<data.get(mini)){
                mini=lci;
            }
            if(rci<data.size() && data.get(rci)<data.get(mini)){
                mini=rci;
            }
            if(mini!=idx) {
                swap(idx,mini);
                downHeapify(mini);
            }

        }

        public int peek() {
            if(data.size()==0){
                System.out.println("Underflow");
                return -1;
            }

            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
/*add 10
add 20
add 30
add 40
peek
10
add 50
peek
10
remove
10
peek
20
remove
20
peek
30
remove
30
peek
40
remove
40
peek
50
quit
*/