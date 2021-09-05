package arrays;

public class Sort012 {
	public static void main(String[] args) {
		int arr[] = { 0, 2, 1, 2, 0 };
		sort012(arr, arr.length);
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void sort012(int arr[], int n) {
		int zero = 0, one = 0, two = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				zero++;
			}
			if (arr[i] == 1) {
				one++;
			}
			if (arr[i] == 2) {
				two++;
			}
		}

		for (int i = 0; i < n; i++) {
			if (i < zero) {
				arr[i] = 0;
			}
			if (i >= zero && i < zero + one) {
				arr[i] = 1;
			}
			if (i >= zero + one && i < zero + one + two) {
				arr[i] = 2;
			}
		}
	}
}
