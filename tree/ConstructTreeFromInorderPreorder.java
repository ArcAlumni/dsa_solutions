class ConstructTreeFromInorderPreorder {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, inorder.length - 1);
	}

	int preorderIdx = 0;

	TreeNode helper(int[] preorder, int[] inorder, int inorderStartIdx, int inorderEndIdx) {

		if (preorderIdx >= preorder.length || inorderStartIdx > inorderEndIdx)
			return null;

		int rootValue = preorder[preorderIdx++];

		TreeNode root = new TreeNode(rootValue);

		if (inorderEndIdx == inorderStartIdx)
			return root;

		// cacheable
		int i;
		for (i = inorderStartIdx; i <= inorderEndIdx; i++) {
			if (inorder[i] == rootValue)
				break;
		}

		root.left = helper(preorder, inorder, inorderStartIdx, i - 1);
		root.right = helper(preorder, inorder, i + 1, inorderEndIdx);

		return root;
	}

}
