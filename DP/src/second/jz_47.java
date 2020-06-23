/**
 * @program: DeliAlgorithmEx
 * @description: 礼物的价值
 * @author: Shaobo.Qian
 * @create: 2020-06-05 14:50
 **/

package second;

public class jz_47 {
    /**
     * dp(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public int maxValue(int[][] grid) {
        int row = grid.length;
        if (row == 0)
            return 0;
        int col = grid[0].length;

        //状态定义
        int[][] dp = new int[row][col]; //走到对应坐标(row,col),能拿到的礼物最大价值
        //base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //随着状态变量的变化,开始进行状态转移
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
