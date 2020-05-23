/**
 * @program: Deli-AlgorithmEx
 * @description: 圆圈中最后剩下的数字
 * @author: Shaobo.Qian
 * @create: 2020-03-30 21:34
 **/

package first;

public class jz_62 {
    public static void main(String[] args) {
        int res = lastRemaining(10, 17);
        System.out.println("res = " + res);
    }

    /**
     * @quetion:
     *
     * @author Shaobo.Qian
     * @date 2020/3/31
     */
    public static int lastRemaining(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }

        return ans;

    }

    /**
     * 超时
     * @author Shaobo.Qian
     * @date 2020/3/30
     */
    public static int lastRemaining1(int n, int m) {

//        m = m % n == 0 ? n : m % n;

        int remain = n;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        while (remain >= 1) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] != -1) {
                    count++;
                }
                if (count == m) {
                    System.out.println("被删除的是 = " + arr[i]);
                    if (--remain == 0) {
                        return arr[i];
                    }
                    arr[i] = -1;
                    count = 0;
                }
                if (i == n - 1) {
                    i = -1;
                }
            }
        }
        return 0;
    }
}
