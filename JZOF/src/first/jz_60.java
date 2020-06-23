/**
 * @program: Deli-AlgorithmEx
 * @description: n个骰子的点数
 * @author: Shaobo.Qian
 * @create: 2020-05-07 06:52
 **/

package first;

public class jz_60 {
    /**
     * anki
     * @link:https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/dong-tai-gui-hua-by-shy-14/
     * @link: https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/solution/nge-tou-zi-de-dian-shu-dong-tai-gui-hua-ji-qi-yo-3/
     * @question
     * 0.每一种结果和的概率应该如何算?
     * 1.有哪3个状态变量
     * 2.状态变量的变化范围
     * 3.dp 状态的含义? base case 如何初始化?
     * 4.如何进行一次状态转移?
     * 5.状态转移方程
     * 6.如何画图 dp 的整个过程
     * @author Shaobo.Qian
     * @date 2020/5/7
     */
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        //base case :初始化 n=1的情况
        for (int s = 1; s <= 6; s++) {
            dp[1][s] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                for (int cur = 1; cur <= 6; cur++) {
                    if (s - cur <= 0) //已经为0了,后面的不用加了
                        break;
                    dp[i][s] += dp[i - 1][s - cur];
                }
            }
        }

        double total = Math.pow((double) 6, (double) n);
        double[] ans = new double[5 * n + 1];

        for (int i = n; i <= 6 * n; i++) {
            ans[i - n] = ((double) dp[n][i]) / total;
        }
        return ans;
    }
}
