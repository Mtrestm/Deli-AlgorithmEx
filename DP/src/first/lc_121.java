/**
 * @program: Deli-AlgorithmEx
 * @description: 买卖股票的最佳时机
 * @author: Shaobo.Qian
 * @create: 2020-03-10 07:23
 **/

package first;

public class lc_121 {
    /**
     * @question: 1.股票问题的状态如何定义, 通过哪种思路来定义? 2.股票问题的状态如何转义? 股票问题的base case 如何定义?最终状态有哪两种?状态转移方程是怎样的? 3. 第一道股票问题,k=1(交易次数),这种情况下base case 是怎样的? 状态转移方程如何优化的 ==> 得出真正对结果有影响的状态和状态转移方程的?
     * @author Shaobo.Qian
     * @date 2020/3/10
     * @link https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-l-3/
     */
    public int maxProfit(int[] prices) {
        //三个状态:i是第几天,k是到目前为止发生的交易次数,最后一个状态s:(0:不持有股票 ,1:持有股票)

        //1.该题限制了k=1,套用公式,得出的状态转移方程
        //最终状态有两种情况: dp[i][1][0] 最后一天,完成了一次交易,卖出股票 //dp[i][1][1] 最后一天了,目前为止完成了一次交易,手上扔持有的股票没有卖出
        //dp[i][1][0] = max(dp[i-1][1][0],dp[i-1][1][1] + price[i])
        //dp[i][1][1] = max(dp[i-1][1][1],dp[i-1][0][0] - price[i])
        //            = max(dp[i-1][1][1],-price[i])
        //解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。
        //现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
        //可以进行进一步化简去掉所有 k：
        //dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = max(dp[i-1][1], -prices[i])
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[-1][k][0] = 0
        //解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
        //dp[-1][k][1] = -infinity
        //解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
        //dp[i][0][0] = 0
        //解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
        //dp[i][0][1] = -infinity
        //解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。

        // base case(第0天的情况): dp[-1][0] = 0, dp[-1][1] = -infinity
        //由 base case==>(第一天)的情况:(数组坐标第一天 i == 0)
        dp[0][0] = 0;
        //// 解释：
        // dp[0][0]   = max(dp[-1][0], dp[-1][1] + prices[i])
        //            = max(0, -infinity + prices[i]) = 0

        dp[0][1] = -prices[0];
        //解释：
        //   dp[i][1] = max(dp[-1][1], dp[-1][0] - prices[i])
        //            = max(-infinity, 0 - prices[i])
        //            = -prices[i]
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 优化
     * @question 限制k=1 的情况空间上如何降维? 注意一下状态转移方程，新状态只和相邻的一个状态有关，其实不用整个 dp 数组，只需要一个变量储存相邻的那个状态就足够了，这样可以把空间复杂度降到 O(1):
     *             dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); ==>dp[i][0] 和 dp[i - 1][1]肯定相等
     *             dp[i][1] = Math.max(dp[i - 1][1], 0 - prices[i]); ==> dp[i][1] 和 dp[i - 1][1]肯定相等
     *            新的状态转移方程 ==>dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
     *                              dp_i_1 = Math.max(dp_i_1, -prices[i]);
     * @author Shaobo.Qian
     * @date 2020/3/10
     */
    int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

}
