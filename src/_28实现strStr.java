/**
 * @author cz
 * @create 2021/4/20 9:06
 */

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解题思路：
 */
public class _28实现strStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()){
            return 0;
        }
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                i = i - j +1;
                j = 0;
            }
            if (j == needle.length()){
                return i-j;
            }
        }
        return -1;

    }
}
