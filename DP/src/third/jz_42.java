/**
 * @program: DeliAlgorithmEx
 * @description: 连续子数组的最大和
 * @author: Shaobo.Qian
 * @create: 2020-06-06 17:46
 **/

package third;

public class jz_42 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        jz_42 solution = new jz_42();
        int res = solution.maxSubArray(nums);
        System.out.println("res = " + res);
    }

    /**
     * dp(自顶向下+记忆化)
     * @author Shaobo.Qian
     * @date 2020/6/6
     */
    public int maxSubArray0(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        //状态定义
        int[] dp = new int[len];//以 nums[i]结尾的子数组的最大和
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    /**
     * dp降维
     * @author Shaobo.Qian
     * @date 2020/6/6
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        int i_0 = nums[0];
        for (int i = 1; i < len; i++) {
            int i_1 = i_0 >= 0 ? i_0 + nums[i] : nums[i];
            res = Math.max(res, i_1);
            i_0 = i_1;
        }
        return res;
    }
}
