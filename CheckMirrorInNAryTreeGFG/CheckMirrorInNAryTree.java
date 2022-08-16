// https://practice.geeksforgeeks.org/problems/check-mirror-in-n-ary-tree1528/1

package CheckMirrorInNAryTreeGFG;

import java.util.HashMap;
import java.util.Stack;

public class CheckMirrorInNAryTree {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer, Stack<Integer>> map = new HashMap<>();
        for(int i=0; i<2*e; i+=2){
            if(!map.containsKey(A[i])){
                Stack<Integer> stack = new Stack<>();
                stack.push(A[i+1]);

                map.put(A[i], stack);
            }
            else{
                map.get(A[i]).push(A[i+1]);
            }
        }

        for(int i=0; i<2*e; i+=2){
            if(map.get(B[i]).peek() != B[i+1]) return 0;
            else map.get(B[i]).pop();
        }

        return 1;
    }
}
