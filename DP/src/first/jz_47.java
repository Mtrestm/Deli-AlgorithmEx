/**
 * @program: Deli-AlgorithmEx
 * @description: 礼物的最大价值
 * @author: Shaobo.Qian
 * @create: 2020-06-02 10:23
 **/

package first;

public class jz_47 {

    /**
     * dp(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int maxValue(int[][] grid) {
        //1.状态变量: row,col
        //2.状态定义dp[row][col] :走到[row,col] 能拿到的最大价值礼物
        //3.状态转换: dp[row][col] = Math.min(dp[row-1][col],dp[row][col-1]+grid[row][col])
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        //base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
