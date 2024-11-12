package Tree;

public class DiameterOfBinaryTree_543 {
    class Solution {
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return ans;
        }

        int dfs(TreeNode u){
            if(u == null) return 0;
            int l = dfs(u.left);//左子树的高度
            int r = dfs(u.right);//右子树的高度
            ans = Math.max(ans,l + r);// 直径 = 左子树+左子树，求其中的最大值
            return Math.max(l,r) + 1;//返回的子树的高度
        }
    }
}
