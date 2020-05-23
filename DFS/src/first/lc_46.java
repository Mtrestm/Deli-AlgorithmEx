/**
 * @program: Deli-AlgorithmEx
 * @description: 全排列
 * @author: Shaobo.Qian
 * @create: 2020-04-25 15:34
 **/

package first;

import java.util.ArrayList;
import java.util.List;

public class lc_46 {
    public static void main(String[] args) {
        boolean[] used = new boolean[2];
        System.out.println("used[0] = " + used[0]);
        int[] nums = {1, 2, 3};

        lc_46 lc_46 = new lc_46();
        List<List<Integer>> res = lc_46.permute(nums);
        for (List<Integer> re : res) {
            re.forEach(p -> System.out.println("p = " + p));
            System.out.println();
        }
    }
    /**
     * 1、什么是“树形问题”？为什么为什么是在树形问题上使用“深度优先遍历”？不用深度优先遍历我们还可以用什么？
     * 2、什么是“回溯”？为什么需要回溯？
     * 3、不回溯可以吗？
     * 4.如何将每一条路径的结果加入结果集合(这里有坑)
     * 5.回溯时要清楚哪两个状态
     * 6.如何保证每个元素只会取一次
     * 7.如何回溯
     * 回溯
     *
     * @author Shaobo.Qian
     * @date 2020/4/25
     */
    List<List<Integer>> res;

    public  List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return res;
        List<Integer> currRes = new ArrayList<>();
        boolean[] used = new boolean[len];
        backTracing(0,len, nums, currRes,used);
        return res;
    }

    private void backTracing(int depth, int len,int[] nums, List<Integer> path, boolean[] used) {
        //1.terminator
        if (depth == len) {
//            res.add(path);
            res.add(new ArrayList<>(path));
            return;
        }
        //2.currentLevel
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;//保证每一条成功的路径上元素不重复
                path.add(nums[i]);
                //3.drill down
                backTracing(depth + 1, len, nums, path, used);
                //4.restore
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
