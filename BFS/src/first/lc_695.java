/**
 * @program: Deli-AlgorithmEx
 * @description: 岛屿的最大面积
 * @author: Shaobo.Qian
 * @create: 2020-03-15 20:01
 **/

package first;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class lc_695 {

    /**
     * @question 如何用栈来模拟递归?
     * @author Shaobo.Qian
     * @date 2020/3/15
     */
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        Stack<int[]> stack = new Stack<>();
        int[][] moveIndex = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currMax = 0;
                if (grid[i][j] == 1) {
                    stack.add(new int[]{i, j});
                    while (!stack.isEmpty()) {
                        int[] idx = stack.pop();
                        int x = idx[0];
                        int y = idx[1];
                        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0)
                            continue;
                        currMax++;
                        grid[x][y] = 0;
                        for (int[] index : moveIndex) {
                            stack.add(new int[]{x + index[0], y + index[1]});
                        }
                    }
                }
                max = Math.max(max, currMax);
            }
        }
        return max;
    }

    /**
     * bfs
     *
     * @author Shaobo.Qian
     * @date 2020/3/15
     */

    int[][] moveIndexArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Deque<int[]> queue = new LinkedList<>();

    public int maxAreaOfIsland1(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        int ans = 0;//当前搜到的最大的岛屿
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int curr = bfs(i, j, grid);
                    ans = Math.max(ans, curr);
                }
            }
        }
        return ans;
    }

    private int bfs(int i, int j, int[][] grid) {
        int count = 0;
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] idx = queue.poll();
                int x = idx[0];
                int y = idx[1];

                //上下左右的索引位置满足条件加入队列
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0)
                    continue;
                count++;
                grid[x][y] = 0; //已访问过
                for (int[] moveIdx : moveIndexArray) {
                    queue.offer(new int[]{x + moveIdx[0], y + moveIdx[1]});
                }
            }

        }
        return count;
    }
}
