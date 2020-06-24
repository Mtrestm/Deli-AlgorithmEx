/**
 * @program: Deli-AlgorithmEx
 * @description: 最长上升子序列
 * @author: Shaobo.Qian
 * @create: 2020-06-02 17:37
 **/

package third;

import java.util.Arrays;

public class lc_300 {
    public static void main(String[] args) {
        lc_300 solution = new lc_300();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int res = solution.lengthOfLIS0(nums);
        System.out.println("res = " + res);
    }
    public int lengthOfLIS0(int[] nums) {
        int len = nums.length;
        if (len<=1)
            return len;
        int[] dp = new int[len];//以 nums[i]结尾的最长子序列长度
        Arrays.fill(dp, 1);
        int res = 0;
        for (int r = 0; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (nums[l]<nums[r])//满足nums[l]<nums[r],说明 num[r]可以延迟以 num[l]结尾的子序列的长度
                    dp[r] = Math.max(dp[r], dp[l] + 1);
            }
            res = Math.max(res, dp[r]);
        }
        return res;
    }
}
