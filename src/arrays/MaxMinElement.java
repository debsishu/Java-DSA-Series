package arrays;

public class MaxMinElement {
  public static void main(String[] args) {
    int arr[] = { 1, 5, 3, 6, 7, 8 };
    Pair p = findMinMax(arr);
    System.out.println(p.max + " " + p.min);
  }

  static Pair findMinMax(int arr[]) {
    Pair p = new Pair();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int e : arr) {
      if (e > max) {
        max = e;
      }
      if (e < min) {
        min = e;
      }
    }

    p.max = max;
    p.min = min;
    
    return p;
  }

  static class Pair {
    int max;
    int min;
  }
}
