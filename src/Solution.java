import java.util.Arrays;

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



        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         * @param nums int整型一维数组
         * @return int整型
         */
        public int thirdMax (int[] nums) {
            int count = 0;
            Arrays.sort(nums);
            if(nums.length == 0){
                return 0;
            }
            for (int i = nums.length; i > 0 ; i--) {
                if(nums[i] > nums[i-1]){
                    count ++;
                }
                if(count == 3){
                    return nums[i];
                }
            }
                return nums[nums.length-1];

        }
    public int maxSubArray (int[] nums) {
            int index = 0;
            int max = 0;
            for (int i = 0; i < nums.length ; i++) {
                  for (int j = i; j < nums.length ; j++) {
                     index += nums[j];
                      if(index > max){
                          max = index;
                      }
                  }
            }
        return max;
    }
}