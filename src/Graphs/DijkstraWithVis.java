package Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraWithVis {
    public static class Edge{
        int v;
        int w;

        Edge(int v,int w) {
            this.v = v;
            this.w = w;
        }
    }

    public class Pair{
        int node;
        int wsf;

        public Pair(int node, int wsf){
            this.node=node;
            this.wsf=wsf;
        }
    }

    public int[] dijkstra(ArrayList<Edge>[] graph, int src){

        int V=graph.length;

        int[] dis = new int[V];
        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new Pair(src,0));

        while(pq.size()>0){
            Pair t = pq.remove();

            int node=t.node;
            int wsf=t.wsf;

            if(vis[node]) continue;

            vis[node] = true;
            dis[node] = wsf;

            for(Edge e:graph[node]){
                    int v=e.v;
                    int w=e.w;

                    if(!vis[v]){
                        pq.add(new Pair(v,wsf+e.w));
                    }
            }
        }

        return dis;

    }

    public int[] dijkstra_better(ArrayList<Edge>[] graph, int src){
        int V = graph.length;

        int[] dis=new int[V];

        Arrays.fill(dis,(int)(1e8));

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new Pair(src,0));
        dis[src]=0;

        while(pq.size()>0){
            Pair p = pq.remove();

            int node = p.node;
            int wsf=p.wsf;

            if(dis[node]<wsf) continue;

            for(Edge e:graph[node]){
                int v=e.v;
                int w=e.w;

                if(dis[v]<wsf+w){
                    dis[v]=wsf+w;
                    pq.add(new Pair(v,wsf+w));
                }
            }
        }

        return dis;
    }

    public static void main(String[] args){

    }

}
