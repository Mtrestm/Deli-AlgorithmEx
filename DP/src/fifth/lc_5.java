/**
 * @program: Deli-AlgorithmEx
 * @description: 最长回文子串
 * @author: Shaobo.Qian
 * @create: 2020-05-31 19:38
 **/

package fifth;

public class lc_5 {
    public static void main(String[] args) {
        lc_5 solution = new lc_5();
        String s = "babad";
        String res = solution.longestPalindrome(s);
        System.out.println("res = " + res);
    }
    /**
     * @author Shaobo.Qian
     * @date 2020/5/31
     */
    public String longestPalindrome(String s) {
        //1.状态变量:l,r;s[l,r]是以 l 为左边界,r 为有边界的字符子串
        //2.dp[l][r]: 保存的值代表以s[l,r] 中的最长回文子串
        //3.进行一次状态转移 dp[l][r] ==>s[l] == s[r] &&( dp[l+1][r-1] || r-l<=2)
        int len = s.length();
        if (len<=1)
            return s;
        boolean[][] dp = new boolean[len][len];
        //base case
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) { //为什么 l 的变化范围是 l<r,l==r,长度为一,没必要统计
                if (s.charAt(l) == s.charAt(r) && ((r - l <= 2) || dp[l + 1][r - 1])) {
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
