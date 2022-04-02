package Graphs;

import java.util.ArrayList;

public class DSU {
    int[] par;
    int[] size;

    public int findPar(int u){
        if(par[u]==u) return u;

        int p=findPar(par[u]);

        par[u]=p;

        return p;
    }

    public void merge(int p1,int p2){
            if(size[p1]>=size[p2]){
                par[p2]=p1;
                size[p1]=size[p1]+size[p2];
        }else{
                par[p1]=p2;
                size[p2]+=size[p1];
        }

    }

    public ArrayList<Integer>[] createSpanningTree(int V, int[][] edges){
        ArrayList<Integer>[] graph=new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        par=new int[V];
        size=new int[V];

        for(int i=0;i<V;i++){
            par[i]=i;
            size[i]=1;
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            int p1=findPar(u);
            int p2=findPar(v);

            if(p1!=p2){
                merge(p1,p2);
                addEdge(graph,u,v);
            }
        }

        return graph;

    }

    public void addEdge(ArrayList<Integer>[] graph,int u,int v){
        graph[u].add(v);
        graph[v].add(u);
    }

    public static void main(String[] args){

    }
}
