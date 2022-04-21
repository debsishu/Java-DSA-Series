package recursion;

import java.util.ArrayList;

public class SubsequencesWithSumK {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 2 };
		ArrayList<Integer> res = new ArrayList<>();
		printSubsequences(0, arr, res, 0, 5);
		printOneSubsequence(0, arr, res, 0, 5);
		System.out.println(countSubsequence(0, arr, 0, 5));
	}

	private static void printSubsequences(int i, int[] arr, ArrayList<Integer> res, int sum, int target) {
		if (sum == target) {
			System.out.println(res);
			return;
		}
		if (i >= arr.length) {
			return;
		}
		sum += arr[i];
		res.add(arr[i]);
		printSubsequences(i + 1, arr, res, sum, target);
		sum -= arr[i];
		res.remove(res.size() - 1);
		printSubsequences(i + 1, arr, res, sum, target);
	}

	private static boolean printOneSubsequence(int i, int arr[], ArrayList<Integer> res, int sum, int target) {
		if (sum == target) {
			System.err.println(res);
			return true;
		}
		if (i >= arr.length) {
			return false;
		}
		sum += arr[i];
		res.add(arr[i]);
		if (printOneSubsequence(i + 1, arr, res, sum, target)) {
			return true;
		}
		sum -= arr[i];
		res.remove(res.size() - 1);
		return printOneSubsequence(i + 1, arr, res, sum, target);
	}

	private static int countSubsequence(int i, int arr[], int sum, int target) {
		if (sum == target) {
			return 1;
		}
		if (i >= arr.length) {
			return 0;
		}
		sum += arr[i];
		int left = countSubsequence(i + 1, arr, sum, target);
		sum -= arr[i];
		int right = countSubsequence(i + 1, arr, sum, target);
		return left + right;
	}
}
