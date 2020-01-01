/**
 * @program: Deli-AlgorithmEx
 * @description:编辑距离问题
 * @author: Shaobo.Qian
 * @create: 2019-12-31 07:54
 **/

package first;

public class lc_72 {

    /**
     * 动态规划：
     * dp[i][j] 代表  word1 前 i 个字符转换成 word2 前 j 个字符需要的最少步数
     * <p>
     * 所以，
     * <p>
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；,由于遍历到了i和j,说明word1的0~i-1和word2的0~j-1的匹配结果已经生成,由于当前两个字符相同,因此无需做任何操作,dp[i][j]=dp[i-1][j-1]
     * <p>
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * <p>
     * 其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。
     * <p>
     * 从以下的解释中可以看出来 dp 保存的就是每一步的最优解
     * ====解释一(dp[i][j] 代表  word1 前 i 个字符转换成 word2 前 j 个字符需要的最少步数)
     * 因为题意要求从word1到word2，word是可变的，word2是不可变的。
     * dp[i][j] = dp[i-1][j-1] +1；代表此时 word1的前i-1个字符和 word2的前 j-1个字符已经完全匹配了,只需要将 word1最后一个字符替换成 word2的最后一个字符
     * dp[i][j]=dp[i-1][j]+1; 表示当前word1[i]与word2[j]是不匹配的，那我去找下word1[i-1]与word2[j]匹配的情况，如果该情况下最小(说明此时word1的前i-1个字符就已经合 word2到前 j 个字符完全匹配了)，那就删除当前的word1[i]。(即 dp[i][j]可能是由dp[i-1][j]这种情况转换过来的)
     * dp[i][j]=dp[i][j-1]+1;表示我去看看word1[i]与word2[j-1]的匹配情况，如果匹配的结果是最小的(说明此时 word1的前 i 个字符和 word2的前 j-1个字符完全匹配了)，那就增加一个word1[i+1] == word2[j]就行了,即增加 word2[j](即 dp[i][j]可能是由dp[i][j-1]这种情况转换过来的)。
     * <p>
     * ======解释二(dp[i][j] 代表  word1 前 i 个字符转换成 word2 前 j 个字符需要的最少步数)
     * <p>
     * 对“dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。”的补充理解：
     * <p>
     * 以 word1 为 "horse"，word2 为 "ros"，且 dp[5][3] 为例，即要将 word1的前 5 个字符转换为 word2的前 3 个字符，也就是将 horse 转换为 ros，因此有：
     * <p>
     * (1) dp[i-1][j-1]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 2 个字符 ro，然后将第五个字符 word1[4]（因为下标基数以 0 开始） 由 e 替换为 s（即替换为 word2 的第三个字符，word2[2],即 word1[i]-->word2[j]）
     * <p>
     * (2) dp[i][j-1]，即先将 word1 的前 5 个字符 horse 转换为 word2 的前 2 个字符 ro，然后在末尾补充一个 s，即插入操作
     * <p>
     * (3) dp[i-1][j]，即先将 word1 的前 4 个字符 hors 转换为 word2 的前 3 个字符 ros，然后删除 word1 的第 5 个字符
     */

    /**
     * 自底向上
     * @author Shaobo.Qian
     * @date 2019/12/31
     * @link https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        //1.处理 base Case
        //1.1初始化第一行(第一行，是 word1 为空变成 word2 最少步数，就是插入操作)
        for (int j = 1; j <= n2 ; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        //1.2(第一列，是 word2 为空，需要的最少步数，就是删除操作)
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                //当word1[i]==word2[j]时,由于遍历到了i和j,说明word1的0~i-1和word2的0~j-1的匹配结果已经生成,由于当前两个字符相同,因此无需做任何操作,dp[i][j]=dp[i-1][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] ;
                } else {
                    //当word1[i]!=word2[j]时,可以进行的操作有3个:
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[n1][n2];
    }
}
