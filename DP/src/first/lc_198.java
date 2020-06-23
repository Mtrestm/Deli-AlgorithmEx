/**
 * @program: Deli-AlgorithmEx
 * @description: 打家劫舍
 * @author: Shaobo.Qian
 * @create: 2020-05-30 11:12
 **/

package first;

public class lc_198 {

    /**
     * dp(自顶向下+记忆化)
     *
     * @question: 1.
     * @author Shaobo.Qian
     * @date 2020/5/30
     */
    public int rob(int[] nums) {
        //状态遍历: 1.第几间房 2.偷/不偷
        //状态定义: dp[n] = 遍历到第 n 间房子,偷窃到的最高金额
        //状态转换: n不偷: dp[n] = dp[n-1] ;
        //         n偷 : dp[n] = nums[n-1] + dp[n-2]
        //状态转移方程:   dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        //base case:dp[0] = 0;
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[len];
    }
}
