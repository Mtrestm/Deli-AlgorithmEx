/**
 * @program: Deli-AlgorithmEx
 * @description: II. 左旋转字符串
 * @author: Shaobo.Qian
 * @create: 2020-05-07 06:50
 **/

package first;

public class jz_5802 {
    public String reverseLeftWords(String s, int n) {
        if (s.length()<=n) return s;
        StringBuilder buffer = new StringBuilder();
        return buffer.append(s.substring(n, s.length())).append(s.substring(0, n)).toString();

    }
}
