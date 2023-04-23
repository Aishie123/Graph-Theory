/*
Aisha Nicole L. Dones
Section A121

6. Write a java program that receives the vertex pairs
associated to the edges of a graph, the program should
construct an adjacency matrix for the graph.
(Produce a version that works when loops, multiple edges,
or directed edges are present.)
*/

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-- ADJACENCY MATRIX OF THE GRAPH --\nCreated by: Aisha Nicole L. Dones\n");

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        // Create the adjacency matrix
        int[][] adjMatrix = new int[n][n];

        // Get whether the graph is directed or undirected
        System.out.print("Is the graph directed? (y/n): ");
        String directed = scanner.next();
        boolean isDirected = directed.equalsIgnoreCase("y");

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        int u = scanner.nextInt();
        int v = scanner.nextInt();
        while (u != -1 && v != -1) {
            if (u < 0 || u >= n || v < 0 || v >= n) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (n-1) + ".");
            } else {
                // Add the edge to the adjacency matrix
                adjMatrix[u][v]++;
                if (!isDirected && u != v) {
                    adjMatrix[v][u]++;
                }
            }
            u = scanner.nextInt();
            v = scanner.nextInt();
        } // end of while

        scanner.close();

        // Print the adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        } // end of for

    } // end of main
} // end of class
