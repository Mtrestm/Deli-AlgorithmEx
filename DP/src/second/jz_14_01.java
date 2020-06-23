/**
 * @program: Deli-AlgorithmEx
 * @description: 剪绳子
 * @author: Shaobo.Qian
 * @create: 2020-06-01 17:23
 **/

package second;

public class jz_14_01 {
    public static void main(String[] args) {
        jz_14_01 solution = new jz_14_01();
        int res = solution.cuttingRope(10);
        System.out.println("res = " + res);
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int cuttingRope(int n) {
        //1.状态变量: 绳子长度 n; 选择剪/不剪绳子
        //2.状态定义: dp[n][2]: 绳子长度为n时可以剪成的最大乘积
        //3.状态转移:

//        int[][] dp = new int[n+1][2];
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                System.out.println("i-j="+(i-j));
                System.out.println("dp = " +i + " " + dp[i]);
            }

        }
        return dp[n];
    }
}
