
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

    public int Add(int num1,int num2) {
        while(num2 != 0){
            int num = (num1 & num2) << 1;
            num1 = num1 ^ num2;
            num2 = num;
        }
        return num1;
    }
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        int ret = 1;
        for (int i = 0; i < length ; i++) {
            B[i] = ret;
            ret = ret * A[i];
        }
        ret = 1;
        for (int i = length -1; i >= 0 ; i--) {
            B[i] = B[i] * ret;
            ret = ret * A[i];
        }
        return B;
    }
}