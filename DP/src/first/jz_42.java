/**
 * @program: Deli-AlgorithmEx
 * @description: 连续子数组的最大和
 * @author: Shaobo.Qian
 * @create: 2020-06-02 11:18
 **/

package first;

public class jz_42 {

    public static void main(String[] args) {
        jz_42 solution = new jz_42();
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {1, 2};
        int res = solution.maxSubArray(nums);
        System.out.println("res = " + res);
    }
    public int maxSubArray(int[] nums) {
        //1.状态变量 i:数组的索引
        //2.状态定义: dp[i]:以 nums[i]结尾的最大连续子数组的和
        //3.状态转化: dp[i-1]>=0:对结果有价值,保留 dp[i] = dp[i-1]+nums[i]
        //           dp[i-1]<0:对结果无价值,舍弃 dp[i] = nums[i]
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            if (dp[i-1]>=0)
                dp[i] = dp[i - 1] + nums[i];
            else
                dp[i] = nums[i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
