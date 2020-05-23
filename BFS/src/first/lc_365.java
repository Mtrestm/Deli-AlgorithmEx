/**
 * @program: Deli-AlgorithmEx
 * @description: 水壶问题
 * @author: Shaobo.Qian
 * @create: 2020-03-21 09:27
 **/

package first;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc_365 {
    /**
     * BFS
     * @question 每次BFS搜索哪几种状态
     * @author Shaobo.Qian
     * @date 2020/3/21
     * @link https://leetcode.com/problems/water-and-jug-problem/discuss/83716/Java-Programmatic-Solution-BFS-without-GCD
     */
    public boolean canMeasureWater(int x, int y, int z) {
        //1.边界判断
        if (x + y < z || z < 0) return false;
        //2.存放所有可能的状态,并用来防止重复进入同一状态
        Set<Integer> set = new HashSet<>();
        //3.存放各种可能能的状态
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            //1.将x灌满;(curr + x <= x + y -->说明curr<=y,可以将curr 全部放入 y 中,x此时为空)
            if (curr + x <= x + y && set.add(curr + x))
                queue.offer(curr + x);
            //2.将y灌满
            if (curr + y <= x + y && set.add(curr + y))
                queue.offer(curr + y);
            //3.将x清空
            if (curr - x >= 0 && set.add(curr - x))
                queue.offer(curr - x);
            //4.将y清空
            if (curr - y >= 0 && set.add(curr - y))
                queue.offer(curr - y);
            if (set.contains(z))
                return true;
        }
        return false;
    }
}
