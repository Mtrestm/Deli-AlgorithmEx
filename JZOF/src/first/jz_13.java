/**
 * @program: Deli-AlgorithmEx
 * @description: 机器人的运动范围
 * @author: Shaobo.Qian
 * @create: 2020-03-11 07:54
 **/

package first;

public class jz_13 {

    public static void main(String[] args) {
        boolean[][] booleans = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println("booleans = " + booleans[i][j]);
            }
        }
//        int count = movingCount(11, 8, 16);
//        System.out.println("count = " + count);
        boolean usable = isUsable(10, 7, 11, 8, 16);
        System.out.println("usable = " + usable);
    }

    /**
     * dfs
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     */
    static boolean[][] visited;

    /*static int count;
    public static int movingCount(int m, int n, int k) {
        //是否访问过格子
        visited = new boolean[m][n];
        count = 0;
        //边界判断
        //行坐标和列坐标的数位之和大于k的格子
        //上下左右四个方向去dfs
        dfs(0, 0, m, n, k);
        return count;
    }
    private static void dfs(int x, int y, int m, int n, int k) {
        //terminator
        if (!isUsable(x, y, m, n, k) || visited[x][y]) return;
        //current level
        count++;
        System.out.println(" count = " + count + " " + x + " " + y + " ");
        visited[x][y] = true;
        //drill down
        dfs(x, y - 1, m, n, k);
        dfs(x, y + 1, m, n, k);
        dfs(x - 1, y, m, n, k);
        dfs(x + 1, y, m, n, k);
    }*/
    public static int movingCount(int m, int n, int k) {
        //是否访问过格子
        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);

    }
    private static int dfs(int x, int y, int m, int n, int k) {
        //terminator
        if (!isUsable(x, y, m, n, k) || visited[x][y]) return 0;
        visited[x][y] = true;
        //上下左右四个方向去dfs
        return dfs(x, y - 1, m, n, k) + dfs(x, y + 1, m, n, k) + dfs(x - 1, y, m, n, k) + dfs(x + 1, y, m, n, k) + 1;
    }
    /**
     * 是否是行坐标和列坐标的数位之和不大于k的格子
     *
     * @author Shaobo.Qian
     * @date 2020/3/11
     */
    private static boolean isUsable(int x, int y, int m, int n, int k) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1) return false;
        int sumX = x >= 10 ? x / 10 + x % 10 : x;
        int sumY = y >= 10 ? y / 10 + y % 10 : y;
        return sumX + sumY <= k;
    }
}
