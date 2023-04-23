/*
Aisha Nicole L. Dones
Section A121

7. Write a java program that accepts vertex pairs
associated to the edges of an undirected graph and
the number of times each edge appears. The program
should construct an incidence matrix for the graph.
*/

import java.util.*;

public class Problem7 {
    public static void main(String[] args) {
        int n, m;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-- INCIDENCE MATRIX OF AN UNDIRECTED GRAPH --\nCreated by: Aisha Nicole L. Dones\n");

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        n = scanner.nextInt();

        // Get the number of edges
        System.out.print("Enter the number of edges in the graph: ");
        m = scanner.nextInt();

        int[][] incMat = new int[n][m]; // creates a 2D array for the incidence matrix

        // Get the edges of the graph
        System.out.println("Enter the edges of the graph as pairs of vertices followed by the number of times each edge appears, e.g. '0 1 2'.");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int count = scanner.nextInt();

            for (int j = 0; j < count; j++){
                incMat[u][i+j] = 1;
                incMat[v][i+j] = 1;
            }
            i+=count-1;
        }

        scanner.close();

        // Print the incidence matrix
        System.out.println("Incidence matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(incMat[i][j] + " ");
            }
            System.out.println();
        } // end of for loop

    } // end of main
} // end of class

