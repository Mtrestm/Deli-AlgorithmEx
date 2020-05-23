/**
 * @program: Deli-AlgorithmEx
 * @description: 股票的最大利润
 * @author: Shaobo.Qian
 * @create: 2020-05-07 17:20
 **/

package first;

public class jz_63 {
    public static void main(String[] args) {
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
        int[] prices = {1,2};
        jz_63 solution = new jz_63();
        int res = solution.maxProfit(prices);
        System.out.println("res = " + res);
    }

    public int maxProfit(int[] prices) {
        //3个状态变量,是否持有,天数,交易次数
        //base case(定义的是第0天的情况)
        int i_0 = 0;//状态定义:在第i天卖出股票的利润
        int i_1 = Integer.MIN_VALUE;//在第i天买入股票

        for (int i = 0; i < prices.length; i++) {
            i_0 = Math.max(i_0, i_1 + prices[i]);
            i_1 = Math.max(i_1, -prices[i]);
        }
        return i_0;
    }
}
