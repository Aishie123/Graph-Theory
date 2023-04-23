/*
Aisha Nicole L. Dones
Section A121

1. Write a java program that receives a list of edges of a simple graph,
the program should determine whether it is connected and find the number
of connected components if it is not connected.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        int n, u, v, count, isolatedVertices;

        System.out.println("\n-- SIMPLE GRAPH CONNECTIVITY CHECKER --\nCreated by: Aisha Nicole L. Dones\n");

        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices
        System.out.print("Enter the number of vertices in the graph: ");
        n = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list
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

        int[] result = isConnected(n, adj);
        count = result[0]; // no. of connected components
        isolatedVertices = result[1]; // no. of isolated vertices
        if (count == 1) {
            System.out.println("The graph is connected.");
        }
        else { // if disconnected
            System.out.println("The graph has " + count + " connected components and " + isolatedVertices + " isolated vertices.");
        }
    } // end of main

    // depth-first search
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) { // for each adjacent vertex
            if (!visited[neighbor]) { // if adjacent vertex has not been visited
                dfs(neighbor, adj, visited);
            }
        }
    } // end of dfs method

    private static int[] isConnected(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n]; // keeps track of vertices visited
        int count = 0; // keeps track of connected components
        int isolatedVertices = 0; // keeps track of isolated vertices
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // if a vertex has not been visited
                dfs(i, adj, visited);
                count++;
            }
            if (adj.get(i).isEmpty()) { // if a vertex has no adjacent vertices
                isolatedVertices++;
            }
        }
        int[] result = new int[2];
        result[0] = count; // no. of connected components
        result[1] = isolatedVertices; // no. of isolated vertices
        return result;
    } // end of isConnected method

} // end of class