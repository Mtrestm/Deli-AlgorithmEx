/**
 * @program: Deli-AlgorithmEx
 * @description:
 * @author: Shaobo.Qian
 * @create: 2019-12-29 06:21
 **/

package second;

public class lc_125 {

    public boolean isPalindrome(String s) {
        //1.转字符数组
        char[] c = s.toCharArray();
        //2.双指针从首尾向中间读,比较
        for (int left = 0, right = s.length() - 1; left < right; ) {

            //2.1左边读取的字符不合法
            if (!Character.isLetterOrDigit(c[left])) left++;
            //2.2右边读取的字符不合法
            else if(!Character.isLetterOrDigit(c[right])) right--;
            //2.3比较左右字符是否相等
            else if (Character.toLowerCase(c[left++])!=Character.toLowerCase(c[right--])) return false;
        }
        return true;
    }
}
