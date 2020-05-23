/**
 * @program: Deli-AlgorithmEx
 * @description: I. 翻转单词顺序
 * @author: Shaobo.Qian
 * @create: 2020-05-07 06:49
 **/

package first;

public class jz_5801 {

    public static void main(String[] args) {
        String s = "  hello world!  ";
//        String s = "a good   example";
        String[] sArr = s.split("\\s+");
        System.out.println("sArr = " + sArr);
    }

    public String reverseWords(String s) {
        String[] sArr = s.split("\\s+");

        StringBuilder buffer = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            //拼接一个空格
            buffer.append(sArr[i]).append(" ");
        }
        //移除字符串前后的空格
        return buffer.toString().trim();
    }

}
