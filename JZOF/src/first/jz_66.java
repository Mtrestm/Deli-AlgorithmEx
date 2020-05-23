/**
 * @program: Deli-AlgorithmEx
 * @description: 构建乘积数组
 * @author: Shaobo.Qian
 * @create: 2020-05-07 18:38
 **/

package first;

public class jz_66 {

    /**
     * anki
     * 数学
     * @link: https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/mian-shi-ti-66-gou-jian-cheng-ji-shu-zu-biao-ge-fe/
     * @question:
     * 1.不使用除法, 如何计算
     * 2.画图说明
     * @author Shaobo.Qian
     * @date 2020/5/7
     */
    public int[] constructArr(int[] a) {
        if (a.length == 0)
            return new int[0];
        int[] b = new int[a.length];
        b[0] = 1;
        int temp = 1;
        //1.计算 b[i]的下三角各元素的乘积,直接乘入b[i]
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //2.计算b[i]的上三角各元素的乘积,记为 temp,并乘入 b[i]
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}
