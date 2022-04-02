package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class IsGraphCyclic {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean isGraphCycle(ArrayList<Edge>[] graph,int src,boolean[] vis){
        LinkedList<Integer> que=new LinkedList<>();

        que.addLast(src);

        while(que.size()>0){
            int t=que.removeFirst();

            if(vis[t]) return true;

            vis[t]=true;

            for(Edge e:graph[t]){
                int nbr=e.nbr;
                if(!vis[nbr]){
                    que.addLast(nbr);
                }
            }
        }
        return false;
    }

    public static boolean isGraphCyclic_2(ArrayList<Edge>[] graph, int src, boolean[] vis){
        LinkedList<Integer> que= new LinkedList<>();

        que.addLast(src);

        while(que.size()>0){
            int t=que.removeFirst();

            if(vis[t]) return true;

            vis[t]=true;

            for(Edge e:graph[t]){
                int nbr=e.nbr;
                if(!vis[nbr]){
                    que.addLast(nbr);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        //int scr=br.read();
        boolean ans =false;
        boolean[] vis = new boolean[vtces];

        for(int i=0;i<vtces;i++){
            if(vis[i]==false){
                ans =ans|| isGraphCycle(graph,i,vis);
            }
        }
        System.out.println(ans);
    }
}
/*
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
false

 */