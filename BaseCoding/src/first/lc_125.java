package first;

/**
 * @program: DeliAlgorithmEx
 * @description: 验证回文串
 * @author: Shaobo.Qian
 * @create: 2020-06-23 14:12
 **/

public class lc_125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        lc_125 solution = new lc_125();
        boolean res = solution.isPalindrome(s);
        System.out.println("res = " + res);
    }
    /**
     * 正则 + 双指针
     * @author Shaobo.Qian
     * @date 2020/6/23
     */
    public boolean isPalindrome1(String s) {
        String pattern = "[^a-zA-Z0-9]";
        String target = s.replaceAll(pattern, "").toLowerCase();
        if (target.length() == 0)
            return true;
        int start = 0, end = target.length() - 1;
        while (start < end) {
            if (target.charAt(start++)!=target.charAt(end--))
                return false;
        }

        return true;
    }

    /**
     * anki
     * api+双指针
     * https://leetcode.com/problems/valid-palindrome/discuss/40029/Accepted-pretty-Java-solution(271ms)
     * @author Shaobo.Qian
     * @date 2020/6/23
     */
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i < j; ) {
            if (!Character.isLetterOrDigit(c[i])) i++;
            else if (!Character.isLetterOrDigit(c[j])) j--;
            else if (Character.toLowerCase(c[i++])!=Character.toLowerCase(c[j--])) return false;

        }
        return true;
    }
}
