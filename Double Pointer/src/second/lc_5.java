/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2020-01-01 12:56
 **/

package second;

public class lc_5 {
    /**
     * 回文串+暴力法+双指针(通过双指针模拟不同范围的子串,判断这些子串是不是回文子串)
     * @author Shaobo.Qian
     * @date 2020/1/1
     */
    public String longestPalindrome(String s) {

        int sLen = s.length();
        if(sLen<=1) return s;
        char[] c = s.toCharArray();
        String longestPalindromeStr = s.substring(0, 1);
        int maxLen = 1;
        for (int r = 1; r < sLen; r++) {
            for (int l = 0; l < r; l++) {
                if (r - l + 1 > maxLen && isPalindromeStr(c, l, r)) {
                    maxLen = r - l + 1;
                    longestPalindromeStr = s.substring(l, r + 1);
                }
            }
        }
        return longestPalindromeStr;
    }

    /**
     * 判断字符串是否是回文串
     * @author Shaobo.Qian
     * @date 2020/1/1
     */
    private boolean isPalindromeStr(char[] c, int l, int r) {
        //双指针
        while (l < r) {
            if(c[l++] != c[r--]) return false;
        }
        return true;
    }
}
