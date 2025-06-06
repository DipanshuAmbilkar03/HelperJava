import java.util.*;

public class topologicalSort {
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

    public static void indegree(ArrayList<Edge> graph[], int[] indeg) {
        for(int i=0; i<graph.length; i++) {
            int ver = i;
            for(int j=0; j<graph[ver].size(); j++) {
                Edge e = graph[ver].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]) {
        int[] indeg = new int[graph.length];
        indegree(graph,indeg);
        Queue<Integer> q = new LinkedList<>();

        // indegree 0 elements
        for(int i=0; i<indeg.length; i++) {
            if(indeg[i] == 0) {
                q.add(i);
            }
        }

        // bsf
        while(!q.isEmpty()) {
            int curr = q.remove();  
            System.out.print(curr + "-");
        
            for(int i=0; i<graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;

                if(indeg[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge> graph[],int wt) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

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
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, V);

        topSort(graph);

    }
}