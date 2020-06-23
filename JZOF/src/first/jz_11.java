/**
 * @program: Deli-AlgorithmEx
 * @description: 旋转数组的最小数字
 * @author: Shaobo.Qian
 * @create: 2020-03-06 07:26
 **/

package first;

public class jz_11 {
    public static void main(String[] args) {

    }
    /**
     * anki
     * @question:
     * 1.二分查找的适用范围(任何能通过条件将数组不断缩小边界找到查找目标的情况)?
     * 2.二分查找查找旋转点的方法是如何在不同情况下收缩边界的?
     * @author Shaobo.Qian
     * @date 2020/3/6
     * @link https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/mian-shi-ti-11-xuan-zhuan-shu-zu-de-zui-xiao-shu-3/
     */
    public int minArray(int[] numbers) {//[3,4,5,1,2] ==>1 ,左边5最大值 ==> [3,4,5,1,2,3,4,5,1,2]

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int m = (left + right) / 2;
            if (numbers[m] >numbers[right]) left = m + 1; //旋转点一定在[m+1,j] 的闭区间里
            else if(numbers[m]< numbers[right]) right = m;//旋转点一定在[i,m] 的闭区间里
            else right = right - 1;//相等的情况,右指针收缩一位不影响旋转点仍在[left,right]中
        }
        //返回旋转点
        return numbers[left];
    }
}
