/**
 * @program: Deli-AlgorithmEx
 * @description: 求1+2+…+n
 * @author: Shaobo.Qian
 * @create: 2020-05-07 17:21
 **/

package first;

public class jz_64 {

    /**
     *
     * @link: https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
     * @question:
     * 0.普通递归的写法是怎样的?
     * 1.如何对递归中的if 这种写法的终止条件语句 进行改造(去掉 if)
     * 2.如何画图说明递归的过程?
     * @author Shaobo.Qian
     * @date 2020/5/7
     */
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public int sumNums1(int n) {
        if (n == 1) return 1;
        n += sumNums1(n - 1);
        return n;
    }
}
