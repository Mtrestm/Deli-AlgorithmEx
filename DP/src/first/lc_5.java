/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-26 07:56
 **/

package first;

public class lc_5 {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println("s1 = " + s1);
    }
    /**
     * 自顶向下dp (循环+记忆化)
     * @author Shaobo.Qian
     * @date 2019/12/26
     * @link https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     */
    public static String longestPalindrome(String s) {
        //1.定义状态:使用记号 s[l, r] 表示原始字符串的一个子串 (s = 'babad'时,s[0,1] = 'ba',s[2,4] = 'bad')
        //dp[l][r] 表示子串 s[l, r]（包括区间左右端点）是否构成回文串，是一个二维布尔型数组。即如果子串 s[l, r] 是回文串，那么 dp[l][r] = true
        //2.状态转移方程 dp[l, r] = (s[l] == s[r] and (r - l <= 2 or dp[l + 1, r - 1]))
        //r - l <= 2 即 “原字符串去掉左右边界”的子串的边界情况满足r - l <= 2 是回文串,我们说状态发生了转移
        int len = s.length();
        if (len <= 1)
            return s;
        boolean[][] dp = new boolean[len][len]; //为什么定义成二维的,因为左指针和右指针都是变换的
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        //r是右边界,l是左边界
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                //noinspection AlibabaAvoidComplexCondition
                    // 区间应该慢慢放大 (自顶向下 dp)
                    // 状态转移方程：如果头尾字符相等并且中间也是回文
                    // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                    // 否则要继续看收缩以后的区间的回文性
                    // 重点理解 or 的短路性质在这里的作用
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }
}
