package Tree;

/**
 * 后序遍历！！！
 * 和104完全一样，要注意的就是有可能出现二叉树链表化，就是一边的子树没有，一边的子树巨长
 * 所以要考虑depth为0的情况
 */
public class MinDepthofBT_111 {

//     public int minDepth(TreeNode root) {
//         if(root == null) return 0;
//         int leftDepth = minDepth(root.left);
//         int rightDepth = minDepth(root.right);
//         if(leftDepth != 0 && rightDepth != 0){
//             return Math.min(leftDepth,rightDepth) + 1;
//         }else if(leftDepth != 0){
//             return leftDepth + 1;
//         }else if(rightDepth != 0){
//             return rightDepth + 1;
//         }else
//             return 1;

//     }



        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            if (leftDepth == 0 || rightDepth == 0) {
                return leftDepth + rightDepth + 1;  // If one subtree is empty, return the depth of the non-empty one + 1.
            }
            return Math.min(leftDepth, rightDepth) + 1;  // If both subtrees exist, return the smaller depth + 1.
        }
    }

