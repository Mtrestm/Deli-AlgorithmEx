/**
 * @program: Deli-AlgorithmEx
 * @description: 连续子数组的最大和
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:33
 **/

package first;

public class jz_42 {

    /**
     * anki
     * @question:
     * 1.状态如何定义?(通常状态如何定义?)
     * 2.转移方程是什么?
     * 3.如何进行一次成功的状态转移?
     * 4.如何画出 dp 的整个过程?
     * dp
     *
     * @author Shaobo.Qian
     * @date 2020/5/3
     * @link https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/solution/mian-shi-ti-42-lian-xu-zi-shu-zu-de-zui-da-he-do-2/
     */
    public int maxSubArray(int[] nums) {
        //设动态规划列表dp,dp[i]代表以元素 nums[i]结尾的连续子数组最大和
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return  res;
    }
}
