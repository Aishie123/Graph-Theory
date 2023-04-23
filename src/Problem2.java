/*
Aisha Nicole L. Dones
Section A121

2. Write a java program that accepts an adjacency matrix of a graph.
The program should list the edges of this graph and give the number
of times each edge appears.
*/

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {

        System.out.println("\n-- EDGES OF AN UNDIRECTED GRAPH GIVEN AN ADJACENCY MATRIX --\nCreated by: Aisha Nicole L. Dones\n");

        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt(); // no. of vertices
        int[][] adjMatrix = new int[n][n]; // n x n matrix
        System.out.println("Enter the adjacency matrix of the graph: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        // Get the edges of the graph
        System.out.println("Edges of the graph:");

        /* [n * (n-1)] excludes the diagonal and divides the total to 2
        to get the total number of edges, without counting them twice. */
        int[][] edges = new int[n*(n-1)/2][2]; // 2 columns to store the vertex indices
        int[] counts = new int[n*(n-1)/2];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 1 is added to i to consider the elements above the diagonal
                if (adjMatrix[i][j] != 0) { // if there is an edge between vertices i and j
                    edges[idx][0] = i;
                    edges[idx][1] = j;
                    counts[idx] = adjMatrix[i][j]; // no. of times a specific edge appears
                    idx++;
                }
            }
        }
        for (int i = 0; i < idx; i++) { // displays each edge with the no. of times it appears
            System.out.println("{" + edges[i][0] + ", " + edges[i][1] + "} or " + "{" + edges[i][1] + ", " +
                    edges[i][0] + "} : " + counts[i] + " time(s)");
        }

        scanner.close();

    } // end of main

} // end of class
