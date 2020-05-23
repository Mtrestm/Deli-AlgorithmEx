/**
 * @program: Deli-AlgorithmEx
 * @description: 跳跃游戏
 * @author: Shaobo.Qian
 * @create: 2020-04-17 06:24
 **/

public class lc_55 {

    /**
     * 贪心:记录每个位置能到达的最远距离(只关注最远能到达的距离),只要有一个达到最远距离即返回 true
     *
     * @question : 1.如何记录每个位置能到达的最远距离
     * @author Shaobo.Qian
     * @date 2020/4/17
     */
    public boolean canJump1(int[] nums) {
        if (nums.length <= 1)
            return true;
        int targetLen = nums.length;
        int maxLen = 0;//从当前位置能到达的最远距离(记录每个位置能到达的最远距离)
        for (int i = 0; i < nums.length - 1; i++) {
            //maxLen -1:是每次往前遍历走一步,在上一步的最远举例是 maxLen,往前走一步消耗了1,所以当前是 maxLen-1
            maxLen = Math.max(maxLen - 1, nums[i]);
            if (maxLen == 0 && nums[i] == 0)//无法前进了
                return false;
            targetLen--;//目标距离
            if (maxLen >= targetLen)
                return true;

        }
        return false;
    }

    /**
     * 贪心(只关注最远能到达的距离)
     *
     * @author Shaobo.Qian
     * @date 2020/4/17
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return true;
        int maxIdx = 0;
        for (int i = 0; i < len; i++) {
            if (i <= maxIdx) {//能到达的索引位置
                maxIdx = Math.max(maxIdx, i + nums[i]);
                if (maxIdx > len - 1)
                    return true;

            }
        }
        return false;
    }
}
