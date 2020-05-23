/**
 * @program: Deli-AlgorithmEx
 * @description: 生命游戏
 * @author: Shaobo.Qian
 * @create: 2020-04-02 21:03
 **/

package first;

/**
 * 原地算法
 *
 * @author Shaobo.Qian
 * @date 2020/4/2
 */
public class lc_289_1 {
    int row;
    int col;
    int[][] indexs = {{-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}};

    public void gameOfLife(int[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        if (col == 0) return;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //获取周围活细胞的个数
                int liveCount = getLiveCount(board, i, j);
                //只关注状态值要发生改变的,给要改变的状态设置新的状态值
                if ((liveCount < 2 || liveCount > 3) && board[i][j] == 1) {
                    //如果是存活的 1->0:写成
                        board[i][j] = 3;
//                    board[i][j] = 0;
                } else if (liveCount == 3 && board[i][j] == 0) {
                    board[i][j] = 2;//0->1:写成2
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int getLiveCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] index : indexs) {
            int x = index[0] + i;
            int y = index[1] + j;
            if (isValidIndex(x, y) && (board[x][y] == 1 || board[x][y] == 3)) {//3原来也是存活的
                count++;
            }
        }
        return count;
    }

    private boolean isValidIndex(int x, int y) {
        return !(x < 0 || x >= row || y < 0 || y >= col);
    }
}
