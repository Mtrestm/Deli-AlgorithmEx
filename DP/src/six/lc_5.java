/**
 * @program: Deli-AlgorithmEx
 * @description: 最长回文子串
 * @author: Shaobo.Qian
 * @create: 2020-06-01 17:08
 **/

package six;

public class lc_5 {
    /**
     * dp(自顶向下)
     *
     * @author Shaobo.Qian
     * @date 2020/6/1
     */
    public String longestPalindrome(String s) {
        //1.状态变量+变换范围 子串左边界:l[0,r);子串右边界:r:[1,n);
        //2.状态定义: dp[l][r] 是以 l,r 为边界的回文子串
        //3.状态转移 dp[l][r] = (s[r] ==  s[r])&& (r-l<=2 || dp[l+1][r-1])
        //4.base case: s[0]
        int len = s.length();
        if (len <= 1)
            return s;
        boolean[][] dp = new boolean[len][len];
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && ((r - l) <= 2 || dp[l + 1][r - 1])) {
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
