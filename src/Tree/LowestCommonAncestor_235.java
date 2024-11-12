package Tree;

//Given a binary search tree (BST),
// find the lowest common ancestor (LCA) node of two given nodes in the BST.
public class LowestCommonAncestor_235 {
    public TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        //iteration
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }
            else break;
        }
        return root;
    }

    public TreeNode solution2(TreeNode root, TreeNode p, TreeNode q) {
        //recursion
        int x = root.val;
        if (p.val < x && q.val < x) return solution2(root.left,p,q);
        if (p.val > x && q.val > x) return solution2(root.right,p,q);
        return root;
    }
}
