/**
 * @program: Deli-AlgorithmEx
 * @description: Pow(x, n)
 * @author: Shaobo.Qian
 * @create: 2020-05-11 15:31
 **/

package first;

public class lc_50 {

    public static void main(String[] args) {
        System.out.println("args = " + 2147483647);
        lc_50 solution = new lc_50();
//        double res = solution.myPow(2.000000, 10);
//        double res = solution.myPow(2.10000, 3);
        double res = solution.myPow(0.44528, 0);
//        double res = solution.myPow(0.00001, 2147483647);
        System.out.println("res = " + res);
    }

    /**
     * //todo:待入 anki
     * 数学:快速幂
     * @link: https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
     * @quesiton:
     * 1.如何防止 int 越界(n 和-n 转换)
     * 2.如何使用快速幂求解
     * @author Shaobo.Qian
     * @date 2020/5/11
     */
    public double myPow(double x, int n) {
        if (x == 0.0f)
            return 0.0d;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }

        return res;
    }

    private double divideConquer(double x, int n) {
        //1.terminator
        if (n == 1)
            return x;
        //2.current level
        if (n % 2 == 0) {
            return divideConquer(x, n / 2) * divideConquer(x, n / 2);
        } else {
            return x * divideConquer(x, (n - 1) / 2) * divideConquer(x, (n - 1) / 2);
        }
    }


    /**
     * 分治
     *
     * @author Shaobo.Qian
     * @date 2020/5/11
     */
    public double myPow2(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }

        return divideConquer2(x, n);
    }

    private double divideConquer2(double x, int n) {
        //1.terminator
        if (n == 1)
            return x;
        //2.current level
        if (n % 2 == 0) {
            return divideConquer2(x, n / 2) * divideConquer2(x, n / 2);
        } else {
            return x * divideConquer2(x, (n - 1) / 2) * divideConquer2(x, (n - 1) / 2);
        }
    }

    /**
     * 递归(单纯的递归,n太大会溢出)
     *
     * @author Shaobo.Qian
     * @date 2020/5/11
     */
    public double myPow1(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }
        return recur1(x, n);
    }

    private double recur1(double x, int n) {
        //1.terminator
        if (n == 1)
            return x;
        //
        return x * myPow1(x, n - 1);
    }
}
