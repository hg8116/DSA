// https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1#

package MColoringProblemGFG;

public class MColoringProblem {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        return(colorTheGraph(0, color, graph, m, n));
    }

    public boolean colorTheGraph(int node, int[] color, boolean[][] graph, int m, int n){
        if(node == n) return true;

        for(int i=1; i<=m; i++){
            if(isSafe(node, color, graph, i)){
                color[node] = i;
                if(colorTheGraph(node + 1, color, graph, m, n)){
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public boolean isSafe(int node, int[] color, boolean[][] graph, int col){
        for(int i=0; i<graph.length; i++){
            if(graph[node][i]){
                if(color[i] == col) return false;
            }
        }
        return true;
    }
}
