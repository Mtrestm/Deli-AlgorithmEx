/**
 * @program: Deli-AlgorithmEx
 * @description:合并排序的数组
 * @author: Shaobo.Qian
 * @create: 2020-03-03 07:26
 **/

package first;

import java.util.Arrays;

public class ci_1001 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0}, b = {2, 5, 6};
        int m = 3, n = 3;
        merge(a, m, b, n);
        Arrays.stream(a).forEach(p -> System.out.print(" " + p));
    }

    /**
     * 双指针
     * @author Shaobo.Qian
     * @date 2020/3/3
     */
    public static void merge(int[] A, int m, int[] B, int n) {
        //双指针,分别指向两个数组尾部,从后向前遍历数组,每取一个数指针后退一位
        for (int i = m + n - 1; i >= 0; i--) {
            if (m == 0) {//A数组取尽,取B数组
                A[i] = B[n - 1];
                n--;
            } else if (n == 0) {//B数组取尽,取A数组
                A[i] = A[m - 1];
                m--;
            } else if (A[m - 1] > B[n - 1]) {//取A,B数组较大值
                A[i] = A[m - 1];
                m--;
            } else {//取A,B数组较大值
                A[i] = B[n - 1];
                n--;
            }
        }
    }
}
