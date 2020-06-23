/**
 * @program: Deli-AlgorithmEx
 * @description: 连续子数组的最大和
 * @author: Shaobo.Qian
 * @create: 2020-06-03 18:40
 **/

package second;

public class jz_42 {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {1, 2};
        jz_42 solution = new jz_42();
        int res = solution.maxSubArray(nums);
        System.out.println("res = " + res);
    }
    /**
     *
     * @author Shaobo.Qian
     * @date 2020/6/3
     */
    public int maxSubArray(int[] nums) {
        //状态定义:dp[i]: 以num[i]结尾的连续子数组最大和
        int len = nums.length;
        int[] dp = new int[len];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            //转移
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
