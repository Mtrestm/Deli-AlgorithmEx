/**
 * @program: Deli-AlgorithmEx
 * @description: 课程表 II
 * @author: Shaobo.Qian
 * @create: 2020-05-17 14:28
 **/

package first;

import java.util.*;

public class lc_210 {

    /**
     * 已入anki
     * @link: https://leetcode-cn.com/problems/course-schedule-ii/solution/tuo-bu-pai-xu-shen-du-you-xian-bian-li-python-dai-/400203/
     * @link:https://leetcode-cn.com/problems/course-schedule-ii/solution/bao-mu-shi-ti-jie-tuo-bu-pai-xu-si-lu-zen-yao-yi-2/
     * @author Shaobo.Qian
     * @date 2020/5/17
     * @question:
     * 0.拓扑排序的作用?
     * 1.什么是拓扑排序,入度,出度?画图说明?
     * 2.在排序一步步选定的过程中,对应节点如何变化?--->类似BFS搜索,和传统BFS 不一样的地方?
     * 3.选择什么数据结构来作为邻接表来保存:通过结点的索引，我们能够得到这个结点的后继结点-->即【每门课对应的入度】?课之间的依赖关系】?
     * 4.算法流程?
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //记录所有课程的入度
        int[] inDegree = new int[numCourses];
        //记录课程之间的依赖关系(邻接表：通过结点的索引，我们能够得到这个结点的后继结点；)
        Map<Integer, List<Integer>> map = new HashMap<>();

        // 存放 入度为0的课
        Queue<Integer> queue = new LinkedList<>();
        //填充入度表和哈希表
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        //将入度为零的节点加入queue
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);//i即课程节点
        }
        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {// 没有了入度为0的课，没课可选，结束循环
            Integer curr = queue.poll();// 出栈，代表选这门课
            res.add(curr);// 推入结果数组
            if (map.containsKey(curr)) {// 确保有后续课程
                for (Integer nextCourse : map.get(curr)) {// 遍历后续课程
                    inDegree[nextCourse]--; //所有依赖当前节点的节点的入度减1(将后续课程的入度 -1)
                    if (inDegree[nextCourse] == 0)// 一旦减到0，让该课入列
                        queue.add(nextCourse);
                }
            }
        }

        // 选齐了就返回res，否则返回[]
        return res.size() == numCourses ? res.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
    }
}
