/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-03-04 07:30
 **/

package first;

import java.util.LinkedList;
import java.util.Queue;

public class lc_994 {
    /**
     * anki
     * bfs+二维数组
     * @question :
     * //1.思考队列中存什么,数据结构是什么样的?
     * //2.坐标(x,y)的四个边界条件?
     * //3.从队列中取出腐烂橘子开始在四个方向污染时,达到哪些边界条件下不需要做任何操作?
     * @author Shaobo.Qian
     * @date 2020/3/4
     * @link https://leetcode.com/problems/rotting-oranges/discuss/238681/Java-Clean-BFS-Solution-with-comments
     */
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();//存的是一个数据,数组中有两个元素(橘子的横坐标和纵坐标)
        int count_fresh = 0; //新鲜橘子
        //1.找出二维数组中所有的腐烂橘子放在队列中
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count_fresh++;
                }
            }
        }
        //如果没有新鲜橘子,直接返回
        if (count_fresh == 0) return 0;

        int minutes = 0;//需要的时间
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};//在右左上下四个方向上各前进一位
        //2.每次取出当前层(队列中所有元素),处理完,minutes+1
        //检查队列是否为空,是否还有新鲜的橘子
        while (!queue.isEmpty() && count_fresh > 0) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();//从队列中取出一个腐烂的橘子,返回腐烂的橘子坐标
                //开始在四个方向上污染
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    //if x or y is out of bound
                    //or the orange at (x , y) is already rotten
                    //or the cell at (x , y) is empty
                    //we do nothing
                    if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    //开始标记污染,把污染的橘子放入队列,新鲜橘子数-1
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                    count_fresh--;
                }
            }
        }

        return count_fresh == 0 ? minutes  : -1;
    }
}
