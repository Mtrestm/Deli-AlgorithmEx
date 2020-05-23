/**
 * @program: Deli-AlgorithmEx
 * @description: 不用加减乘除做加法
 * @author: Shaobo.Qian
 * @create: 2020-05-07 17:21
 **/

package first;

public class jz_65 {
    /**
     * 位运算
     * @link: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/solution/mian-shi-ti-65-bu-yong-jia-jian-cheng-chu-zuo-ji-7/
     * @question:
     * 1.如何求非进位和?
     * 2.如何求进位?
     * @author Shaobo.Qian
     * @date 2020/5/7
     */
    public int add(int a, int b) {
        while (b != 0) {// 循环直到进位为 0 时跳出
            int c = (a & b) << 1; //计算进位
            a ^= b; //a = 非进位和
            b = c;
        }
        return a;
    }
}