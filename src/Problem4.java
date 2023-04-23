/*
Aisha Nicole L. Dones
Section A121

4. Write a java program, given the pair of vertex
associated to the edges of an undirected graph,
it will output the degree of vertex.
*/

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class Problem4 {

    private static final ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); // adjacency list
    private static final ArrayList<String> strAdj = new ArrayList<>(); // adjacency list


    public static void main(String[] args) {
        int u, v, n, size, total = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-- DEGREES OF VERTEX OF AN UNDIRECTED GRAPH --\nCreated by: Aisha Nicole L. Dones\n");

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
                strAdj.add("{" + u + ", " + v + "}");
            }
            u = scanner.nextInt();
            v = scanner.nextInt();
        } // end of while

        scanner.close();

        for (int i = 0; i < n; i++){
            size = adj.get(i).size(); // gets no. of adjacent vertices for every vertex i
            total+=size; // computes total degrees
            System.out.println("deg(" + i + "): " + size); // displays degrees per vertex
        }
        System.out.println("\nTotal Degree of Graph: " + total); // displays total degrees

    } // end of main

} // end of class
