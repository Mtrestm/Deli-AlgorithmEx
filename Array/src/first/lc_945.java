/**
 * @program: Deli-AlgorithmEx
 * @description: 使数组唯一的最小增量
 * @author: Shaobo.Qian
 * @create: 2020-03-22 06:57
 **/

package first;

import java.util.Arrays;

public class lc_945 {
    public static void main(String[] args) {
//        int[] A = {1, 2, 2};
        int[] A = {3, 2, 1, 2, 1, 7};
        int count = minIncrementForUnique(A);
        System.out.println("count = " + count);
    }

    /**
     * 排序+计数法
     *
     * @author Shaobo.Qian
     * @date 2020/3/22
     */
    public static int minIncrementForUnique1(int[] A) {
        if (A.length <= 1) return 0;
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            while (A[i] <= A[i - 1]) {
                A[i] += 1;
                count++;
            }
        }
        return count;
    }

    /**
     * 计数法+遍历
     *
     * @author Shaobo.Qian
     * @date 2020/3/22
     */
    public static int minIncrementForUnique2(int[] A) {
        //1.创建计数数组(按 A 的取值范围最大值申请)
        int[] cntArr = new int[4000];
        int max = 0;//用来缩小后面遍历的范围,因为现在的数组大小是按A的取值范围最大值申请的
        for (int a : A) {
            cntArr[a]++;
            max = Math.max(max, a);
        }
        int move = 0;
        for (int i = 0; i < max; i++) {//这里不包含 max,max的个数和要 move 的步数在后面单独计算
            if (cntArr[i] > 1) {
                move += cntArr[i] - 1; //当前索引位置只保留一个,其它的数各前进1步,到达下一个索引
                cntArr[i + 1] += cntArr[i] - 1;
            }
        }
        // count[max] 单独计算，是因为可能超出 40000 的边界
        if (cntArr[max] > 1) {
            int num = cntArr[max] - 1;
            move += (1 + num) * num / 2;
        }
        return move;
    }

    /**
     *
     *
     * @question 线性探测寻址的目的?(目的是为了达到下一个空位,所以要将路径上的值都映射为已到达的最远位置,即当前索引上保存的是当前路径上已到达的最大索引位置)
     * @author Shaobo.Qian
     * @date 2020/3/22
     */
    static int[] pos = new int[8000];

    public static int minIncrementForUnique(int[] A) {

        System.out.println(65536>>>16);

        Arrays.fill(pos, -1);
        int move = 0;
        for (int currIdx : A) {
            int idleIdx = findPos(currIdx);
            move += idleIdx - currIdx;
        }
        return move;
    }

    // 线性探测寻址（含路径压缩）==>实质是递归
    private static int findPos(int currIdx) {
        int currMaxIdx = pos[currIdx];
        // 如果currIdx对应的位置pos[currIdx]是空位，直接放入即可。
        if (currMaxIdx == -1) {
            pos[currIdx] = currIdx;
            return currIdx;
        }
        // 否则向后寻址
        // 因为pos[currIdx]中标记了上次寻址得到的空位(即当前寻址路径上已到达的最大索引位置)，因此从pos[currIdx]+1开始寻址就行了（不需要从currIdx+1开始）。
        int idleIdx = findPos(currMaxIdx + 1);
        pos[currIdx] = idleIdx;// 寻址后的新空位要重新赋值给pos[currIdx]哦，路径压缩就是体现在这里。
        return idleIdx;
    }
}
