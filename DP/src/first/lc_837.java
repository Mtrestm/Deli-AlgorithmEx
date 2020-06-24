package first;

/**
 * @program: Deli-AlgorithmEx
 * @description: 新21点
 * @author: Shaobo.Qian
 * @create: 2020-06-03 06:39
 **/

public class lc_837 {
    /**
     * dp(自底向上)
     *
     * @question: 0.请画图说明转移的过程?
     * 1.状态变量有哪两个?状态变量的变换范围?
     * 2.状态定义?
     * 3.状态如何转移?转移方程怎么用数学公式写?
     * 4.base case 如何初始化,(注意:这里的初始化范围是多大,初始化的值为多少)
     * 5.为什么需要优化?
     * 6.优化后的转移方程如何得出?(利用相邻项计算差分,推导出来)-->请写公式推导出来
     * 7.优化后的转移方程在转移之前为什么需要新增初始化 dp[K-1]?以及如何初始化?
     * 0.最大能达到的分数是多大? (K+W-1)
     * 1.dp 数组的空间申请为多大?
     * @author Shaobo.Qian
     * @date 2020/6/3
     * https://leetcode-cn.com/problems/new-21-game/solution/xin-21dian-by-leetcode-solution/
     */
    public double new21Game(int N, int K, int W) {
        //状态变量 1:当前所拥有的分数 i ; 2:下次可能抽到的分数 j (1<=j<=W)
        //K==0 抽不了卡,分数为0 <=N
        if (K == 0)
            return 1.0;
        //状态定义: 令dp[x]表示从得分为x的情况开始游戏并且获胜的概率,目标是求dp[0]的值。
        double[] dp = new double[K + W + 1];
        //base case
        for (int i = K; i <= N && i < K + W; i++) {
            //dp[i]分数 i 在i <= N && i < K + W 这个范围内无法继续抽卡,所以最终分数肯定i <= N  (推导出概率为1,百分百获胜)
            dp[i] = 1.0;
        }
        //初始化 dp[K-1]; 只有当K≤x≤min(N,K+W-1)时才有dp[x]=1
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W;

        //自底向上,进行dp
        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        }
        return dp[0];
    }

    /**
     * 未优化
     *
     * @author Shaobo.Qian
     * @date 2020/6/3
     */
    public double new21Game0(int N, int K, int W) {
        //状态变量 1:当前所拥有的分数 i ; 2:下次可能抽到的分数 j (1<=j<=W)
        //K==0 抽不了卡,分数为0 <=N
        if (K == 0)
            return 1.0;
        //状态定义: 令dp[x]表示从得分为x的情况开始游戏并且获胜的概率,目标是求dp[0]的值。
        double[] dp = new double[K + W + 1];
        //base case
        for (int i = K; i <= N && i < K + W; i++) {
            //dp[i]分数 i 在i <= N && i < K + W 这个范围内无法继续抽卡,所以最终分数肯定i <= N  (推导出概率为1,百分百获胜)
            dp[i] = 1.0;
        }
        //自底向上,进行dp
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j] / W;
            }
        }
        return dp[0];
    }


    /**
     * @author Shaobo.Qian
     * @date 2020/6/3
     * https://leetcode-cn.com/problems/new-21-game/solution/javani-xiang-dong-tai-gui-hua-jie-jue-shuang-100-b/
     */
    public double new21Game2(int N, int K, int W) {
        //先判断 K - 1 + W 是否在 N 的里面，如果在的话，说明肯定能赢得游戏，返回 1.0，也就是 100%
        //因为最大分数是 K-1+W,如果最大分数还小于 N 稳赢
        if (K - 1 + W <= N)
            return 1.0;

        //dp 定义:以 i 为起始分数的情况开始游戏并且获胜的概率
        double[] dp = new double[K + W]; //K+W的空间对应记录的分数是最小0...最大(K-1+W) 的分数
        
        //base case: 到这里,说明K - 1 + W>=N,所以处理 base case 时以 N 为边界
        //currAreaSum:当前要计算的分数对应的概率,后面紧接着的W个分数获胜概率和
        double currAreaSum = 0;
        // 将能赢得游戏的点数的概率设置为 1
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
            currAreaSum += dp[i];
        }
        //从 k-1开始计算
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = currAreaSum / W;
            currAreaSum = currAreaSum - dp[i + W] + dp[i]; //分数 i 进来,分数 i+W 出去
        }
        return dp[0];
    }

}
