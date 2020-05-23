/**
 * @program: Deli-AlgorithmEx
 * @description: 验证回文字符串 Ⅱ
 * @author: Shaobo.Qian
 * @create: 2020-05-19 06:13
 **/

package third;

public class lc_680 {
    public boolean validPalindrome(String s) {
        char[] cArr = s.toCharArray();
        for (int start = 0, end = cArr.length - 1; start < end; start++, end--) {
            if (cArr[start] != cArr[end]) {
                return isParlindrome(cArr, start, end - 1) || isParlindrome(cArr, start + 1, end);
            }
        }
        return true;
    }

    private boolean isParlindrome(char[] cArr, int start, int end) {
        while (start < end) {
            if (cArr[start++]!=cArr[end--])
                return false;
        }
        return true;
    }
}
