package Graph;

// Representing undirected graph using adjacency matrix
// Space Complexity - O(N^2)

import java.util.Scanner;

public class UndirectedGraphArrayRepresentation {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        n = sc.nextInt();
        System.out.println("Enter number of edges");
        m = sc.nextInt();

        int[][] adj = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
    }
}
