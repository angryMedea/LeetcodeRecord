package Tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(solution2(root));

    }

    public static List<Integer> solution(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(res,root);
        return res;
    }

    /**
     * Depth First Search 深度优先搜索 + 递归
     * @param res 存储val值的list集合，可以使用add方法加入列表
     * @param root 原始的二叉树
     */
    static void dfs(List<Integer> res, TreeNode root){
        if(root == null) return;
        dfs(res,root.left);
        res.add(root.val);
        dfs(res,root.right);
    }

    /**
     * 迭代法：利用栈来模拟递归
     * @param root
     * @return
     *
     * 注意：中序遍历的顺序是 左+根+右
     *      所以出栈顺序也是 左+根+右
     *      因此入栈顺序就是 右+根+左
     */
    public static List<Integer> solution2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Stack<Object> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Object obj = stack.pop();
            //instanceof关键字判断是否属于TreeNode类
            if (obj instanceof TreeNode){
                TreeNode node = (TreeNode)obj;
                if (node.right != null) stack.push(node.right);
                stack.push(node.val);
                if (node.left != null) stack.push(node.left);
            }else{
                res.add((Integer)obj);
            }
        }

        return res;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
