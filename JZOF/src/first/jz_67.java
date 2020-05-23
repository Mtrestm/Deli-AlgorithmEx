/**
 * @program: Deli-AlgorithmEx
 * @description: 把字符串转换成整数
 * @author: Shaobo.Qian
 * @create: 2020-05-07 18:40
 **/

package first;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class jz_67 {
    public static void main(String[] args) {
        long l = Long.parseLong("91283472332") - Integer.MAX_VALUE;
        System.out.println("l = " + l);
        jz_67 solution = new jz_67();
//        String resourceStr = "words and 987";
//        String resourceStr = "42";
        String resourceStr = "4193 with words";
//        String resourceStr = "91283472332";
//        String resourceStr = "-91283472332";
        int res = solution.strToInt(resourceStr);
        System.out.println("res = " + res);

    }


    /**
     * anki
     * 数学+字符串(字符数组)
     * @link: https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/solution/mian-shi-ti-67-ba-zi-fu-chuan-zhuan-huan-cheng-z-4/
     * @question:
     * 1.如何防止数字的结果过大导致溢出?
     * 2.如何处理正负符号?
     * 3.如何使用正则的方式如何解题?
     * @author Shaobo.Qian
     * @date 2020/5/8
     */
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if (c.length == 0) return 0;
        long res = 0;
        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0;

        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;
            res = res * 10 + (c[j] - '0');
            if (res>Integer.MAX_VALUE) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return sign * (int) res;
    }

    final Pattern pattern = Pattern.compile("^(\\s*)([+|-]?)([\\d]+)");
    /**
     * 正则
     * @author Shaobo.Qian
     * @date 2020/5/8
     */
    public int strToInt1(String str) {
        //1.丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            try {
                if ("-".equals(matcher.group(2))) {
                    return -Integer.parseInt(matcher.group(3));
                } else {
                    return Integer.parseInt(matcher.group(3));
                }
            } catch (NumberFormatException e) {
                if ("-".equals(matcher.group(2))) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }
}
