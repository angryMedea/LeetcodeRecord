package Tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 找树最左最下角的值：在树的最后一行找到最左边的值
 * 层序遍历是最简单的，后进后出，后进左节点，那最后一个出来的就是最左最下的左节点
 * 深度搜索需要比较深度
 */
public class FindBottomLeftTreeValue_513 {
    public int bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        // 注意这里要初始化一个node，否则不能保存最后弹出来的left节点
        TreeNode node = root;
        q.offer(root);
        while(!q.isEmpty()){
            node = q.poll();
            if(node.right != null) q.offer(node.right);
            if(node.left != null) q.offer(node.left);
        }
        return node.val;
    }

    /**
     * 递归法DFS：前序遍历，不是很懂，为什么递归到最后的节点一定是左节点？？？
     */
    int maxDepth = -1;// 用来更新最大深度
    int result = 0;// 用来保存节点的值
    public int dfs(TreeNode root){
        result = root.val;
        depth(root,0);
        return result;

    }
    void depth(TreeNode root, int deep){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(deep > maxDepth){
                result = root.val;
                maxDepth = deep;
            }
        }
        if (root.left != null) depth(root.left,deep + 1);
        if (root.right != null) depth(root.right,deep + 1);
    }
}
