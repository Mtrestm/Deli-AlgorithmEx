/**
 * @program: Deli-AlgorithmEx
 * @description: 丑数
 * @author: Shaobo.Qian
 * @create: 2020-05-03 18:18
 **/

package first;

public class jz_49 {
    /**
     * anki
     * 自顶向下
     * @question:
     * 1.丑数的递推性质是什么?
     * 2.根据丑数的递推性质可以定义哪三个变量?他们和丑数之间的关系?
     * 3.dp[i] 状态的含义?
     * 4.如何进行一次状态转移?
     * 5.状态转移后,状态变量如何变化?
     * 6.如何画图解释 dp 的过程?
     * @link https://leetcode-cn.com/problems/chou-shu-lcof/solution/mian-shi-ti-49-chou-shu-dong-tai-gui-hua-qing-xi-t/
     * @author Shaobo.Qian
     * @date 2020/5/4
     */
    public int nthUglyNumber(int n) {
        //定义状态变量 a,b,c
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //base case
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n-1];
    }







}
