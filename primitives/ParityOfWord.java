public class ParityOfWord {

	/**
	 * Check the integer is in odd/ even parity. Number of set bits is odd/even.
	 */

	public static void main(String[] args) {
		ParityOfWord p = new ParityOfWord();
		System.out.println(p.parity1(4567987));
		System.out.println(p.parity2(4567987));
	}

	// O(logN)
	int parity2(int x) {
		x ^= x >> 16;
		x ^= x >> 8;
		x ^= x >> 4;
		x ^= x >> 2;
		x ^= x >> 1;
		return (int) x & 1;
	}

	// O(K) k = number of set bits
	int parity1(int x) {
		int result = 0;
		while (x > 0) {
			result ^= 1;
			x &= (x - 1);
		}
		return result;
	}

}
