/**
 * @program: Deli-AlgorithmEx
 * @description: 合并区间
 * @author: Shaobo.Qian
 * @create: 2020-04-16 07:46
 **/

package first;

public class lc_56 {
    /**
     * @question 1.如何判断两个区间是否要合并 2.如何合并两个区间
     * @author Shaobo.Qian
     * @date 2020/4/16
     */
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len<2)
            return intervals;

        int mergeCnt = 0;
        //1.遍历所有区间,两两比较,尝试合并
        for (int i = 0; i < len - 1; i++) { //第 i个区间
            for (int j = i+1; j < len; j++) {//第 j 个区间
                //2.满足合并条件,合并区间
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    //新的左边端点选两区间左端点最小值
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    //新的右边端点选两区间右端点最大值
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    //第i个区间已经被合并,清空
                    intervals[i] = null;
                    mergeCnt++;
                    break;
                }
            }
        }
        //3.新建区间集合,返回
        int[][] res = new int[len - mergeCnt][2];
        int idx = 0;
        for (int[] curr : intervals) {
            if (curr != null) {
                res[idx++] = curr;
            }
        }
        return res;
    }

}
