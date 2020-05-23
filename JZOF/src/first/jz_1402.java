/**
 * @program: Deli-AlgorithmEx
 * @description: 14- II. 剪绳子 II
 * @author: Shaobo.Qian
 * @create: 2020-03-11 16:12
 **/

package first;

import java.math.BigInteger;

public class jz_1402 {
    public static void main(String[] args) {
        int res = cuttingRope1(120);
        System.out.println("res = " + res);
    }

    /**
     * dp
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     */
    public static int cuttingRope(int n) {

        BigInteger[] dp = new BigInteger[n + 1];
        //所有的状态(绳子总长度;有多少段绳子) 长度i,分成两段,每段长度j,(i-j)
        //状态转移 ,任合可分割的绳子都能分成两段
        //base case
        dp[1] = new BigInteger("1");
//        dp[2] = new BigInteger("2");
        //dp 方程
        //长度i,分成两段,每段长度j,(i-j)
        for (int i = 2; i <= n; i++) {
            dp[i] = new BigInteger("0");
            for (int j = 1; j <= i / 2; j++) {
                //任合可分割的绳子都能分成两段
                //第一部分长度为j, 第二部分长度为i-j
                //第二部分存在剪和不剪两种情况，剪的时候值为dp[i-j]，不剪的时候取（i-j)
                dp[i] = dp[i].max(dp[i - j].multiply(BigInteger.valueOf(j)).max(BigInteger.valueOf(j * (i - j))));
            }
        }
        return dp[n].mod(new BigInteger("1000000007")).intValue();
    }


    /**
     * 贪心算法
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     * @link https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/javatan-xin-si-lu-jiang-jie-by-henrylee4/
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     */
    public static int cuttingRope1(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }


}
