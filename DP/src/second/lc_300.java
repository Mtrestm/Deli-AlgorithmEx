/**
 * @program: Deli-AlgorithmEx
 * @description: 最长上升子序列
 * @author: Shaobo.Qian
 * @create: 2020-06-02 06:26
 **/

package second;

import java.util.Arrays;

public class lc_300 {



    /**
     * 纯dp(O(n^2))
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int lengthOfLIS0(int[] nums) {
        //1.状态变量: l,r ==>子序列的左右边界
        //2.状态定义: dp[i] ,以 nums[i] 结尾的最长上升子序列
        //3.状态转移:
        int len = nums.length;
        if (len <= 1)
            return len;

        int[] dp = new int[len];
        //base case
        Arrays.fill(dp, 1);
        int res = 0;
        for (int r = 0; r < len; r++) {
            //检查 r 结尾的元素左边所有小于 r 元素结尾的元素的最长子序列(比如r=4,即检查以0,1,2,3结尾的子序列)
            for (int l = 0; l < r; l++) {//每遍历完一次内循环,确定当前r 索引结尾的最长子序列(比如r=4,即确定了以 nums[4]结尾的最长子序列长度)
                if (nums[l] < nums[r])
                    dp[r] = Math.max(dp[r], dp[l] + 1);

            }
            res = Math.max(res, dp[r]);
        }

        return res;
    }
}
