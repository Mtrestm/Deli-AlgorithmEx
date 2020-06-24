package third;

public class lc_72 {
    /**
     * dp(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public int minDistance(String word1, String word2) {

        //1.状态变量 word1(i),word2(j);变换范围:
        //2.dp[i][j]: 将 word1前 i 个字符 转换为 word2前 j 个字符所需要的最少操作次数
        //3.进行一次状态转移: 插入,删除,替换
        //4.转移方程: dp[i][j] = Math.min(Math.min(dp[i-1][j]dp[i-1],[j-1]),dp[i][j-1])
        //5.base case
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //base case
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }

}
