/**
 * @program: Deli-AlgorithmEx
 * @description: 扑克牌中的顺子
 * @author: Shaobo.Qian
 * @create: 2020-05-07 06:53
 **/

package first;

public class jz_61 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0, 4, 5};
        jz_61 solution = new jz_61();
        boolean straight = solution.isStraight(nums);
        System.out.println("straight = " + straight);
    }

    public boolean isStraight(int[] nums) {
        int[] buffer = new int[14];
        //1.统计0的个数
        for (int i = 0; i < nums.length; i++) {
            buffer[nums[i]]++;
        }
        int endIdx = 0;
        for (int i = 1; i < buffer.length; i++) {
            if (buffer[i] > 1)
                return false;
            if (buffer[i] == 1)
                endIdx = i;
        }
        for (int i = 1; i < buffer.length; i++) {
            if (buffer[i] == 1)
                return endIdx - i <= 4;
        }
        //最远能到达的 idx
        return false;
    }
}
