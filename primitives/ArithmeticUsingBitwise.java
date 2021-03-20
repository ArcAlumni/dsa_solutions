public class ArithmeticUsingBitwise {

	public static void main(String[] args) {
		ArithmeticUsingBitwise a = new ArithmeticUsingBitwise();
		System.out.println(a.add(5, 12));
	}

	// build half adder by b = a ^ b
	// carry using a & b and <<
	// build full adder by carry ^ b
	int add(int a, int b) {
		while (a != 0) {
			int carry = a & b;
			b ^= a;
			a = carry << 1;
		}
		return b;
	}

	int multiply(int a, int b) {
		int sum = 0;
		while (a != 0) {
			if ((a & 1) == 1)
				sum = add(sum, b);
			a >>= 1;
			b <<= 1;
		}
		return sum;
	}

}
