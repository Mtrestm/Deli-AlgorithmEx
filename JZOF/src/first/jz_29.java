/**
 * @program: Deli-AlgorithmEx
 * @description: 顺时针打印矩阵
 * @author: Shaobo.Qian
 * @create: 2020-05-01 17:17
 **/

package first;

public class jz_29 {

    /**
     * anki
     * @question:
     * 1.打印矩阵的方向是如何循环的?
     * 2.如何定义四条边界?
     * 3.四条边界分别如何收缩?何时打印完所有元素?
     * @author Shaobo.Qian
     * @date 2020/5/1
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        //1.定义左右上下四条边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        //2.定义 res 收集结果
        int[] res = new int[(r + 1) * (b + 1)];
        //3.模拟前进
        while (true) {
            for (int i = l; i <= r; i++) {// left to right.
                res[x++] = matrix[t][i];
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {// top to bottom.
                res[x++] = matrix[i][r];
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {// right to left.
                res[x++] = matrix[t][i];
            }
            if (t > --b) break;
            for (int i = b; i >= t; b--) {//bottom to top
                res[x++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return res;
    }
}
