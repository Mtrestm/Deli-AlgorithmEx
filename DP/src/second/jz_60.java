/**
 * @program: Deli-AlgorithmEx
 * @description: n 个骰子的点数
 * @author: Shaobo.Qian
 * @create: 2020-06-02 16:05
 **/

package second;

import java.util.Arrays;

public class jz_60 {
    public static void main(String[] args) {
        jz_60 solution = new jz_60();
        double[] res = solution.twoSum(2);
        Arrays.stream(res).forEach(System.out::println);
    }

    /**
     * dp
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public double[] twoSum(int n) {
        //状态变量 1:骰子个数 n ;2:骰子的点数和 s ;3:骰子的点数 curr ==>其中前面两个状态变量就可以描述整个 dp 过程,最后一个状态变量是用来解题的
        //状态定义: dp[n,s]: 投掷 n 个骰子点数和是 s 出现的次数
        //状态转移: dp[n,s] = dp[n-1,s-1]+dp[n-1,s-2]...+dp[n-1,s-6]

//        int[][] dp = new int[n + 1][5 * n + 1];//s:[n,6*n]
        //上面的定义有问题因为dp 定义 dp[n][s] ==>s 代表的点数和,最大是6*n
        int[][] dp = new int[n + 1][6 * n + 1];//s:[n,6*n]
        //base case
        for (int s = 1; s <= 6; s++) {
            dp[1][s] = 1;
        }
        for (int i = 2; i <= n; i++) {
//            for (int s = n; s <= 6 * n; s++) {
            for (int s = i; s <= 6 * i; s++) {
                for (int curr = 1; curr <= 6; curr++) {
                    if (s - curr >= 0)
                        dp[i][s] += dp[i - 1][s - curr];
//                    if (s - curr <= 0)
//                        break;
                    dp[i][s] += dp[i - 1][s - curr];
                }
            }
        }
        double[] res = new double[5 * n + 1];
        double total = Math.pow(6, n);
        for (int s = n; s <= 6 * n; s++) {
            res[s - n] = dp[n][s] / total;
        }
        return res;
    }
}
