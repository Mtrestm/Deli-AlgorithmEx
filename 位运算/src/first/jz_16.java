/**
 * @program: Deli-AlgorithmEx
 * @description: 数值的整数次方
 * @author: Shaobo.Qian
 * @create: 2020-03-11 18:21
 **/

package first;

public class jz_16 {
    /**
     * 二分法
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     */
    public double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if((b & 1) == 1) res *= x; //如果b是奇数,不能正好二分,提出一个x
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
