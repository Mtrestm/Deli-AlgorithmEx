/**
 * @program: Deli-AlgorithmEx
 * @description: 最小的k个数
 * @author: Shaobo.Qian
 * @create: 2020-03-20 21:25
 **/

package first;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc_40 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 2, 3, 1, 3, 5, 3, 5, 6, 9, 7};
        int k = 5;
        int[] res = getLeastNumbers(arr, k);
        Arrays.stream(res).forEach(System.out::print);

    }

    /**
     * @question: 如何构建大根堆?
     * @author Shaobo.Qian
     * @date 2020/3/21
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        //1.利用PriorityQueue构建大根堆
        // Java 的 PriorityQueue 默认是小顶堆，添加 comparator 参数使其变成最大堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (c1, c2) -> Integer.compare(c2, c1));
        //2.遍历将最小的 k 个元素存入堆中
        for (int curr : arr) {
            // 即便堆满了,当前数字小于堆顶元素也会入堆
            if (heap.isEmpty() || heap.size() < k || curr < heap.peek()) {
                heap.offer(curr);
            }
            if (heap.size() > k) {
                heap.poll();
            }
        }
        //3.返回结果
        int[] res = new int[heap.size()];
        int i = 0;
        for (int e : heap) {
            res[i++] = e;
        }
        return res;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) return new int[0];
        else if (arr.length <= k) return arr;
        partitionArr(arr, 0, arr.length - 1, k);
        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private static void partitionArr(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArr(arr, lo, m - 1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数(此时,已经确定前面的 m 个数一定是属于最小 k个数中的了,只要把剩下要找的 k-m 个数切分出来)
            partitionArr(arr, m + 1, hi, k);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int l = left;
        int r = right + 1;
        int v = arr[left];

        while (true) {
            while (arr[++l] < v) {//如果左边指针指向的数据已经比基准值 v 小了,消耗左边的指针,指针向右滑动
                if (l == right) {
                    break;
                }
            }
            while (arr[--r] > v) {//如果右边指针指向的数据已经比基准值 v 大了,消耗右边的指针,指针向左滑动
                if (r == left) {
                    break;
                }
            }
            if (l >= r) { //如果左右指针重合交错,说明基准值左边都小于基准值,反之亦反
                break;
            }
            //走到这里说明 l 指向的数值大于等于基准值,r 指向的数值小于等于基准值,正好用来交换
            swap(arr, l, r);
        }
        swap(arr, left, r);

        return r;
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 快速切分(未解出)
     *
     * @author Shaobo.Qian
     * @date 2020/3/20
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        int len = arr.length;
        //1.排序
        quickSort(arr, 0, len - 1);
        //2.输出
        Arrays.stream(arr).forEach(System.out::print);
        System.out.println();
        return Arrays.copyOf(arr, k);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left + 1 >= right) return;
        int l = left;
        int r = right;
        int pivot = arr[left++];
        while (left <= right) {
            if (arr[left] > pivot) {
                swap(arr, left, right);
                right--;
            } else {
                swap(arr, left, left - 1);
                left++;
            }
        }

        quickSort(arr, l, left - 1);
        quickSort(arr, left, r);
    }


}
