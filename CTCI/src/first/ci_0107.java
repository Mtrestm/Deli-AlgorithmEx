/**
 * @program: Deli-AlgorithmEx
 * @description: 旋转矩阵
 * @author: Shaobo.Qian
 * @create: 2020-04-07 07:39
 **/

package first;

public class ci_0107 {
    /**
     * @question 1:沿左上右下对角线翻转矩阵中元素时行列遍历的范围条件?如何置换? 2.以每一行以中点进行翻转时行列遍历的范围条件?如何置换?
     * @author Shaobo.Qian
     * @date 2020/4/7
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //沿左上右下对角线翻转矩阵中元素
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 再以每一行以中点进行翻转

        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}
