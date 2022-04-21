package recursion;

import java.util.ArrayList;

public class PrintAllSubsequences {
	public static void main(String[] args) {
		int arr[] = { 3, 1, 2 };
		ArrayList<Integer> res = new ArrayList<>();
		printSubsequences(0, arr, res);
	}

	static void printSubsequences(int i, int arr[], ArrayList<Integer> res) {
		if (i >= arr.length) {
			System.out.println(res);
			return;
		}
		res.add(arr[i]);
		printSubsequences(i + 1, arr, res);
		res.remove(res.size() - 1);
		printSubsequences(i + 1, arr, res);
	}
}
