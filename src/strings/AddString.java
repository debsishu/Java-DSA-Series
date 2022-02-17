package strings;

public class AddString {
	public static void main(String[] args) {
		String num1 = "999";
		String num2 = "999";

		System.out.println(addString(num1, num2));
	}

	static String addString(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();

		while (i >= 0 || j >= 0) {
			int n1 = 0;
			int n2 = 0;
			if (i >= 0) {
				n1 = num1.charAt(i) - '0';
			}
			if (j >= 0) {
				n2 = num2.charAt(j) - '0';
			}
			int num = n1 + n2 + carry;
			sb.append(num % 10);
			carry = num / 10;
			i--;
			j--;
		}

		if (carry != 0) {
			sb.append(carry);
		}

		return sb.reverse().toString();
	}
}
