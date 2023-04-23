/*
Aisha Nicole L. Dones
Section A121

3. Write a java program that will determine if a graph has a cycle or not.
*/

import java.util.*;

public class Problem3 {

    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list
    private static boolean hasCycle;

    public static void main(String[] args) {
        int u, v, n;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-- DETERMINE CYCLE IN A GRAPH --\nCreated by: Aisha Nicole L. Dones\n");

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>()); // creates an adjacency list for each vertex
        }

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        u = scanner.nextInt();
        v = scanner.nextInt();

        while (u != -1 && v != -1) {
            if (u < 0 || u >= n || v < 0 || v >= n) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (n-1) + ".");
            } else {
                adj.get(u).add(v); // gets the array list in index u and adds v in the adjacency list of vertex "u"
                adj.get(v).add(u); // vice versa
            }
            u = scanner.nextInt();
            v = scanner.nextInt();
        } // end of while

        if (hasCycle(n)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }

        scanner.close();
    } // end of main

    private static boolean hasCycle(int V) {
        boolean[] visited = new boolean[V]; // keeps track of vertices visited
        for (int v = 0; v < V; v++) {
            if (!visited[v]) { // if a vertex has not been visited
                if (dfs(v, -1, visited)) { // (since starting vertex has no parent, parent = -1)
                    hasCycle = true;
                    break;
                }
            }
        }
        return hasCycle;
    } // end of hasCycle method

    // depth-first search
    private static boolean dfs(int v, int parent, boolean[] visited) {
        visited[v] = true;
        for (int w : adj.get(v)) { // for each adjacent vertex
            if (!visited[w]) { // if adjacent vertex has not been visited
                if (dfs(w, v, visited)) {
                    return true;
                }
            } else if (w != parent) { // if w is not the parent of the vertex
                return true;
            }
        }
        return false;
    } // end of dfs method

} // end of class

