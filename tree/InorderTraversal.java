class InorderTraversal {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> li = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(true){
            
            // push all left nodes from root
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            if(stack.isEmpty()){
                break;
            }
            
            // pop recent and visit and go right
            TreeNode node = stack.pop();
            li.add(node.val);
            
            if(node.right != null){
                root = node.right;
                continue;
            }
            
            if(stack.isEmpty()){
                break;
            }
            // pop root and visit and go right
            node = stack.pop();
            li.add(node.val);
            root = node.right;
        }
        
        return li;
    }
    
}
