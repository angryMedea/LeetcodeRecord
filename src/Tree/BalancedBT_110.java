package Tree;

/**
 * 和104几乎一模一样
 * 1.递归求每个节点的左右子树的最大深度
 * 2.check每个节点左右子树的最大深度差值是否小于1
 */
public class BalancedBT_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = depth(root.left);
        int right = depth(root.right);
        int absDepth = Math.abs(left - right);
        return absDepth <= 1&&isBalanced(root.left)&&isBalanced(root.right);

    }

    int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }
}
