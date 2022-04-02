package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static LinkedLists.SubtractTwoLinkedList.scn;

public class HasPath {
    static class Edge {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static void display(ArrayList<Edge>[] graph){
        for(int i=0;i< graph.length;i++){
            System.out.println(i+"->");
            for(Edge e:graph[i]) {
                System.out.print("{"+e.u+" "+e.v+" "+e.w+"}");
            }
            System.out.println();
        }
    }

    public static void addEdge(int u,int v,int w, ArrayList<Edge>[] graph)
    {
        graph[u].add(new Edge(u,v,w));
        graph[v].add(new Edge(v,u,w));
    }

    public static boolean hasPath(int scr,int des, ArrayList<Edge>[] graph,boolean []vis) {
        if(scr==des){
            return true;
        }

        vis[scr]=true;

        for(Edge e:graph[scr]){
            int nbr=e.v;
            if(!vis[nbr]){
                if(hasPath(nbr,des,graph,vis)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i = 0; i < vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int total_edge_count = Integer.parseInt(br.readLine());
        for(int i = 0; i < total_edge_count; i++){
            String[] parts = br.readLine().split(" ");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);

            addEdge(u,v,w,graph);
        }

        int scr=scn.nextInt();
        int des=scn.nextInt();
        //display(graph);

        System.out.println(hasPath(scr,des,graph,new boolean[vtces]));

    }

}
/*
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6
output
true

 */