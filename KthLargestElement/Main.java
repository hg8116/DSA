package KthLargestElement;

import java.util.PriorityQueue;

// Using heap

public class Main {

    public static int kthLargestElement(int[] arr, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr= {2, 1, 3, 4, 5};
        System.out.println(kthLargestElement(arr, 2));
    }
}
