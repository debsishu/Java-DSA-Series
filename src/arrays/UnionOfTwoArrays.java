package arrays;

import java.util.*;

public class UnionOfTwoArrays {
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 1, 2, 3 };
		System.out.println(doUnion(arr1, arr2));
	}

	public static int doUnion(int arr1[], int arr2[]) {
		HashSet<Integer> s = new HashSet<>();

		for (int i = 0; i < arr1.length; i++) {
			s.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			s.add(arr2[i]);
		}
		return s.size();
	}
}
