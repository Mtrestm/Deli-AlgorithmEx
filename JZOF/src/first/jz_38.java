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

    /**
     * anki
     * @question:
     * 1.假设字符串中的字符不重复,有多少种排列方案?
     * 2.当字符串存在重复字符时，排列方案中也存在重复方案,如何剪枝(需要借助哪种数据结构),如何恢复?
     * 3.如果不剪枝,使用普通得方法怎么解?
     * @author Shaobo.Qian
     * @date 2020/5/24
     */
    //自解
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
