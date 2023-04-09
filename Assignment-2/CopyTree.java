//in-order traversal
//time complexity: O(N) and space complexity: O(N)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public TreeNode copyTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    
    TreeNode newRoot = new TreeNode(root.val);
    newRoot.left = copyTree(root.left);
    newRoot.right = copyTree(root.right);
    
    return newRoot;
}
