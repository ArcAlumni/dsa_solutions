public class SubstringSearch {

	public static void main(String[] args) {
		SubstringSearch obj = new SubstringSearch();
		System.out.println(obj.karpRabinSearch("abcd efghij klmnopqr stuv", "mnopq"));
	}

	boolean karpRabinSearch(String str, String searchStr) {
		int len = searchStr.length();
		long searchStrHash = hash(searchStr);
		long strHash = hash(str.substring(0, len));
		for (int i = len; i < str.length(); i++) {
			if (searchStrHash == strHash) {
				for (int j = 0, k = i; j < len; j++, k++) {
					if (searchStr.charAt(j) != str.charAt(k))
						break;
				}
				return true;
			}
			strHash = rollingHash(strHash, str.charAt(i - len), str.charAt(i), len);
		}
		return false;
	}

	long rollingHash(long hash, char remove, char add, int len) {
		hash -= remove * Math.pow(10, len);
		hash *= 10;
		hash += add * 10;
		return hash;
	}

	long hash(String str) {
		int len = str.length();
		long hash = 0;
		int pow = len;
		for (int i = 0; i < len; i++) {
			hash += str.charAt(i) * Math.pow(10, pow);
			pow--;
		}
		return hash;
	}

}
