import java.util.*;

public class Solution {
    private boolean isCycleDirectedDFS(int src, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[src] = true;
        pathVis[src] = true;

        for (int neigh : adj.get(src)) {
            if (!vis[neigh]) {
                if (isCycleDirectedDFS(neigh,vis,pathVis,adj)) {
                    return true; 
                }
            } 
            else if (pathVis[neigh]) {
                return true; 
            }
        }

        pathVis[src] = false;
        return false;
    }

    int[] numCourses = {12,23,5,54,3};
    int[][] prerequisites = {{4,36,3},{43,43,2}};

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int a = edge[0];
            int b = edge[1];
            adj.get(b).add(a);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for (int i=0; i<numCourses; i++) {
            if (!vis[i]) {
                if (isCycleDirectedDFS(i,vis,pathVis,adj)) {
                    return false; 
                }
            }
        }
        return true;
    }
}
