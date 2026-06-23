import java.util.ArrayList;
import java.util.List;
class lc94 {
 public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
    public static void main(String[] args) {
        lc94 solution = new lc94();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result); 
    }
}