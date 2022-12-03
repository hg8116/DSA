package DisjointUnionSet;

import java.util.ArrayList;
import java.util.List;

// TC - O(4Alpha)
public class DSUSize {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DSUSize(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node))
            return node;

        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public static void main(String[] args) {
        DSUSize ds = new DSUSize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        ds.unionBySize(3, 7);

    }
}
