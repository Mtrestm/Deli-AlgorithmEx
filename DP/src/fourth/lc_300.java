/**
 * @program: DeliAlgorithmEx
 * @description: 最长上升子序列
 * @author: Shaobo.Qian
 * @create: 2020-06-05 12:49
 **/

package fourth;

import java.util.Arrays;

public class lc_300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        lc_300 solution = new lc_300();
        int res = solution.lengthOfLIS(nums);
        System.out.println("res = " + res);
    }

    /**
     *dp (自顶向下+记忆化)
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public int lengthOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len]; //dp[i]:以 nums[i]结尾的最长上升子序列
//        dp[0] = 1;
        Arrays.fill(dp, 1);
        int res = 1;
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                //转移
                if (nums[r] > nums[l]) {
                    dp[r] = Math.max(dp[r], dp[l] + 1);
                    System.out.println("r, dp = "+r +" " + dp[r]);
                }
            }
            res = Math.max(res, dp[r]);
        }
        return res;
    }
}
