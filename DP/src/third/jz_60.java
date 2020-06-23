/**
 * @program: Deli-AlgorithmEx
 * @description: n个骰子的点数
 * @author: Shaobo.Qian
 * @create: 2020-06-04 14:56
 **/

package third;

public class jz_60 {
    /**
     * @author Shaobo.Qian
     * @date 2020/6/4
     */
    public double[] twoSum(int n) {
        //状态变量: 1.骰子的个数n 2.投掷 n 个骰子的点数和 s 3.点数面值 curr
        //状态定义 dp[n][s]: 投掷 n 个骰子点数和为 s的次数

        int[][] dp = new int[n + 1][6 * n + 1];
        //base case : 只有一个骰子的情况(每种点数只会出现一次)
        for (int s = 1; s <= 6; s++) {
            dp[1][s] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int s = i; s <= 6 * i; s++) {
                for (int curr = 1; curr <= 6; curr++) {
                    if (s - curr <= 0) //s-curr:点数和不可能为0
                        break;
                    //转移方程:
                    dp[i][s] += dp[i - 1][s - curr];
                }
            }
        }
        //总共的可能性
        double total = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        //计算所有点数和出现的概率
        for (int s = n; s <= 6 * n; s++) {
            res[s - n] = dp[n][s] / total;
        }
        return res;
    }
}
