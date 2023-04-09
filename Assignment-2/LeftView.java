//queue and LinkedList
//time complexity: O(N) space complexity: O(N)

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public List<Integer> leftView(TreeNode root) {
    List<Integer> leftView = new ArrayList<>();
    if (root == null) {
        return leftView;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            if (i == 0) {
                leftView.add(node.val);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    return leftView;
}
