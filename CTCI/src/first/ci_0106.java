/**
 * @program: Deli-AlgorithmEx
 * @description: 字符串压缩
 * @author: Shaobo.Qian
 * @create: 2020-03-16 08:42
 **/

package first;


public class ci_0106 {

    public static void main(String[] args) {

        String s = "aabcccccaaa";
        String res = compressString(s);

        System.out.println("res = " + res);
    }

    /**
     * todo: 双指针
     * @author Shaobo.Qian
     * @date 2020/3/17
     * https://leetcode-cn.com/problems/compress-string-lcci/solution/javaban-ben-shuang-zhi-zhen-shi-jian-fu-za-du-on-k/
     */
    public static String compressString(String S) {

        return null;
    }

    /**
     * 开一个空间
     *
     * @author Shaobo.Qian
     * @date 2020/3/16
     */
    public static String compressString1(String S) {
        int len = S.length();
        if (len<=1) return S;
        StringBuilder sb = new StringBuilder();
        sb.append(S.charAt(0));
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (S.charAt(i) != S.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count);
                sb.append(S.charAt(i));
                count = 1;
            }
        }
        sb.append(count);
        String targetStr = sb.toString();
        System.out.println("targetStr = " + targetStr);
        return targetStr.length() <= S.length() ? targetStr : S;
    }
}
