/**
 * @program: Deli-AlgorithmEx
 * @description: 乘积最大子数组
 * @author: Shaobo.Qian
 * @create: 2020-06-01 19:20
 **/

package third;

public class lc_152 {

    /**
     * dp(二维+记忆化+自顶向下)
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int maxProduct0(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        // dp[i]:以 nums[i] 字符结尾的
        int[][] dp = new int[len][2];
        //base case
        dp[0][0] = nums[0];//最小值
        dp[0][1] = nums[0];//最大值
        //自定向下
        for (int i = 1; i < len; i++) {
            //(状态转移)
            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }


    /**
     * dp(降维+记忆化+自顶向下)
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int preMax = nums[0];
        int preMin = nums[0];
        int currMax;
        int currMin;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                currMax = Math.max(nums[i], preMax * nums[i]);
                currMin = Math.min(nums[i], preMin * nums[i]);
            } else {
                currMax = Math.max(nums[i], preMin * nums[i]);
                currMin = Math.min(nums[i], preMax * nums[i]);
            }
            res = Math.max(res, currMax);
            preMax = currMax;
            preMin = currMin;
        }
        return res;
    }
}
