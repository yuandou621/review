
public class Solution {

    public void swap(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        swap(root.left);
        swap(root.right);
    }
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        swap(root);
    }


    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left,right) +1;
    }
}