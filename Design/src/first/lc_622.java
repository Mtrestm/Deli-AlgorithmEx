package first;

/**
 * @program: Deli-AlgorithmEx
 * @description:设计循环队列
 * @author: Shaobo.Qian
 * @create: 2020-01-15 06:30
 **/

public class lc_622 {

    class MyCircularQueue {

        private int front;
        private int rear;
        private int[] arr;
        private int capacity;

        /**
         * Initialize your data structure here. Set the size of the queue to be k.
         */
        public MyCircularQueue(int k) {
            capacity = k + 1;
            arr = new int[capacity];
            // 在 front 出队，故设计在数组的头部，方便删除元素
            // 删除元素的时候，只索引 +1（注意取模）

            // 在 rear 入队，故设计在数组的尾部，方便插入元素
            // 插入元素的时候，先赋值，后索引 +1（注意取模）
            front = 0;
            rear = 0;
        }

        /**
         * Insert an element into the circular queue. Return true if the operation is successful.
         */
        public boolean enQueue(int value) {
            if (isFull())
                return false;
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            return true;
        }


        /**
         * Delete an element from the circular queue. Return true if the operation is successful.
         */
        public boolean deQueue() {
            if (isEmpty())
                return false;
            front = (front + 1) % capacity;
            return true;
        }

        /**
         * Get the front item from the queue.
         */
        public int Front() {
            if (isEmpty())
                return -1;
            return arr[front];
        }

        /**
         * Get the last item from the queue.
         */
        public int Rear() {
            if (isEmpty())
                return -1;

            return arr[(rear-1+capacity)%capacity];
        }

        /**
         * Checks whether the circular queue is empty or not.
         */
        public boolean isEmpty() {

            return front == rear;
        }

        /**
         * Checks whether the circular queue is full or not.
         */
        public boolean isFull() {

            return (rear + 1) % capacity == front;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
