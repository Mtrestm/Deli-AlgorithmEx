/**
 * @program: Deli-AlgorithmEx
 * @description: 打印从1到最大的n位数
 * @author: Shaobo.Qian
 * @create: 2020-03-19 21:30
 **/

package first;

import java.util.Arrays;

public class jz_17 {
    public static void main(String[] args) {
        System.out.println("Math.pow(10,3) = " + Math.pow(10, 3));
        int[] res = printNumbers(3);
        Arrays.stream(res).forEach(num -> System.out.print(num));

    }

    /**
     * 快速幂等
     *
     * @author Shaobo.Qian
     * @date 2020/3/19
     */
    public static int[] printNumbers(int n) {
        //求n位数的最大值
        int maxNum = fastPow(10, n) - 1;
        int[] res = new int[maxNum];
        for (int i = 0; i < maxNum; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    static int fastPow(int base, int index) {
        int ans = 1;
        while (index > 0) {
            //1.如果被2除不尽,提出一个 base (比如10^5 ==>10*10^4)
            if ((index & 1) == 1) { //index & 1
                ans *= base;
            }
            //2.幂除以2
            index >>= 1;
            //3.基数 * 基数
            base *= base;
        }
        return ans;
    }

    public static int[] printNumbers1(int n) {
        //求n位数的最大值
        int maxNum = 1;
        for (int i = 0; i < n; i++) {
            maxNum *= 10;
        }
        int[] res = new int[maxNum - 1];
        for (int i = 0; i < maxNum - 1; i++) {
            res[i] = i + 1;
        }

        return res;
    }
}
