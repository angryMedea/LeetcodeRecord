package Tree;

/**
 * 普通二叉树：后序遍历，O(n)，时间复杂度不符合要求
 * 完全二叉树：后序遍历，时间复杂度为O(logN * logN)，很抽象的时间复杂度😒
 */
public class CountTreeNodes_222 {
    /**
     * 当做一颗普通的二叉树
     * @param root 根节点
     * @return 节点数量
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        int result = left + right + 1;
        return result;
    }

    /**
     * 根据完全二叉树的特性，判断子树是否为满二叉树
     * 如果是满二叉树，直接利用公式【节点数量 = 2^n - 1(n为树的高度)】
     * 然后保存数量return到上一层终止循环
     * @param root 根节点
     * @return 节点数量
     */
    public int countNodesComplete(TreeNode root){
        // 两个终止条件：
        // 1. root == null
        // 2. 子树为满二叉树
        if(root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDepth = 0, rightDepth = 0;
        while(left != null){
            left = left.left;
            leftDepth++;
        }
        while(right != null){
            right = right.right;
            rightDepth++;
        }
        // 注意这里位运算
        // 1 << 1 等于 2，即 2^1
        // 1 << 2 等于 4，即 2^2
        // 1 << (leftDepth + 1) 实际上就是计算 2^(leftDepth + 1)。
        // 当 leftDepth == 0，return 1，就是说左右子树都为null，直接终止程序返回1，也就是只有一个root
        if(leftDepth == rightDepth) return 1 << (leftDepth + 1) - 1;

        // 终止条件写完，开始递归
        int leftNum = countNodesComplete(root.left);
        int rightNum = countNodesComplete(root.right);
        int result = leftNum + rightNum + 1;
        return result;
    }

}
