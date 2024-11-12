package Tree;

public class InvertBinaryTree_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null),
                new TreeNode(3, null, null)),
                new TreeNode(7, new TreeNode(6, null, null),
                        new TreeNode(9, null, null)));
        InvertBinaryTree_226 invert = new InvertBinaryTree_226();
        System.out.println(invert.solution(root));

    }

    //自底向上
    //从最低的左右子树开始翻转，翻转完所有子树之后交换top根节点的左右子树
    public TreeNode solution(TreeNode root){
        if(root == null) return null;
        solution(root.left);
        solution(root.right);

        //后续遍历，把交换的代码放在递归之后，属于后续遍历
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        // 注意要先用变量固定住sub tree，否则反转完左子树之后，左子树就被改变了
        // 此时再反转右子树就会出错
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

}
