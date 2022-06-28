// https://leetcode.com/problems/kth-largest-element-in-an-array/

package KthLargestElementInAnArray215;

import java.util.PriorityQueue;

public class Heap {
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i=0; i<nums.length; i++){
            minHeap.add(nums[i]);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
