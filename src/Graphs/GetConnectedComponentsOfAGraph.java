package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetConnectedComponentsOfAGraph {
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

    public static void dfs(int src,boolean[] vis,ArrayList<Edge>[] graph, ArrayList<Integer> comp){
        vis[src]=true;
        comp.add(src);

        for(Edge e:graph[src]){
            int nbr=e.nbr;
            if(!vis[nbr]){
                dfs(nbr,vis,graph,comp);
            }
        }
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

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        // write your code here
        boolean[] visited=new boolean[vtces];

        for(int i=0;i<vtces;i++){
            if(visited[i]==false){
                ArrayList<Integer> comp = new ArrayList<Integer>();
                dfs(i,visited,graph,comp);

                comps.add(comp);
            }
        }

        System.out.println(comps);

    }
}
/*
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
[[0, 1], [2, 3], [4, 5, 6]]

 */