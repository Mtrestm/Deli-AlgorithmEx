/**
 * @program: Deli-AlgorithmEx
 * @description: 丑数
 * @author: Shaobo.Qian
 * @create: 2020-06-03 17:49
 **/

package second;

public class jz_49 {
    public static void main(String[] args) {
        jz_49 solution = new jz_49();
        int res = solution.nthUglyNumber(10);
        System.out.println("res = " + res);
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/6/3
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int a = 0, b = 0, c = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            //状态变量的范围开始变化
            if (dp[i] == n2)
                a++;
            if (dp[i] == n3)
                b++;
            if (dp[i] == n5)
                c++;
        }
        return dp[n-1];
    }

}
