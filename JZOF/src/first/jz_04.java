/**
 * @program: Deli-AlgorithmEx
 * @description: 二维数组中的查找
 * @author: Shaobo.Qian
 * @create: 2020-03-05 08:48
 **/

package first;

public class jz_04 {

    public static void main(String[] args) {

    }

    /**
     * 1.解题思路和满足循环的条件
     * @author Shaobo.Qian
     * @date 2020/3/5
     * @link https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-b-3/
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0, col = cols - 1;
        //每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
        //从二维矩阵的右上角开始查
        //如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
        while (row < rows && col >=0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {//左移一列
                col--;
            } else {//下移一位
                row++;
            }
        }
        return true;
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/3/5
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        //两次二分查找
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        if (target < matrix[0][0]) return false;

        int low = matrix[0][0];
        int high = matrix[rows - 1][0];
        //第一次二分查找确定在哪一行
        int targetRow = getRow(0, rows, matrix, target);
        //第二次二分查找确定在哪一列

        int targetCol = getCol(0, cols, matrix, target, targetRow);
        return matrix[targetRow][targetCol] == target;
    }

    private int getCol(int minCol, int maxCol, int[][] matrix, int target, int targetRow) {
        while (minCol < maxCol) {
            int mediumCol = (maxCol - minCol) / 2;
            //如果左边小
            if (matrix[targetRow][mediumCol] < target) {
                minCol = minCol + 1;
            } else if (matrix[targetRow][mediumCol] > target) {
                maxCol = mediumCol - 1;
            } else {
                return mediumCol;
            }
        }
        return minCol - 1;
    }


    //1,2,5 ,8,10 ,12 ==>6
    //1,3  ===>2

    private int getRow(int minRow, int maxRow, int[][] matrix, int target) {
        while (minRow < maxRow) {
            int mediumRow = (maxRow - minRow) / 2;
            //如果左边小
            if (matrix[mediumRow][0] < target) {
                minRow = mediumRow + 1;
            } else if (matrix[minRow][0] > target) {
                maxRow = mediumRow - 1;
            } else {
                return mediumRow;
            }
        }
        return minRow - 1;
    }
}
