/**
 * @program: Deli-AlgorithmEx
 * @description:回文串
 * @author: Shaobo.Qian
 * @create: 2019-12-23 07:23
 **/

package first;

public class lc_125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println("palindrome = " + palindrome);
    }

    /**
     * 原解1:正则+双指针(效率低)
     * @author Shaobo.Qian
     * @date 2019/12/23
     */
    public static boolean isPalindrome(String s) {
        //1.只考虑字母和数字字符,先将非字母和数字字符的替换成空字符
        String pattern = "[^a-zA-Z0-9]";
        String target = s.replaceAll(pattern, "").toLowerCase();
        if (target.length() == 0) return true;
        int start = 0,end = target.length() - 1;
        while (start <= end) {
            if (target.charAt(start++) != target.charAt(end--)) return false;
        }
        //2.双指针,同时从左到右,从右到左遍历
        return true;
    }


    /**
     * 防解1:双指针+Character库函数
     * @author Shaobo.Qian
     * @date 2019/12/23
     * 防解:https://leetcode.com/problems/valid-palindrome/discuss/40029/Accepted-pretty-Java-solution(271ms)
     */
    public static boolean isPalindrome1(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if(!Character.isLetterOrDigit(c[i])) i++;
            else if(!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++])!=Character.toLowerCase(c[j--])) return false;
        }
        return true;
    }

}
