/**
 * @program: Deli-AlgorithmEx
 * @description: 01 矩阵
 * @author: Shaobo.Qian
 * @create: 2020-04-15 12:14
 **/

package first;

public class lc_542 {

    int[][] res;

    /**
     * 1.BFS || 2.动态规划
     * @author Shaobo.Qian
     * @date 2020/4/15
     */
    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        //1.新建一个矩阵放结果
        res = new int[rows][cols];

        //2.遍历原矩阵,以遍历元素为起点做BFS找到最短举例
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //3.1
            }
        }

        //3.返回结果

        return null;
    }
}
