/**
 * @program: Deli-AlgorithmEx
 * @description: 矩阵中的路径
 * @author: Shaobo.Qian
 * @create: 2020-03-06 20:52
 **/

package first;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class jz_12 {

    /**
     * 回溯法
     * @question:
     * @author Shaobo.Qian
     * @date 2020/3/8
     * @link https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/solution/mian-shi-ti-12-ju-zhen-zhong-de-lu-jing-shen-du-yo/
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,words,i,j,0)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        //terminator
        if(i<0 || i>= board.length || j <0 || j>=board[0].length || board[i][j] != words[k]) return false;
        //current level
        if (k == words.length -1) return true;
        char temp = board[i][j];
        board[i][j] = '/';//统一条搜索路径中,已经访问过该元素;为什么改成'/'字符?因为改成'/'字符后,"/"字符不和 board 中任何其它字符匹配
        //drill down(按山下右左的顺序往下一层搜素)
        boolean res =  dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1) || dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i, j - 1, k + 1);
        //恢复当前层状态
        board[i][j] = temp;
        return res;
    }

    /**
     * 原解:(思路不对,未解出)
     * BFS或者字典树
     *
     * @author Shaobo.Qian
     * @date 2020/3/6
     */
    public boolean exist1(char[][] board, String word) {

        //row*i +col*j ==>首先给二维数组中每个元素一个唯一标识
        //从左上角开始BFS 搜索
        int rows = board.length;
        int cols = board[0].length;
        int maxIdx = rows * cols - 1;
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //索引在[0,rows*cols)之间
                map.put(i * cols + j, board[i][j]);
            }
        }
        int wordIdx = 0;
        int wLen = word.length();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer index = queue.poll();
            if (map.containsKey(index)) {
                Character character = map.get(index);
                if (character == word.charAt(wordIdx)) {
                    if (wordIdx == wLen) return true;
                    else wordIdx++;
                }
                map.remove(index);
                //上下左右的索引加入 queue
                if (0 <= index - 1 && map.containsKey(index - 1)) {
                    queue.add(index - 1);
                }
                if ( index + 1 < maxIdx && map.containsKey(index+1)) {
                    queue.add(index - 1);
                }
                if (0 <= index - cols && map.containsKey(index-cols)) {
                    queue.add(index - cols);
                }
                if (index + cols < maxIdx && map.containsKey(index + cols)) {
                    queue.add(index + cols);
                }
            }

        }
        return false;
    }
}
