//package Tree;
//
///**
// * 【根据中序遍历和后序遍历构建二叉树】- 思路：
// * 1. 后序数组长度为0，空节点
// * 2. 后续数组最后一个元素为节点元素【左右中，节点元素在最后】
// * 3. 寻找中序数组位置作切割点
// * 4. 切中序数组
// * 5. 切后序数组
// * 6. 递归处理左区间右区间
// */
//public class ConstructTreeFromInAndPost_106 {
//    public TreeNode buildTree(int[] inorder,int[] postorder){
//        if(postorder.length == 0) return null;
//        int rootVal = postorder[postorder.length - 1];
//        TreeNode root = new TreeNode(rootVal);
//        if(postorder.length == 1) return root;
//
//        for (int i = 0; i < inorder.length; i++) {
//            if(inorder[i] == rootVal) break;
//        }
//    }
//}
