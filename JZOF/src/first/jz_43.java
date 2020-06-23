/**
 * @program: Deli-AlgorithmEx
 * @description: 1～n整数中1出现的次数
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:33
 **/

package first;

public class jz_43 {


    /**
     * anki
     * @link: https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
     * @question (数学)
     * 1.一个数字 n 可以定义成哪些变量,借由这些变量(cur,low,high,digit)来拆解数字 n,请画图说明?
     * 2.由低位到高位的过程中,这些变量如何变化?
     * 3.如何通过这些变量计算 n 中1的个数,分为哪三种情况
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public int countDigitOne(int n) {
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            //2.计算
            if (cur == 0) res += high * digit; //只和高位有关
            else if (cur == 1) res += high * digit + low + 1; //和高位,地位都有关
            else res += (high + 1) * digit;//只和高位有关
            //3.处理变量
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }


        return res;

    }
}
