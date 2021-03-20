public class CountSetBits {

	public static void main(String[] args) {
		CountSetBits main = new CountSetBits();
		System.out.println(main.findNumberOfSetBits1(Integer.MAX_VALUE));
		System.out.println(main.findNumberOfSetBits2(Integer.MAX_VALUE));
	}

	// O(K) K is number of set bits
	int findNumberOfSetBits2(int n) {
		int setBits = 0;
		while (n > 0) { // runs only for number of set bits in n
			setBits++;
			n &= (n - 1); // clears the right most set bit
		}
		return setBits;
	}

	// O(N) N is length of bits
	int findNumberOfSetBits1(int n) {
		int setBits = 0;
		while (n > 0) {
			setBits += (n & 1);
			n >>= 1;
		}
		return setBits;
	}

}
