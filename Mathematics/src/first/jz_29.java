/**
 * @program: DeliAlgorithmEx
 * @description: 顺时针打印矩阵
 * @author: Shaobo.Qian
 * @create: 2020-06-05 11:30
 **/

package first;

public class jz_29 {
    /**
     * @quesiton
     * 1.模拟前进有哪四种前进方式?
     * 2.每种前进方式中获取哪些元素
     * 3.每种前进完成一次,边界如何收缩
     * @author Shaobo.Qian
     * @date 2020/6/5
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        //1.定义四个边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;

        //2.定义res收集结果
        int[] res = new int[(r + 1) * (b + 1)];
        //3.模拟前进
        while (true) {
            //left -> right
            for (int i = l; i <= r; i++) {
                res[x++] = matrix[t][i];//获取 t 行 i 列
            }
            if (++t > b) //t 越界
                break;
            //top -> bottom
            for (int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; //获取i 行 r 列
            }
            if (--r < l)//r 越界
                break;
            //right -> left
            for (int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; //获取 b 行 i 列
            }
            if (--b < t)//b 越界
                break;
            //bottom -> top
            for (int i = b; i >= t; i--) {
                res[x++] = matrix[i][l];
            }
            if (++l>r)
                break;
        }

        return res;
    }
}
