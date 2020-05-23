/**
 * @program: Deli-AlgorithmEx
 * @description:设计有限阻塞队列
 * @author: Shaobo.Qian
 * @create: 2020-01-19 21:40
 **/

package first;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lc_1188 {

    class BoundedBlockingQueue {
        Queue<Integer> queue;
        int cap = 0;
        Lock lock = new ReentrantLock();

        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();


        public BoundedBlockingQueue(int capacity) {
            queue = new ArrayDeque<>(capacity);
            cap = capacity;
        }

        public void enqueue(int element) throws InterruptedException {

            try {
                lock.lock();
                while (queue.size() == cap) {
                    notFull.await();
                }
                queue.offer(element);
                notEmpty.signalAll();
            } finally {
                lock.unlock();
            }
        }

        public int dequeue() throws InterruptedException {
            try {
                lock.lock();
                while (queue.peek() == null) {
                    notEmpty.await();
                }
                Integer res = queue.poll();
                notFull.signalAll();
                return res;
            } finally {
                lock.unlock();
            }
        }

        public int size() {
            try {
                lock.lock();
                return queue.size();
            } finally {
                lock.unlock();
            }
        }
    }
}
