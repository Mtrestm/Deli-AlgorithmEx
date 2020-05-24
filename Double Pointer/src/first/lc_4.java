/**
 * @program: Deli-AlgorithmEx
 * @description:寻找两个正序数组的中位数
 * @author: Shaobo.Qian
 * @create: 2020-05-24 06:46
 **/

package first;

public class lc_4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {};
//        int[] nums2 = {3, 4};
        lc_4 solution = new lc_4();
        double res = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("res = " + res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;


        int targetIdx = (len1 + len2) / 2;//3,3==>3,4
        int[] target = new int[targetIdx + 1];
        int len = target.length;

        int left1 = 0, left2 = 0;
        while (targetIdx >= 0 && left1 < len1 && left2 < len2) {
            target[len - (targetIdx + 1)] = Math.min(nums1[left1], nums2[left2]);
            if (nums1[left1] <= nums2[left2]) {
                left1++;
            } else {
                left2++;
            }
            targetIdx--;
        }
        while (targetIdx >= 0) {
            if (left1 == len1 || len1 ==0) {
                target[len - (targetIdx + 1)] = nums2[left2++];
            } else {
                target[len - (targetIdx + 1)] = nums1[left1++];
            }
            targetIdx--;

        }

        return (len1 + len2) % 2 == 0 ? (target[len - 1] + target[len - 2]) / 2.0 : target[len - 1];
    }
}
