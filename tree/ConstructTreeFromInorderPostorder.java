class ConstructTreeFromInorderPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIdx = postorder.length - 1;
        
        indicesMap = new HashMap<>();
        
        int idx = 0;
        for(int x : inorder){
            indicesMap.put(x, idx++);
        }
        
        return helper(postorder, inorder, 0, inorder.length - 1);
    }
    
    HashMap<Integer, Integer> indicesMap;
        
    int postorderIdx = 0;
    
    
    TreeNode helper(int[] postorder, int[] inorder, int inorderStartIdx, int inorderEndIdx){
    
        if(inorderStartIdx > inorderEndIdx)
            return null;
        
        int rootValue = postorder[postorderIdx--];
        
        TreeNode root = new TreeNode(rootValue);

        if(inorderEndIdx == inorderStartIdx)
            return root;
        
        int i = indicesMap.get(rootValue);

        root.right = helper(postorder, inorder, i + 1, inorderEndIdx);
        root.left = helper(postorder, inorder, inorderStartIdx, i - 1);
        
        return root;
    }
    
}
