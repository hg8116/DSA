// https://leetcode.com/problems/pascals-triangle/

package PascalsTriangle118;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int n){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>();

        for(int i=0; i<n; i++){
            row.add(0, 1);
            for(int j=1; j<row.size() - 1; j++){
                row.set(j, row.get(j) + row.get(j + 1));
            }
            ans.add(new ArrayList<>(row));
        }

        return ans;

    }
}
