//in-order traveral
//time complexity: O(N) and space complexity: O(N)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public boolean isBST(TreeNode root) {
    return Traversal(root, null);
}

private boolean Traversal(TreeNode node, TreeNode prev) {
    if (node == null) {
        return true;
    }
    
    if (!Traversal(node.left, prev)) {
        return false;
    }
    
    if (prev != null && prev.val >= node.val) {
        return false;
    }
    
    prev = node;
    
    return Traversal(node.right, prev);
}
