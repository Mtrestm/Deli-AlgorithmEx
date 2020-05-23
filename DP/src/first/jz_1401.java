/**
 * @program: Deli-AlgorithmEx
 * @description: 面试题14- I. 剪绳子
 * @author: Shaobo.Qian
 * @create: 2020-03-11 12:08
 **/

package first;

public class jz_1401 {
    public static void main(String[] args) {

        int max = cuttingRope(10);
        System.out.println("max = " + max);
    }

    /**
     *
     * 动态规划(自顶向下+记忆化)
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     * @link https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/xu-lie-xing-dong-tai-gui-hua-by-muyids-2/
     */
    public static int cuttingRope(int n) {

        int[] dp = new int[n + 1];
        //所有的状态(绳子总长度;有多少段绳子) 长度i,分成两段,每段长度j,(i-j)
        //状态转移 ,任合可分割的绳子都能分成两段
        //base case
        dp[1] = 1;
        //dp 方程
        //长度i,分成两段,每段长度j,(i-j)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                //任合可分割的绳子都能分成两段
                //第一部分长度为j, 第二部分长度为i-j
                //第二部分存在剪和不剪两种情况，剪的时候值为dp[i-j]，不剪的时候取（i-j)
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        //证明 j<=i-j 的情况下 Math.max(j * dp[i-j],j * (i - j)) >= dp[j]*dp[i-j]

        //如果 dp[i-j]>= (i-j) ==> j* dp[i-j] >= dp[j]*dp[i-j]
        return dp[n];
    }

}
