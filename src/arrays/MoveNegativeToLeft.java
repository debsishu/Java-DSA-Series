package arrays;

public class MoveNegativeToLeft {
	public static void main(String[] args) {
		int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		int n = arr.length;
		rearragne(arr, n);
		for (int e : arr) {
			System.out.print(e + " ");
		}
	}

	public static void rearragne(int arr[], int n) {
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				index++;
			}
		}
	}

}
