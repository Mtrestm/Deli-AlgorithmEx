/**
 * @program: Deli-AlgorithmEx
 * @description: 硬币
 * @author: Shaobo.Qian
 * @create: 2020-04-23 07:28
 **/

package first;

public class ctci_0811 {
    public static void main(String[] args) {
        int res = waysToChange(10);
        System.out.println("res = " + res);
    }

    /**
     * todo
     * @Question: 1.有哪两种状态? 2.dp 数组如何定义,表达的含义是什么  3.状态如何转移? 4.base case 如何定义? 5.状态转移方程?
     * @author Shaobo.Qian
     * @date 2020/4/23
     */
    public static int waysToChange(int n) {
        //有哪两种状态 1:有多少种硬币可以选 2:要组成的金额的数目是多少
        //状态：dp[i][j]表示[0...i]种硬币能组合为j的
        int[][] dp = new int[4][n + 1];
        int[] coins = {1, 5, 10, 25};
        //base case
        // 当只有一种硬币时，只有1种表示法
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }
        // 当数量为0，1时，有1种表示法
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        //状态如何转移(状态转移：取 或 不取 当前硬币coins[i])
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                //金额大于第i+1种硬币的面值
                if (j >= coins[i]) {
                    //i种硬币组成金额 j的所有不同种数 = (取:当前第i+1种硬币用到了)然后要考虑i种硬币组成金额 j- coins[i]的所有不同种数 + (不取:当前第i+1种硬币没有用到)然后要考虑i-1种硬币组成金额所有不同种数
                    dp[i][j] = (dp[i][j - coins[i]] + dp[i - 1][j]) % 1000000007;
                } else {
                    //金额小于第i+1种硬币的面值,当前第 i+1种硬币就没法取了,只能选择不取的情况进行转移(不取第 i+1枚硬币,还有前面i枚可以取)
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        //dp[3][n]表示[0...3]4种硬币能组合为n的所有可能
        return dp[3][n];
    }

   /* static Map<Integer, Integer> map = new HashMap<>();

    public static int waysToChange(int n) {
        //状态: 25 , 10 , 5 , 1
        //F(N) = (F(N-25)+F(N-10)+F(N-5)+F(N-1))

        return dfs(n);
    }

    private static int dfs(int n) {
        //terminator
        if (map.containsKey(n))
            return map.get(n);
        if (n < 0)
            return 0;
        if (n<=1)
            return n;

        //drill down
        int res = (dfs(n - 1)+dfs(n - 25) + dfs(n - 10) + dfs(n - 5)  % 1000000007);
        //current level
        map.put(n, res);
        return res;
    }*/
}
