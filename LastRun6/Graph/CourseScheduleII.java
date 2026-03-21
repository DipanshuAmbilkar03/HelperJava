package LastRun6.Graph;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> seq = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            seq.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];

            seq.get(prereq).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int idx = 0;

        // BFS (Kahn’s Algorithm)
        while (!q.isEmpty()) {
            int curr = q.poll();
            result[idx++] = curr;

            for (int neighbor : seq.get(curr)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        // If cycle exists
        if (idx != numCourses) {
            return new int[0];
        }

        return result;
    }

    // Main function for testing
    public static void main(String[] args) {
        CourseScheduleII obj = new CourseScheduleII();

        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] order = obj.findOrder(numCourses, prerequisites);

        if (order.length == 0) {
            System.out.println("Cycle detected! No valid course order.");
        } else {
            System.out.println("Course Order:");
            for (int course : order) {
                System.out.print(course + " ");
            }
        }
    }
}