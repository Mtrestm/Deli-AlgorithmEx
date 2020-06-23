/**
 * @program: Deli-AlgorithmEx
 * @description: 数组中的逆序对
 * @author: Shaobo.Qian
 * @create: 2020-04-24 07:20
 **/

public class jz_51 {
    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        jz_51 jz_51 = new jz_51();
        int count = jz_51.reversePairs(nums);
        System.out.println("count = " + count);
    }
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len<2)
            return 0;
//        int[] copy = new int[len];
//        for (int i = 0; i < len; i++) {
//            copy[i] = nums[i];
//        }
        int[] temp = new int[len];
        int cnt = reversePairs(nums, 0, len - 1, temp);
        return cnt;
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        //1.terminator
        if (left == right)
            return 0;
        //2.current level (divide subproblems)
        int mid = left + (right - left) / 2;
        //leftParis:左边数组完成排序需要处理的逆序对
        int leftParis = reversePairs(nums, left, mid, temp);
        //rightParis:右边数组完成排序需要处理的逆序对
        int rightParis = reversePairs(nums, mid + 1, right, temp);
        //3.1合并结果 如果整个数组已经有序，则无需合并，注意这里使用小于等于
        if (nums[mid] <= nums[mid + 1]) {
            return leftParis + rightParis;
        }
        //3.2合并结果 crossPairs:左右数组完成归并排序需要处理的逆序对
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftParis + rightParis + crossPairs;
    }

    /**
     * anki
     * @question: 1.归并排序里五个指针(i,j,mid,left,right)各指向的位置 2.如何借助归并排序(分治思想)来统计逆序对?关键是在哪一步里统计,如何统计?
     * 归并排序
     * nums[left..mid] 有序，nums[mid + 1..right] 有序
     * @author Shaobo.Qian
     * @date 2020/4/24
     */
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int i = left;//指向左边数组的起始位置
        int j = mid + 1;//指向右边数组的起始位置
        int count = 0;
        for (int k = left; k <= right; k++) {
            // 有下标访问，得先判断是否越界
            if (i == mid + 1) { //左边数组元素已经归并完了,直接从右边数组取元素
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {//右边数组元素已经归并完了,直接从左边数组取元素
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {//左边数组元素小于右边数组元素,取左边元素
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                // 在 j 指向的元素归并回去的时候，计算逆序对的个数，只多了这一行代码;即左边还剩(mid - i + 1)个元素都和当前右边数组指针j指向的元素构成了逆序对
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
