/**
 * @program: Deli-AlgorithmEx
 * @description: 字符串解码
 * @author: Shaobo.Qian
 * @create: 2020-05-28 11:30
 **/

package first;

public class lc_394 {
    /**
     * anki
     * dfs
     * @question:
     * 1.递归的终止条件?
     * 2.递归的 drill down 条件
     * 3.递归时当前层的处理逻辑和处理顺序?
     * https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * @author Shaobo.Qian
     * @date 2020/5/28
     */
    public String decodeString(String s) {
        return dfs(s,0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            //2.1current level(因为下一层的处理逻辑依赖 multi变量,所以放前面判断-->依赖 multi 做拼接)
            if(s.charAt(i)>='0'&& s.charAt(i)<='9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            //2.2current level(将下一层返回的结果 字符串*当前层要求重复次数multi -->保存到当前层,同时恢复 multi)
            else if (s.charAt(i) == '[') {
                //3.遇到'['字符,drill down
                String[] temp = dfs(s, i + 1);
                i = Integer.parseInt(temp[0]);
                while (multi > 0) {
                    res.append(temp[1]);
                    multi--;
                }
            }
            //1.terminator(遇到']'返回到上一层)
            else if (s.charAt(i) == ']')
                return new String[]{String.valueOf(i), res.toString()};
            //2.3current level: 如果是字母字符,拼接到当前结果上
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[]{res.toString()};
    }

}
