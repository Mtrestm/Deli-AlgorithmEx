/**
 * @program: Deli-AlgorithmEx
 * @description: 车的可用捕获量
 * @author: Shaobo.Qian
 * @create: 2020-03-26 05:09
 **/

package first;

public class lc_999 {
    public static void main(String[] args) {
        char[][] board = {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};

        int res = numRookCaptures(board);
        System.out.println("res = " + res);
    }


    /**
     * @author Shaobo.Qian
     * @date 2020/3/26
     */
    public static int numRookCaptures(char[][] board) {

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    int res = 0;
                    // 模拟白车的上、下、左、右四个方向上前进
                    for (int[] dir : directions) {
                        int x = i, y = j;
                        while (true) {
                            x += dir[0];
                            y += dir[1];
                            if (x < 0 || x >= 8 || y < 0 || y >= 8 || board[x][y] == 'B')
                                break;
                            if (board[x][y] == 'p') {
                                res++;
                                break;
                            }
                        }

                    }
                    return res;
                }
            }
        }
        return 0;
    }

}
