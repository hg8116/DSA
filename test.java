import java.util.*;

class test {
    public static int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<pre.length; i++){
            for(int j=0; j<pre[i].length; j++){
                adj.get(pre[i][0]).add(pre[i][1]);
            }
        }

//        for (List<Integer> x : adj){
//            System.out.println(x);
//        }
        System.out.println(adj);

        int[] indegree = new int[n];
        for(int i=0; i<n; i++){
            for(Integer it: adj.get(i))
                indegree[it]++;
        }
        System.out.println(Arrays.toString(indegree));

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] topo = new int[n];
        int i=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            topo[i++] = curr;
            for(Integer it: adj.get(curr)){
                if(--indegree[it] == 0)
                    q.add(it);
            }
        }

        if(i == n)
            return topo;
        return new int[]{};
    }
    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        int n = 4;

        findOrder(4, pre);

    }
}