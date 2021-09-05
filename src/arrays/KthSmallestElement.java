package arrays;

import java.util.*;

public class KthSmallestElement {
  public static void main(String[] args) {
    int arr[] = { 1, 3, 5, 2, 9, 10, 12, 14, 16 };
    int k = 3;
    System.out.println(smallestElementHeap(arr, k));
  }

  static int smallestElementSort(int arr[], int k) {
    Arrays.sort(arr);
    return arr[k - 1];
  }

  static int smallestElementHeap(int arr[], int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    for (int e : arr) {
      pq.add(e);
    }

    for (int i = 0; i < k - 1; i++) {
      pq.poll();
    }

    return pq.poll();
  }
}
