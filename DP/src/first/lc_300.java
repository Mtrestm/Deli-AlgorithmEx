/**
 * @program: Deli-AlgorithmEx
 * @description: 最长上升子序列
 * @author: Shaobo.Qian
 * @create: 2020-03-14 10:02
 **/

package first;

import java.util.Arrays;

public class lc_300 {
    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {10, 9, 2, 5, 3, 4};
//        int[] nums = {10, 9, 3, 5, 7, 2, 101, 18};
//        int[] nums = {10, 9, 3, 5, 7, 2, 3, 1,4, 5, 101, 18};
        int maxSub = lengthOfLIS(nums);
        System.out.println("maxSub = " + maxSub);
    }


    /**
     * DP(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/3/14
     */
    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        //base case
        int[] dp = new int[len];//用来记录从数组首端到每个索引位置的最长子序列
        Arrays.fill(dp, 1);
        int res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }

    /**
     * 多个上升子序列==>最长的 (未解出)
     *
     * @author Shaobo.Qian
     * @date 2020/3/14
     */
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        //1.状态 1.数组索引 2.是否上升(0,1) 3.当前最长子序列 4.当前上升序列中的最大值
        //2.状态转移
        // currSub = a(n) = up? a(n-1)+1: 1
        // maxSub = up? Math.max(currSub,maxSub) : maxSub
        //3.base
        int[] maxList = new int[len];
        //4.记录每个索引位置的最长上升子序列
        for (int i = 0; i < len; i++) {
            int currSub = 1;
            int maxSub = 1;
            int currMax = Integer.MIN_VALUE;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] >= nums[j - 1]) {//上升
                    currSub++;
                    maxSub = Math.max(currSub, maxSub);
                } else {
                    currSub = 1;
                }
            }

            maxList[i] = currMax == nums[i] ? 1 : currSub;
        }
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            maxLen = Math.max(maxList[i], maxLen);
        }
        return maxLen;
    }
}
