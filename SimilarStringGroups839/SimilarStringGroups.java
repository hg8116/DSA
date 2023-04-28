// https://leetcode.com/problems/similar-string-groups/description/

package SimilarStringGroups839;

import java.util.ArrayList;
import java.util.List;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<strs.length; i++)
            adj.add(new ArrayList<>());

        for(int i=0; i<strs.length; i++){
            for(int j=i+1; j<strs.length; j++){
                if(i != j && check(strs[i], strs[j])){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[strs.length];
        int ans = 0;
        for(int i=0; i<strs.length; i++){
            if(!vis[i]){
                dfs(i, adj, vis);
                ans++;
            }
        }

        return ans;
    }

    void dfs(int node, List<List<Integer>> adj, boolean[] vis){
        vis[node] = true;
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it, adj, vis);
            }
        }
    }

    boolean check(String s1, String s2){
        int count = 0;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                count++;
        }
        return count == 0 || count == 2;
    }
}
