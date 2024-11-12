package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 易错点：在进入内层循环之前，一定要提前保存当前层的节点数量（levelSize = queue.size()），
 * 根据这个固定的大小进行循环，否则会影响本层节点的遍历！！
 */
public class BTLevelOrder_102 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class solution{
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()){
                // 正确写法：先用变量保存当前层的节点数量，固定住
                int levelSize = q.size();
                List<Integer> list = new ArrayList<>();
//                for (int i = 0; i < q.size(); i++) { ，错误写法
                // q.size()会随着q.offer()不断增加，导致循环出错
                for(int i = 0; i < levelSize; i++){
                    TreeNode cur = q.poll();
                    list.add(cur.val);
                    if(cur.left != null) q.offer(cur.left);
                    if(cur.right != null) q.offer(cur.right);
                }
                res.add(list);
            }
            return res;
        }
    }
}
