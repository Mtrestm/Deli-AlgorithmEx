/**
 * @program: Deli-AlgorithmEx
 * @description: 礼物的最大价值
 * @author: Shaobo.Qian
 * @create: 2020-05-03 18:17
 **/

package first;

import java.util.ArrayList;
import java.util.List;

public class jz_47 {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        jz_47 solution = new jz_47();
        int max = solution.maxValue1(grid);
        System.out.println("max = " + max);
    }
    /**
     * anki
     * dp
     * @link:https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/mian-shi-ti-47-li-wu-de-zui-da-jie-zhi-dong-tai-gu/
     * @question:
     * 1.本题的状态变量是哪两个?状态变量的范围?
     * 2.本地的 dp 状态如何定义?含义是?
     * 3.base case是什么? 如何初始化?
     * 4.dp[i][j] 可以由哪两种状态转移过来?
     * 5.状态转移方程?
     * 6.动态规划的整个过程如何画图表示?
     * @author Shaobo.Qian
     * @date 2020/5/4
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] += grid[i][j - 1];
                else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>自解 dfs(回溯) ===>未解出
//    List<Integer> res;
    List<List<Integer>> res;

    int[][] directions = {{0, 1}, {1, 0}};

    /**
     * @author Shaobo.Qian
     * @date 2020/5/4
     */
    public int maxValue1(int[][] grid) {
        res = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
//        recur(grid, 0, 0, row, col, 0);
        recur(grid, 0, 0, row, col, new ArrayList<Integer>());

        int max = 0;
//        for (int num : res) {
//            max = Math.max(max, num);
//        }
        return max;
    }

    private void recur(int[][] grid, int x, int y, int row, int col, List<Integer>path) {
        //1.terminator
        if (!isValidIdx(x, y, row, col))
            return;

//        path += grid[x][y];
        path.add(grid[x][y]);
        if (x == row-1 && y == col-1) {
//            res.add(path);
            res.add(new ArrayList<>(path));

            return;
        }
        //2.current level
        for (int[] dir : directions) {
            //3.drill down
            recur(grid, x + dir[0], y + dir[1], row, col, path);
            //4.clear status
//            path -= grid[x][y];
            path.remove(path.size() - 1);
        }
    }

    private boolean isValidIdx(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }
}
