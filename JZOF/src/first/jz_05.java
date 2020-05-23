/**
 * @program: Deli-AlgorithmEx
 * @description: 替换空格
 * @author: Shaobo.Qian
 * @create: 2020-03-05 11:29
 **/

package first;

public class jz_05 {
    public static void main(String[] args) {

        String s = "We are happy.";
        String res = replaceSpace(s);
        System.out.println("res = " + res);
    }

    /**
     * 正则
     *
     * @author Shaobo.Qian
     * @date 2020/3/5
     */
    public static String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * todo:字符数组
     * @question:1.通过字符数组解题的思路?
     * @author Shaobo.Qian
     * @date 2020/3/5
     */
    public static String replaceSpace(String s) {
        int len = s.length();
        char[] array = new char[3 * len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }


}
