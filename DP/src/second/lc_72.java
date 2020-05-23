/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-15 08:37
 **/

package second;

public class lc_72 {
    /**
     * DP(自底向上+记忆化)
     * @author Shaobo.Qian
     * @date 2020/4/6
     */
    public int minDistance(String word1, String word2) {
        //1.定义状态 dp[i][j] (word1,word2是两种不同的状态)
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        //2.base case
        //第一行( 对应的状态:word1长度为空,word2长度为 j,对应的操作是新增)
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        //第一列(对应的状态:word1长度为i,word2长度为空,对应的操作是删除 )
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        //3.状态转移方程
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //dp[i - 1][j]: word1删除第i 个字符,dp[i][j - 1]删除:word2删除第 j 个字符; dp[i - 1][j - 1])是将 word1第 i 个字符替换为word2第 j 个字符
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
