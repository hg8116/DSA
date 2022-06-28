package KthSmallestElement;

import java.util.PriorityQueue;

// Using heap

public class Main {
    public static int kthSmallestElement(int[] arr, int k){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        for (int i=0; i<arr.length; i++){
            maxHeap.add(arr[i]);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr= {2, 1, 3, 4, 5};
        System.out.println(kthSmallestElement(arr, 2));
    }
}
