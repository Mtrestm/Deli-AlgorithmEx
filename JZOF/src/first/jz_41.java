/**
 * @program: Deli-AlgorithmEx
 * @description: 数据流中的中位数
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:33
 **/

package first;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * anki
 * 设计题
 * @link: https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/mian-shi-ti-41-shu-ju-liu-zhong-de-zhong-wei-shu-y/
 * @Question:
 * 1.取中位数对应会遇到哪两种情况?
 * 2.如何在 O(1)的时间内取到中位数?
 * 3.算法流程是怎样的?需要借助哪种数据结构实现?
 * @author Shaobo.Qian
 * @date 2020/5/8
 */
public class jz_41 {
    class MedianFinder {
        Queue<Integer> A, B;
        /** initialize your data structure here. */
        public MedianFinder() {
            A = new PriorityQueue<>();//默认小顶堆,保存较大的一半元素
            B = new PriorityQueue<>((x, y) -> y - x);//构建大顶堆,保存较小的一半元素
        }

        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size() == B.size() ? (A.peek() + B.peek()) / 2.0 : A.peek();
        }
    }
}
