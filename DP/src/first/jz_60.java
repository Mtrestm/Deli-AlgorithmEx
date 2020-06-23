/**
 * @program: Deli-AlgorithmEx
 * @description: n 个骰子的点数
 * @author: Shaobo.Qian
 * @create: 2020-06-01 16:53
 **/

package first;

public class jz_60 {
    /**
     * dp(自顶向下)
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public double[] twoSum(int n) {
        //1.状态变量: 骰子个数 n;n 个骰子的和 s;每个骰子的点数 cur
        //2.dp[n][s] ==>投掷 n个骰子和为s出现的次数
        int[][] dp = new int[n + 1][6 * n + 1];
        //base case(只有一枚骰子)
        for (int s = 1; s <= 6; s++) {
            dp[1][s] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (s - cur <= 0)
                        break;
                    dp[i][s] += dp[i - 1][s - cur];
                }
            }
        }
        double total = Math.pow((double) 6, (double) n);
        double[] res = new double[5 * n + 1];
        for (int s = n; s <= 6 * n; s++) {
            res[s - n] = ((double) dp[n][s]) / total;
        }
        return res;
    }
}
