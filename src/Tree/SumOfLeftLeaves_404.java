package Tree;

/**
 * 求所有左叶子节点的和
 * 要注意左叶子节点的定义
 * 左子树有左叶子节点，右子树也有左叶子节点，在递归时千万不能忘记左子树
 * 终止条件：1. 根节点为null
 *         2. 节点为左叶子节点
 */
public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        // 1. 根节点为null
        if(root == null) return 0;
        int sum = 0;
        if(root.left != null){
            // 2. 节点为左叶子节点
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }else{
                // 如果不是叶子节点，就继续递归，注意要累加
                sum += sumOfLeftLeaves(root.left);
            }
        }
        // 如果root.left为null，就继续递归右子树
        // 检查右子树是否有左叶子节点
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

}
