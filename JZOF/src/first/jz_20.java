/**
 * @program: Deli-AlgorithmEx
 * @description: 表示数值的字符串
 * @author: Shaobo.Qian
 * @create: 2020-05-01 06:25
 **/

package first;

/**
 * @question:
 * 1.有限状态机(DFA)分为哪两种状态?
 * 2.该题中的输入字符有哪几种,作为二维状态数组的什么?
 * 3.状态机中的状态如何转化? (//处于某种状态行 state 下,输入新的字符(col列对应的字符)===>新的状态
 *             state = transfer[state][col];)
 * 4.为什么所有的终止态都要跟上一个状态 8,用来处理什么?
 * 状态机
 * @author Shaobo.Qian
 * @date 2020/5/1
 */
public class jz_20 {

    /**
     * 返回二维数组的列 (列对应的是可输入的字符)
     */
    public int make(char c) {
        switch (c) {
            case ' ':
                return 0;
            case '+':
            case '-':
                return 1;
            case '.':
                return 3;
            case 'e':
                return 4;
            default:
                if (c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        int state = 0;//状态行row
        int[][] transfer = new int[][]{
                {0, 1, 6, 2, -1},
                {-1, -1, 6, 2, -1},
                {-1, -1, 3, -1, -1},
                {8, -1, 3, -1, 4},
                {-1, 7, 5, -1, -1},
                {8, -1, 5, -1, -1},
                {8, -1, 6, 3, 4},
                {-1, -1, 5, -1, -1},
                {8, -1, -1, -1, -1}};
        char[] ss = s.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            int col = make(ss[i]);
            if (col < 0) return false;
            //处于某种状态行 state 下,输入新的字符(col列对应的字符)===>新的状态
            state = transfer[state][col];
            if (state < 0) return false;
        }

        //如果能到达终止状态3,5,6
        //终止状态8 用来处理字符串末尾的空格,比如("1 ")
        if (state == 3 || state == 5 || state == 6 || state == 8)
            return true;
        else
            return false;
    }
}
