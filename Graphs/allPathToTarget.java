import java.util.ArrayList;

public class allPathToTarget {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 - vertex
        graph[0].add(new Edge(0, 3, 1));
        
        // // 2 - vertex
        graph[2].add(new Edge(2, 3, 1));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 1));

        // 4 - vertex
        graph[4].add(new Edge(4, 0, 1));
        graph[4].add(new Edge(4, 1, 1));

        // 5 - vertex
        graph[5].add(new Edge(5, 0, 1));
        graph[5].add(new Edge(5, 2, 1));
    }

    public static void wayToPath(ArrayList<Edge> graph[],int src, int dest,String path) {
        if(src == dest) {
            System.out.println("Path :"+path+dest);
            return;
        }

        for(int i=0;i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            
            wayToPath(graph, e.dest, dest, path+src);
        }
    }
    public static void main(String[] args) {
        // go to immediate neighbours first 
        int V = 7;
        ArrayList<Edge> [] graph = new ArrayList[V];
        createGraph(graph);
        int src = 5;
        int dest = 1;
        wayToPath(graph,src,dest,"");       
    }
}
