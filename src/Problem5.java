/*
Aisha Nicole L. Dones
Section A121

5. Write a java program that receives
a list of edges of a simple graph and
determine whether the graph is bipartite.
*/

import java.util.*;

public class Problem5 {
    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int[] color;

    public static void main(String[] args) {
        int u, v, n;

        System.out.println("\n-- BIPARTITE GRAPH TOOL --\nCreated by: Aisha Nicole L. Dones\n");

        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        n = scanner.nextInt(); // no. of vertices

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

        scanner.close();

        // initialize the color array
        color = new int[n];
        Arrays.fill(color, -1);

        if (isBipartite(n)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    } // end of main

    private static boolean dfs(int u, int c) {
        color[u] = c;
        for (int v : adj.get(u)) {
            if (color[v] == -1) { // if no color has been assigned to the vertex
                if (!dfs(v, 1 - c)) { // if neighbor 'v' has not been visited before
                    return false;
                }
            } else if (color[v] == c) { // if 'v' is in the same color/set as 'u'
                return false;
            }
        }
        return true;
    } // end of dfs method

    private static boolean isBipartite(int n){
        // perform dfs on each connected component of the graph
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) { // if no color has been assigned to the vertex
                if (!dfs(i, 0)) {
                    return false;
                }
            }
        }
        return true;
    } // end of isBipartite method

} // end of class
