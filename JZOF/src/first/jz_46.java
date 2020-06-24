/**
 * @program: Deli-AlgorithmEx
 * @description: 把数字翻译成字符串
 * @author: Shaobo.Qian
 * @create: 2020-05-03 00:35
 **/

package first;

/**
 * anki
 * dp
 * 见到数字 num(12258),有哪些常用技巧对数字转换 num =
 * @link:
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
 * @question:
 * 1.本题状态是什么?dp状态如何定义?通常有哪些技巧定义状态? 比如本题一串数字 num(12258),状态定义时要怎么转换这个数字?
 * 2.如何完成一次成功的状态转移(类似爬楼梯问题)?
 * 3.如何定义 base case?怎么推导?
 * 4.是一维还是二维?如何推导?状态变化的范围?
 * 5.状态转移方程?
 * 6.如何画图推导?
 * @author Shaobo.Qian
 * @date 2020/5/3
 */
public class jz_46 {
    /**
     * dp (每次走1步/2步走到终点) 走1步安全 /走两步校验
     * @author Shaobo.Qian
     * @date 2020/5/3
     */
    public int translateNum(int num) {
        //12258
        // 1/2/258 (X)
        //1/22/58 (X)
        // 12 /2 /58(X)
        //12/25/8(√)
        //

        String numStr = String.valueOf(num);
        //定义两个变量来保存,到dp[i]左边最近的两个索引的结果集
        //初始化base case
        int i_0 = 1, i_1 = 1;
        for (int i = 2; i <= numStr.length(); i++) {
            String temp = numStr.substring(i - 2, i);
            //状态转移方程类似爬楼梯,可翻译的时候可以走1步也可以走2步(即 dp[i]=i_0 + i_1),不可翻译时即用上一个的 dp 结果,即 i_1
            int curr = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? i_0 + i_1 : i_1;
            i_0 = i_1;
            i_1 = curr;
        }
        return i_1;
    }
}
