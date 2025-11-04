import java.util.*;

public class bfs {
        static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s,int d,int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    public static void BFS(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0);
        ArrayList<Integer> bfs = new ArrayList<>();

        while(!q.isEmpty()) {
            int curr = q.remove();

            if(!vis[curr]) {
                bfs.add(curr);
                vis[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }

        System.out.println(bfs);
    }
   public static ArrayList<Integer> bfs(ArrayList<Edge> graph[]){
        boolean[] vis = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            
            for(Edge x : graph[node]) {
                if(!vis[x.des]) {
                    q.add(x.des);
                    vis[x.des] = true;
                }
            }
        }
        
        return res;
    }   

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++ ){
            graph[i] = new ArrayList<>();
        }

        // 0 - vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(5, 5, 1));
    }
    public static void main(String[] args) {
        // go to immediate neighbours first 
        int V = 7;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        // List<Integer> bfsans = bfs(graph);

        // System.out.println(bfsans);
        BFS(graph);
    }
}
