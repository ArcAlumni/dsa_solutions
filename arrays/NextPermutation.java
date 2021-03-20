class NextPermutation {

	public void nextPermutation(int[] nums) {

		if (nums.length <= 1)
			return;

		// find the element from last index which stops non decreasing sequence (i)
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i])
			i--;

		// if the element does not exists
		if (i < 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		// find the immediate element from last which is larger that the i-th element
		int j = nums.length - 1;
		while (nums[j] <= nums[i]) {
			j--;
		}

		// swap i and larger element
		swap(nums, i, j);

		// reverse after i
		reverse(nums, i + 1, nums.length - 1);

	}

	void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	void reverse(int[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}

}
