/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-29 07:00
 **/

package second;

public class lc_680 {
    boolean validPalindrome(String s) {
        char[] c = s.toCharArray();
        //1.双指针分别从左右开始读取字符
        for (int left = 0, right = s.length()-1; left < right; left++, right--) {
            //2.满足继续
            if (c[left] != c[right]) {
                //3.左右字符不等
                //3.1掠过左边的字符,判断剩下字符是否是回文串
                //3.2掠过右边的字符,判断剩下字符是否是回文串
                return isPalindromeStr(c, left + 1, right) || isPalindromeStr(c, left, right - 1);
            }
        }
        return true;
    }

    private boolean isPalindromeStr(char[] c, int left, int right) {
        while (left < right) {
            if (c[left++] != c[right--]) return false;
        }
        return true;
    }
}
