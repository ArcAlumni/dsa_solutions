public class ReverseInteger {

	public static void main(String[] args) {
		ReverseInteger obj = new ReverseInteger();
		System.out.println(obj.reverse(123456));
	}

	int reverse(int x) {
		int result = 0;
		while (x != 0) {
			result *= 10;
			result += x % 10;
			x /= 10;
		}
		return result;
	}

}
