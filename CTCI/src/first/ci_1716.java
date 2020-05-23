/**
 * @program: Deli-AlgorithmEx
 * @description: 按摩师
 * @author: Shaobo.Qian
 * @create: 2020-03-24 16:05
 **/

package first;

public class ci_1716 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int res = massage(nums);
        System.out.println("res = " + res);
    }

    /**
     * dp (循环+记忆化) ===>优化空间:当前状态只跟相邻的状态有关
     *
     * @author Shaobo.Qian
     * @date 2020/3/24
     */
    public static int massage(int[] nums) {
        //[2,7,9,3,1] ====>12
        //1.状态  选n,不选n
        //2.状态转移
        //a(n) = Math.max(num[i]+ a(n-2),a(n-1))
        //3. base case
        int len = nums.length;
        if (len < 1) return 0;
        int pprev = 0;
        int prev = nums[0];
        if (len == 1) return prev;
        int curr = 0;
        for (int i = 2; i <= len; i++) {
            curr = Math.max(nums[i - 1] + pprev, prev);
            pprev = prev;
            prev = curr;
        }
        return curr;
    }

    /**
     * dp (循环+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/3/24
     */
    public static int massage1(int[] nums) {
        //[2,7,9,3,1] ====>12
        //1.状态  选n,不选n
        //2.状态转移
        //a(n) = Math.max(num[i]+ a(n-2),a(n-1))
        //3. base case
        int len = nums.length;
        if (len < 1) return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[len];
    }
}
