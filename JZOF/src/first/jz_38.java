/**
 * @program: Deli-AlgorithmEx
 * @description: 字符串的排列
 * @author: Shaobo.Qian
 * @create: 2020-05-02 10:32
 **/

package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class jz_38 {
    public static void main(String[] args) {
        String s = "aab";
        jz_38 solution = new jz_38();
        String[] res = solution.permutation(s);
        Arrays.stream(res).forEach(p-> System.out.println("string = " + p.toString()));
    }
    /**
     * 全排列(回溯)
     *
     * @author Shaobo.Qian
     * @date 2020/5/2
     */
    List<String> res = new ArrayList<>();

    public String[] permutation(String s) {


        char[] target = new char[s.length()];
        boolean[] usedIdx = new boolean[s.length()];
        dfs(s.toCharArray(), target, 0, s.length(), usedIdx);
        res = res.stream().distinct().collect(Collectors.toList());
        return res.toArray(new String[res.size()]);
    }

    private void dfs(char[] resource, char[] target, int currLevel, int tarLevel, boolean[] usedIdx) {
        //1.terminator
        if (currLevel == tarLevel) {
            //处理值传递问题,String.valueOf返回一个新的对象
            res.add(String.valueOf(target));
            return;
        }

        //2.currentLevel
        for (int i = 0; i < tarLevel; i++) {
            if (!usedIdx[i]) {
                usedIdx[i] = true;
                target[currLevel] = resource[i];
                //3.drill down
                dfs(resource, target, currLevel + 1, tarLevel, usedIdx);//3.drill down
                //4.恢复状态,回溯
                usedIdx[i] = false;
            }
        }
    }
}
