package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class SpreadOfInfection {

    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

//marking visited at insertion time
    public static int BFS(ArrayList<Edge>[] graph,int src,int t){
        int vtces = graph.length;

        boolean[] vis = new boolean[vtces];

        LinkedList<Integer> que = new LinkedList<>();

        int count=1;
        que.addLast(src);
        vis[src]=true;

        int level=1;

        while (que.size()>0 && level < t){
            int size = que.size();

            while(size-->0){
                int top=que.removeFirst();

                for(Edge e:graph[top]){
                    int nbr=e.nbr;

                    if(!vis[nbr]){
                        vis[nbr]=true;
                        que.addLast(nbr);
                        count++;
                    }
                }
            }
            level++;
        }
        return count;
    }

    //marking visited at removal time
    public static int BFS_2(ArrayList<Edge>[] graph, int src,int t){
        int vtces = graph.length;

        boolean[] vis = new boolean[vtces];

        LinkedList<Integer> que = new LinkedList<>();

        int count=0;
        que.addLast(src);

        int level=1;

        while(que.size()>0 && level<=t){
            int size= que.size();

            while(size-->0){
                int top=que.removeFirst();

                if(vis[top]) continue;

                vis[top]=true;
                count++;

                for(Edge e:graph[top]){
                    int nbr=e.nbr;
                    if(!vis[nbr]){
                        que.addLast(nbr);
                    }
                }
            }
            level++;
        }
        return count;

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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());

        int ans=BFS(graph,src,t);
        System.out.println(ans);

        // write your code here
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
6
3
output
4

 */