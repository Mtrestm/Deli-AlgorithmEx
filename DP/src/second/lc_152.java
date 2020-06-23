/**
 * @program: Deli-AlgorithmEx
 * @description: 乘积最大子数组
 * @author: Shaobo.Qian
 * @create: 2020-06-01 07:21
 **/

package second;

public class lc_152 {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int preMax = nums[0];
        int preMin = nums[0];
        int currMax;
        int currMin;
        int max = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                currMax = Math.max(nums[i], preMax * nums[i]);
                currMin = Math.min(nums[i], preMin * nums[i]);
            } else {
                currMax = Math.max(nums[i], preMin * nums[i]);
                currMin = Math.min(nums[i], preMax * nums[i]);
            }
            max = Math.max(max, currMax);
            preMax = currMax;
            preMin = currMin;
        }
        return max;
    }
    /**
     * dp(二维)
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int maxProduct1(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = nums[0];//最小值
        dp[0][1] = nums[0];//最大值

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
            } else {
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
            }

        }
        int max = dp[0][1];
        for (int i = 1; i < len; i++) {
            max = Math.max(max, dp[i][1]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        lc_152 solution = new lc_152();
//        int max = solution.maxProduct(nums);
//        System.out.println("max = " + max);// ===> max = 有后效性问题结果 24

    }

    /**
     * dp(未解除,这里有后效性问题)
     *
     * @question 1.为什么我的解法存在后效性问题?(1.dp定义的不具体,2.无后效性一定要比较当前值 num[i],而且无后效行只要考虑当前的值和前一个 dp 结果)
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int maxProduct0(int[] nums) {
        //1.状态变量:数组索引,元素正负性: (max,min)
        //2.dp[i] : nums 数组中前i个元素的最大乘积
        //3.状态转移: 3.1:num[i]>0 3.2:nums[i]<0
        //4.转移方程: if(nums[i]>=0) max = Math.max(max*nums[i],nums[i]) ; min = Math.min(min*nums[i],min);
        //           if(nums[i]<0) max = Math.max(max,nums[i]*min); min = Math.max(max*nums[i],min);

        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                max = Math.max(max * nums[i], nums[i]);
                min = Math.min(min * nums[i], min);
            } else {
                max = Math.max(max, nums[i] * min);
                min = Math.max(max * nums[i], min);
            }
        }
        return max;
    }
}
