package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 1.终止条件：
 *  左子树&&右子树都为空，终止
 *  根节点为空，终止
 * 2.递归逻辑：前序遍历
 */
public class BinaryTreePaths_257 {
    void dfs(TreeNode root, List<String> list, String sb){
        //终止条件2
        if(root == null) return;
        // 路径收集节点的代码要放在终止条件上面，否则子树为空的话就无法收集了
        sb += (root.val);
        // 终止条件1
        if(root.left == null && root.right == null){
            list.add(sb);
            return;
        }
        dfs(root.left,list,sb+"->");
        dfs(root.right,list,sb+"->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root,list,"");
        return list;
    }
}
