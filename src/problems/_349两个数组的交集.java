package problems;

/**
 * @author cz
 * @create 2021/5/31 21:09
 */

import java.util.HashSet;

/**
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 */
public class _349两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> integers = new HashSet<>();
        HashSet<Integer> integers1 = new HashSet<>();
        for (int i : nums1) {
            integers.add(i);
        }
        for (int i : nums2) {
            if (integers.contains(i)){
                integers1.add(i);
            }
        }
        int[] a = new int[integers1.size()];
        int index = 0;
        //将结果几何转为数组
        for (int i : integers1) {
            a[index++] = i;
        }
        return a;
    }
}
