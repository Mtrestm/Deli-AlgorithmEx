/**
 * @program: Deli-AlgorithmEx
 * @description: 买卖股票的最佳时机
 * @author: Shaobo.Qian
 * @create: 2020-06-01 11:39
 **/

package second;

public class lc_121 {
    public static void main(String[] args) {
        lc_121 solution = new lc_121();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = solution.maxProfit(prices);
        System.out.println("res = " + res);
    }
    /**
     * dp 降维
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;
        int i_0 = 0; //第一天不持有
        int i_1 = -prices[0]; //第一天持有

        for (int i = 1; i < len; i++) {
            i_0 = Math.max(i_0, i_1 + prices[i]);
            i_1 = Math.max(i_1, 0 - prices[i]);
        }
        return i_0;
    }

    /**
     * 自解
     * dp +二维
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int maxProfit0(int[] prices) {
        //1.状态变量: 天数 i (i<prices.len);交易状态(买入,卖出)
        //2.dp[n]: 第 n 天卖出时的收益
        //3.
        int len = prices.length;
        int[][] dp = new int[len + 1][2];
        //base case
        dp[0][0] = 0;//第0天不持有
        dp[0][1] = Integer.MIN_VALUE;//第0天持有
        for (int i = 1; i < len + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
//            dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
//            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i - 1]);
        }

        return dp[len][0];
    }
}
