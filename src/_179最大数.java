/**
 * @author cz
 * @create 2021/4/20 8:19
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 链接：https://leetcode-cn.com/problems/largest-number/
 *
 * 解题思路:因为排列数的大小，我就想到把9的放前面，但是我不会把位单个拆了，所以我转化为String形式，比较他们的ASCII码，
 *         想到用sort在穿进去一个comparator，在comparator里面定义谁大谁在前面，compareto方法，如果升序，正着来，
 *         降序就反着来，并且添加了0的判断，因为测试他用的00，就加入了这个，最后在拿stringbuilder添加上。
 */
public class _179最大数 {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        String[] a = new String[length];
        for (int i = 0; i < length; i++) {
            a[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });
        if ("0".equals(a[0])){
            return "0";
        }
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < length; i++) {
            b.append(a[i]);
        }
        return b.toString();

    }
}
