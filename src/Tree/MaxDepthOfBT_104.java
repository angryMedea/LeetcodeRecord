package Tree;

/**
 * 记住一句话：二叉树的最大深度就是左右子树的最大深度+1
 */
public class MaxDepthOfBT_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        // 先遍历到最底层的叶子节点再一层一层往上加，其实是后序遍历求高度
        // 深度应该使用前序遍历，从根节点开始一层一层往下挖
        // 但是根节点的高度 = 最大深度，所以后序遍历也没问题
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int maxDepth = Math.max(leftDepth,rightDepth) + 1;
        return maxDepth;
    }
}
