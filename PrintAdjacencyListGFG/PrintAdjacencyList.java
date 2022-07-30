// https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1

package PrintAdjacencyListGFG;

import java.util.ArrayList;

public class PrintAdjacencyList {
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i=0; i<V; i++){
            ArrayList<Integer> row = new ArrayList<>();
            row.add(i);
            for(int j=0; j<adj.get(i).size(); j++)
                row.add(adj.get(i).get(j));

            ans.add(row);
        }

        return ans;
    }
}
