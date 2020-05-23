/**
 * @program: Deli-AlgorithmEx
 * @description: 生命游戏
 * @author: Shaobo.Qian
 * @create: 2020-04-02 21:03
 **/

package first;

public class lc_289 {
    int row;
    int col;
    int[][] indexs = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};

    public void gameOfLife(int[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        if (col == 0) return;
        int[][] newBoard = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //获取周围活细胞的个数
                int liveCount = getLiveCount(board, i, j);
                if (liveCount < 2 || liveCount > 3) {
                    newBoard[i][j] = 0;
                } else if (liveCount == 3 && board[i][j] == 0) {
                    newBoard[i][j] = 1;
                } else {
                    newBoard[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private int getLiveCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] index : indexs) {
            int x = index[0] + i;
            int y = index[1] + j;
            if (isValidIndex(x, y) && board[x][y] == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidIndex(int x, int y) {
        return !(x < 0 || x >= row || y < 0 || y >= col);
    }
}
