package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    public static class Edge{
        int v;
        int w;

        Edge(int v,int w) {
            this.v = v;
            this.w = w;
        }
    }

    public class Prims_pair{
        int node;
        int par;
        int weight;

        public Prims_pair(int node,int par,int weight){
            this.node = node;
            this.par=par;
            this.weight=weight;
        }
    }
    public ArrayList<Edge>[] prims(ArrayList<Edge>[] graph,int src){
            int V = graph.length;

            boolean[] vis = new boolean[V];

            ArrayList<Edge>[] mst = new ArrayList[V];

            for(int i=0;i<V;i++){
                mst[i]=new ArrayList<>();
            }

        PriorityQueue<Prims_pair> pq = new PriorityQueue<>((Prims_pair a, Prims_pair b)->{
                return a.weight - b.weight;
        });

         pq.add(new Prims_pair(src,-1,0));

         while(pq.size()>0){
             Prims_pair p = pq.remove();

             int node = p.node;
             int par = p.par;
             int weight = p.weight;

             if(vis[node]) continue;

             vis[node]=true;

             if(par!=-1){
                 addEdge(par,node,weight,mst);
             }

             for(Edge e:graph[node]){
                 if(vis[e.v]==false){
                     pq.add(new Prims_pair(e.v,node,e.w));
                 }
             }

         }

         return mst;
    }

    public void addEdge(int u,int v,int w, ArrayList<Edge>[] graph){
            graph[u].add(new Edge(v,w));
            graph[v].add(new Edge(u,w));
    }
    public static void main(String[] args){

    }
}
