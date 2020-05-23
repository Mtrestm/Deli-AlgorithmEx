/**
 * @program: Deli-AlgorithmEx
 * @description: 1071. 字符串的最大公因子
 * @author: Shaobo.Qian
 * @create: 2020-03-12 07:32
 **/

package first;

public class lc_1071 {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        String str2 = "AB";
        String s = gcdOfStrings(str1, str2);
        System.out.println("s = " + s);
    }
    /**
     *
     * @author Shaobo.Qian
     * @date 2020/3/12
     */
    public static String gcdOfStrings(String str1, String str2) {
        //除尽==>字符串消耗光
        int len1 = str1.length();
        int len2 = str2.length();
        int len = Math.min(Math.min(Math.abs(len1 - len2), len1), len2);
        while (str1 != "") {
            String substring = str1.substring(len);
            str1 = str1.substring(len, len1);

        }
        return str1.substring(len);
    }
}
