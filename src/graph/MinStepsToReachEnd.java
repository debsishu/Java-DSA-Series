// This is not a optimized solution 
// This has O(n ^ n) time complexity

// The optimized solution requires Dynamic Programming

package graph;

public class MinStepsToReachEnd {

	static int minJumps(int arr[], int l, int h) {
		if (h == l) {
			return 0;
		}
		if (arr[l] == 0) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;
		for (int i = l + 1; i <= h && i <= l + arr[l]; i++) {
			int jumps = minJumps(arr, i, h);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 };
		System.out.println(minJumps(arr, 0, arr.length - 1));
	}

}
