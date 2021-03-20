public class ReverseBits {

	/**
	 * To reverse bits of an integer
	 */

	public static void main(String[] args) {
		ReverseBits r = new ReverseBits();
		System.out.println(Integer.toBinaryString(687657));
		System.out.println(Integer.toBinaryString(r.reverseBits(687657)));
	}

	// take each LSB from 'x' by >>
	// and append to 'rev' by | (OR)
	// make appended bit as MSB by <<
	int reverseBits(int x) {
		int rev = 0;
		for (int i = 0; i < 32; i++) {
			rev <<= 1;
			rev |= (x & 1);
			x >>= 1;
		}
		return rev;
	}

}
