//search binary search tree(BST)
//time complexity: O(N) space complexity: O(1)

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public int floorInBST(TreeNode root, int target) {
    int floor = Integer.MIN_VALUE;
    while (root != null) {
        if (target == root.val) {
            return root.val;
        } else if (target < root.val) {
            root = root.left;
        } else {
            floor = root.val;
            root = root.right;
        }
    }
    return floor;
}
