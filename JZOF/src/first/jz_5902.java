/**
 * @program: Deli-AlgorithmEx
 * @description: 队列的最大值
 * @author: Shaobo.Qian
 * @create: 2020-03-07 18:06
 **/

package first;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 已入anki
 * @question: 如何解决 O(1) 复杂度的 max_value() 函数设计问题?需要哪种数据结构辅助?辅助的数据结构中保存的元素的特点?推导出该题的解题思路?
 * @author Shaobo.Qian
 * @date 2020/3/7
 * @link: https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/ru-he-jie-jue-o1-fu-za-du-de-api-she-ji-ti-by-z1m/
 * @link https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/javadui-lie-yu-shuang-duan-dui-lie-by-zackqf/
 */
public class jz_5902 {
    class MaxQueue {
        Queue<Integer> que; //队列：插入和删除
        Deque<Integer> deq;//双端队列：获取最大值 (单调递减)
        public MaxQueue() {
            que = new LinkedList<>();
            deq = new LinkedList<>();
        }

        public int max_value() {
            return deq.isEmpty() ? -1 : deq.peek();
        }

        public void push_back(int value) {
            que.offer(value);
            while (!deq.isEmpty() && deq.peekLast() < value) {
                deq.pollLast();//将deq队尾小于value的元素删掉,维持 deq 中的元素单调递减
            }
            deq.offerLast(value);
        }

        public int pop_front() {
            int temp = que.isEmpty() ? -1 : que.poll();//获得队首元素
            //如果出队的元素是当前最大值，将deq的队首出队
            while (!deq.isEmpty() && temp == deq.peekFirst()) {
                deq.poll();
            }
            return temp;
        }
    }

}
