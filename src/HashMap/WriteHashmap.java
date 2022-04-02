package HashMap;

import java.io.*;
import java.util.*;


public class WriteHashmap {
    public static class HashMap<K, V> {
        private class HMNode {
            K key;
            V value;

            HMNode(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<HMNode>[] buckets; // N = buckets.length

        public HashMap() {
            initbuckets(4);
            size = 0;
        }

        private void initbuckets(int N) {
            buckets = new LinkedList[N];
            for (int bi = 0; bi < buckets.length; bi++) {
                buckets[bi] = new LinkedList<>();
            }
        }

        public int getKeyIndex(K myKey, int bi)
        {
            int idx=0;

            for(HMNode n:buckets[bi])
            {
                if(n.key.equals(myKey)) {
                    return idx;
                }
                idx++;
            }
            return -1;
        }

        public int hashFunction(K key){
            int hc=key.hashCode();
            int bi=Math.abs(hc)%buckets.length;

            if(bi<0)
            {
                bi=bi+ buckets.length;
            }

            return bi;
        }

        public void put(K key, V value) throws Exception {
            int bi=hashFunction(key);

            int idx=getKeyIndex(key,bi);

            if(idx==-1){
                HMNode n = new HMNode(key,value);
                buckets[bi].addLast(n);
                size++;
            }
            else
            {
                HMNode n=buckets[bi].get(idx);
                n.value=value;
            }

            double lambda= size*1.0/ buckets.length;

            if(lambda > 2.0)
            {
                rehash();
            }
        }

        public void rehash() throws Exception
        {
            LinkedList<HMNode>[] oba=buckets;

            initbuckets(oba.length*2);
            size=0;

            for(int i=0;i<oba.length;i++)
            {
                for(HMNode node:oba[i]) {
                    put(node.key,node.value);
                }
            }

        }

        public V get(K key) throws Exception {
            int bi=hashFunction(key);
            int idx=getKeyIndex(key,bi);

            if(idx==-1) {
                return null;
            }
            else
            {
                HMNode n=buckets[bi].get(idx);
                return n.value;
            }

        }

        public boolean containsKey(K key) {
            int bi=hashFunction(key);
            int idx=getKeyIndex(key,bi);

            if(idx==-1) {
                return false;
            }
            else
            {
                return true;
            }

        }

        public V remove(K key) throws Exception {
            int bi=hashFunction(key);
            int idx=getKeyIndex(key,bi);

            if(idx==-1) {
                return null;
            }
            else
            {
                HMNode n=buckets[bi].remove(idx);
                size--;
                return n.value;
            }

        }

        public ArrayList<K> keyset() throws Exception {
            ArrayList<K> res=new ArrayList<K>();

            for(int i=0;i<buckets.length;i++)
            {
                for(HMNode node:buckets[i])
                {
                    res.add(node.key);
                }
            }
            return res;
        }

        public int size() {
            return size;
        }

        public void display() {
            System.out.println("Display Begins");
            for (int bi = 0; bi < buckets.length; bi++) {
                System.out.print("Bucket" + bi + " ");
                for (HMNode node : buckets[bi]) {
                    System.out.print( node.key + "@" + node.value + " ");
                }
                System.out.println(".");
            }
            System.out.println("Display Ends");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap();

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("put")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                Integer val = Integer.parseInt(parts[2]);
                map.put(key, val);
            } else if (str.startsWith("get")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.get(key));
            } else if (str.startsWith("containsKey")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.containsKey(key));
            } else if (str.startsWith("remove")) {
                String[] parts = str.split(" ");
                String key = parts[1];
                System.out.println(map.remove(key));
            } else if (str.startsWith("size")) {
                System.out.println(map.size());
            } else if (str.startsWith("keyset")) {
                System.out.println(map.keyset());
            } else if (str.startsWith("display")) {
                map.display();
            }
            str = br.readLine();
        }
    }
}
/*
put India 135
put Aus 5
put Canada 3
display
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
get China
null
remove Aus
5
get Aus
null
containsKey US
false
put US 10
put UK 20
remove US
10
containsKey US
false
put Pak 80
put China 200
display
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
put Utopia 0
display
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
put Nigeria 3
display
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
put India 138
display
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
put Sweden 1
display
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
put finland 20
display
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends
quit
 */