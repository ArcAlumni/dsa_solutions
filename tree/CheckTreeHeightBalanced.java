class CheckTreeHeightBalanced {

	public boolean isBalanced(TreeNode root) {
		return height(root) != Integer.MIN_VALUE;
	}

	int height(TreeNode root) {

		if (root == null)
			return -1;

		int lh = height(root.left);
		if (lh == Integer.MIN_VALUE)
			return lh;

		int rh = height(root.right);
		if (rh == Integer.MIN_VALUE)
			return rh;

		if (Math.abs(lh - rh) > 1)
			return Integer.MIN_VALUE;

		return Math.max(lh, rh) + 1;
	}

}
