/*
Aisha Nicole L. Dones
Section A121

8. Write a Java program that checks whether two graphs
are isomorphic or not, given a set of vertices.
*/

import java.util.*;

public class Problem8 {
    private static int[][] adj1, adj2;
    private static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-- ISOMORPHISM CHECKER FOR TWO GRAPHS --\nCreated by: Aisha Nicole L. Dones\n");

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graphs: ");
        n = scanner.nextInt();

        // Create adjacency matrices for the 2 graphs
        adj1 = new int[n][n];
        adj2 = new int[n][n];

        // Get the edges of the first graph
        System.out.println("Enter the edges of the 1st graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj1, scanner);

        // Get the edges of the second graph
        System.out.println("Enter the edges of the 2nd graph as pairs of vertices, e.g. '0 1'. (Enter '-1 -1' to stop): ");
        readEdges(adj2, scanner);

        scanner.close();

        // Check if the graphs are isomorphic
        if (isIsomorphic()) {
            System.out.println("The graphs are isomorphic.");
        } else {
            System.out.println("The graphs are not isomorphic.");
        }
    } // end of main

    private static void readEdges(int[][] adj, Scanner scanner) {
        int u, v;
        u = scanner.nextInt();
        v = scanner.nextInt();
        while (u != -1 && v != -1) {
            if (u < 0 || u >= n || v < 0 || v >= n) {
                System.out.println("Invalid vertex number. Vertex numbers must be between 0 and " + (n-1) + ".");
            } else {
                // Add the edge to the adjacency matrix
                adj[u][v]++;
                adj[v][u]++;
            }
            u = scanner.nextInt();
            v = scanner.nextInt();
        } // end of while
    } // end of readEdges method

    private static boolean isIsomorphic() {
        // try every permutation of vertices
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        return isIsomorphic(permutation, 0);
    } // end of isIsomorphic method

    private static boolean isIsomorphic(int[] permutation, int index) {
        if (index == n) {
            // check if the current permutation produces a valid mapping
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adj1[i][j] != adj2[permutation[i]][permutation[j]]) {
                        return false;
                    }
                }
            } // end of for loop
            return true;
        } else {
            // try swapping the current index with each index greater than or equal to it
            for (int i = index; i < n; i++) {
                swap(permutation, index, i);
                if (isIsomorphic(permutation, index+1)) {
                    return true;
                }
                swap(permutation, index, i);
            } // end of for loop
            return false;
        }
    } // end of isIsomorphic method with 2 parameters

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } // end of swap method

} // end of class

