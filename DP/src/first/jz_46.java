/**
 * @program: Deli-AlgorithmEx
 * @description: 把数字翻译成字符串
 * @author: Shaobo.Qian
 * @create: 2020-06-02 10:40
 **/

package first;

public class jz_46 {

    public static void main(String[] args) {
        jz_46 solution = new jz_46();
        int res = solution.translateNum(25);
        System.out.println("res = " + res);
    }
    /**
     * 降维
     * dp(类似爬楼梯)记忆化+自顶到底
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int translateNum0(int num) {//num=123 ; X1 = 1,X2=2,X3=3 (num=X1X2X3)
        //1.状态变量 i_0,i_1 (最近刚刚求出的两个dp 值)<===因为 待求的dp 值只和最近以求出的两个 dp值相关
        //2.dp[i]:以 (Xi)数字结尾的翻译方案数量
        //3.状态转移:  f(i) = f(i-1)+f(i-2) <== X(i-1)X(i) 可翻译
        //            f(i) = f(i-1)        <== X(i-1)X(i) 不可翻译

        String numStr = String.valueOf(num);
        //base case:
        int i_0 = 1;//以第0个数字结尾的翻译方案数量
        int i_1 = 1;//以第一个数字结尾的翻译方案数量
        for (int i = 2; i <= numStr.length(); i++) {
            //对应本题刚开始的情况,这里是num 中第一第二个字符组成的数字是否可以翻译
            //对应爬楼梯,是能否可以爬一步或者爬两步,还是只能爬一步
            String temp = numStr.substring(i - 2, i);
            int curr = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? i_0 + i_1 : i_1;
            //两个变量各往前走一步
            i_0 = i_1;
            i_1 = curr;
        }

        return i_1;
    }

    /**
     * 一维dp写法(自顶向下+记忆化)
     * @author Shaobo.Qian
     * @date 2020/6/2
     */
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();
        int[] dp = new int[len + 1];
        //base case
        dp[0] = 1; //以第0个数字结尾的翻译方案数量
        dp[1] = 1;//以第1个数字结尾的翻译方案数量
        for (int i = 2; i <= len; i++) {
            String temp = numStr.substring(i - 2, i);
            dp[i] = temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0 ? dp[i - 1] + dp[i - 2] : dp[i - 1];
        }
        return dp[len];
    }

}
