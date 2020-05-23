/**
 * @program: Deli-AlgorithmEx
 * @description: 乘积最大子数组
 * @author: Shaobo.Qian
 * @create: 2020-05-18 07:06
 **/

package first;

public class lc_152 {
    /**
     * // 已入anki
     * @link:https://leetcode-cn.com/problems/maximum-product-subarray/solution/dong-tai-gui-hua-li-jie-wu-hou-xiao-xing-by-liweiw/
     * @question:
     * 0.什么是无后效性?
     * 1.有哪些状态变量?
     * 2.dp如何定义?一维还是二维?表达的含义?
     * 3.base case 如何初始化?
     * 4.如何进行一次状态转移?
     * 5.如何优化(进行降维)
     * @author Shaobo.Qian
     * @date 2020/5/18
     */
    //二维
    public int maxProduct1(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int[][] dp = new int[len][2];
        // dp[i][0]：以 nums[i] 结尾的连续子数组的最小值
        // dp[i][1]：以 nums[i] 结尾的连续子数组的最大值
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
            } else {
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
            }
        }

        // 只关心最大值，需要遍历
        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;

    }
    //降维
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len==0)
            return 0;

        //base case
        int preMax = nums[0];
        int preMin = nums[0];


        //滚动变量
        int currMax;
        int currMin;
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                currMax = Math.max(nums[i] * preMax, nums[i]);
                currMin = Math.min(nums[i] * preMin, nums[i]);
            } else {
                currMax = Math.max(nums[i] * preMin, nums[i]);
                currMin = Math.min(nums[i] * preMax, nums[i]);
            }
            res = Math.max(res, currMax);
            preMax = currMax;
            preMin = currMin;
        }
        return res;
    }

}
