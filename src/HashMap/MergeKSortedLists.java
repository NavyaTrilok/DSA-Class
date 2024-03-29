package HashMap;
import java.io.*;
import java.util.*;

public class MergeKSortedLists {

    public static class Pair implements Comparable<Pair>{
        int li;
        int idx;
        int data;

        public Pair(int li,int idx,int data) {
            this.li=li;
            this.idx=idx;
            this.data=data;
        }

        public int compareTo(Pair other) {
            return this.data - other.data;//increasing -> min pq
            //return this.data - other.data;//decreasing -> max pq
        }
    }
    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq=new PriorityQueue<>();

        for(int i=0;i< lists.size();i++) {
            pq.add(new Pair(i,0,lists.get(i).get(0)));
        }

        while(pq.size()>0) {
            Pair t=pq.remove();

            rv.add(t.data);

            int li=t.li;
            int idx=t.idx;

            if(idx+1<lists.get(li).size()) {
                pq.add(new Pair(li,idx+1,lists.get(li).get(idx+1)));
            }
        }
        return rv;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for(int j = 0; j < n; j++){
                list.add(Integer.parseInt(elements[j]));
            }
            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
/*4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 */
