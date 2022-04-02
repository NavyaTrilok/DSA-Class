package Graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstTraversal {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    static class Pair{
        int node;
        String path;

        public Pair(int node,String path){
            this.node=node;
            this.path=path;
        }
    }

    public static void bfs(int src, ArrayList<Edge>[] graph){
        LinkedList<Pair> que = new LinkedList<>();

        int vtces=graph.length;

        boolean[] vis = new boolean[vtces];

        que.addLast(new Pair(src,src+""));
        int level=0;

        while(que.size()>0){
            int size=que.size();
            System.out.println(level+"->..........");
            while( size-->0){
                Pair t = que.removeFirst();

                int node = t.node;
                String psf=t.path;

                if(vis[node]) continue;

                vis[node]=true;
                System.out.println(node+"@"+psf);

                for(Edge e:graph[node]){
                    int nbr=e.nbr;
                    if(!vis[nbr]){
                        que.addLast(new Pair(nbr,psf+nbr));
                    }
                }
            }
            level++;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        bfs(src,graph);

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
2
0->..........
2@2
1->..........
1@21
3@23
2->..........
0@210
4@234
3->..........
5@2345
6@2346
4->..........

 */