/**
 * @program: DeliAlgorithmEx
 * @description: 乘积最大子数组
 * @author: Shaobo.Qian
 * @create: 2020-06-05 13:09
 **/

package fourth;

public class lc_152 {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        lc_152 solution = new lc_152();
        int res = solution.maxProduct(nums);
        System.out.println("res = " + res);
    }

    /**
     * dp降维(自顶向下+记忆化)
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int preMin = nums[0];
        int preMax = nums[0];

        int currMin;
        int currMax;
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                currMin = Math.min(nums[i], preMin * nums[i]);
                currMax = Math.max(nums[i], preMax * nums[i]);
            } else {
                currMin = Math.min(nums[i], preMax * nums[i]);
                currMax = Math.max(nums[i], preMin * nums[i]);
            }
            res = Math.max(res, currMax);
            preMin = currMin;
            preMax = currMax;
        }
        return res;
    }
    /**
     * dp二维+自顶向下+记忆化
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public int maxProduct0(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][2]; //dp[i][0]:以 nums[i]结尾子数组乘积的最小值; dp[i][1]:以 nums[i]结尾子数组乘积的最大值
        //base case
        dp[0][0] = nums[0];//最小值
        dp[0][1] = nums[0];//最大值
        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
            }
            res =  Math.max(res, dp[i][1]);
        }
        return res;
    }


}
