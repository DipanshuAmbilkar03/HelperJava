import java.util.*;

public class graph {
    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int E) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < E; i++) {
            System.out.println("Enter source:");
            int s = sc.nextInt();
            System.out.println("Enter destination:");
            int d = sc.nextInt();
            System.out.println("Enter weight:");
            int w = sc.nextInt();
            graph[s].add(new Edge(s, d, w)); // For directed graph
            // If undirected graph, also add: graph[d].add(new Edge(d, s, w));
        }
    }

    public static void printGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            System.out.println("Edges from vertex " + i + ":");
            for (Edge e : graph[i]) {
                System.out.println("  " + e.des);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter total edges: ");
        int E = sc.nextInt();

        // Initialize graph
        ArrayList<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph, E);
        printGraph(graph);
    }
}
