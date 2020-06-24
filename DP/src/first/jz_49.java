/**
 * @program: Deli-AlgorithmEx
 * @description: 丑数
 * @author: Shaobo.Qian
 * @create: 2020-06-02 07:51
 **/

package first;

public class jz_49 {
    public static void main(String[] args) {
        jz_49 solution = new jz_49();
        int res = solution.nthUglyNumber(10);
        System.out.println("res = " + res);

    }

    /**
     * dp
     *
     * @question: 1.a, b, c 三个状态变量指针每次只能走一格为什么?
     * - 答: 每次走一个就是 a,b,c 的三个变量的变换范围,代表了整个动态规划的每一个过程!!!状态变换范围:(因为是无界的,所以每次+1)
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int nthUglyNumber(int n) {
        //1.状态变量 i:第 i+1 个数;状态变量 2,3,5? 状态变换范围:(因为是无界的,所以每次+1)
        //2.状态定义 dp[i]: 第i+1 个丑数的值
        //3.状态转移:

        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        //base case
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            System.out.println("dp[i]  = " + dp[i]);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }
}
