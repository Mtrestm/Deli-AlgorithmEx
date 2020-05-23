/**
 * @program: Deli-AlgorithmEx
 * @description: 数字序列中某一位的数字
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:34
 **/

package first;

public class jz_44 {

    /**
     * @link https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/
     * @question(数学)
     * 1.如何拆解数位n,通过哪些变量(num,digit,start),含义分别是?画图说明
     * 2.如何确定所求数位的所在数字的位数digit?
     * 3. 如何确定所求数位n所在的数字num?
     * 4.如何确定所求数位n在num中的哪一数位?
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public int findNthDigit(int n) {
        //1.定义变量
        int digit = 1;//数位
        long start = 1;//同数位区间起始值
        long count = 9;//某一数位区间的数字个数

        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        //2.求n所在的数是哪个
        long num = start + (n - 1) / digit;

        //3.确定n所在的数的哪一位返回
        return Long.toString(num).charAt((n - 1) % digit) - '0';


    }
}
