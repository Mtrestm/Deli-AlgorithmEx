/**
 * @program: Deli-AlgorithmEx
 * @description: 括号生成
 * @author: Shaobo.Qian
 * @create: 2020-04-10 04:31
 **/

package first;

import java.util.ArrayList;
import java.util.List;

public class lc_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
         dfs(result,"", 0, 0, n);
        return result;
    }

    /**
     * @question :1.为什么字符串的回溯不用清除状态?2.哪种枝叶要被减去? 3.整体回溯剪枝的过程,怎么使用画图来说明?
     * @param result 结果集
     * @param currStr 当前递归得到的结果
     * @param left 已使用的左括号个数
     * @param right 已使用的有括号个数
     * @param n
     */
    private void dfs(List<String> result, String currStr, int left, int right, int n) {
        if (left == n && right == n) {
            result.add(currStr);
            return;
        }
        //剪枝
        if (left < right)
            return;

        if (left < n) {
            dfs(result, currStr + "(", left + 1, right, n);
        }
        if (right < n) {
            dfs(result, currStr + ")", left, right + 1, n);
        }
    }
}
