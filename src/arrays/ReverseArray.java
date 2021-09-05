package arrays;

class ReverseArray {
  public static void main(String[] args) {
    int arr[] = { 1, 2, 3, 4, 5, 6 };
    reverseArray(arr, 0, arr.length - 1);
    for (int e : arr) {
      System.out.print(e + " ");
    }
  }

  static void reverseArray(int arr[], int low, int high) {
    while (low < high) {
      int temp = arr[low];
      arr[low] = arr[high];
      arr[high] = temp;
      low++;
      high--;
    }
  }
}