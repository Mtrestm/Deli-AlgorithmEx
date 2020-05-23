/**
 * @program: Deli-AlgorithmEx
 * @description: 矩形重叠
 * @author: Shaobo.Qian
 * @create: 2020-03-18 08:54
 **/

package first;

public class lc_836 {
    /**
     * 逆向思维解题
     * @author Shaobo.Qian
     * @date 2020/3/18
     *
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //rec2固定,rec1在它的上下左右位置
        return !(rec1[2] <= rec2[0] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec1[3] <= rec2[1]);
    }

    /**
     * @author Shaobo.Qian
     * @date 2020/3/18
     */
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec2[2];
        int y2 = rec2[3];
//        int rows = Math.abs(x2 - x1);
        int cols = Math.abs(y2 - y1);

        if (x2 >= x1) {
            int res1 = (rec1[2] + cols * rec1[3]);
            int res2 = (rec2[0] + cols * rec2[1]);
            return res1 > res2;
        } else {
            int res1 = (rec1[0] + cols * rec1[1]);
            int res2 = (rec2[2] + cols * rec2[3]);
            return res2 > res1;
        }
    }
}
