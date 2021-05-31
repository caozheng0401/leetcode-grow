package problems;

/**
 * @author cz
 * @create 2021/5/31 20:39
 */

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class _242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        int a[] = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            a[c - 'a']++;
        }
        char[] a1 = t.toCharArray();
        for (char c : a1) {
            a[c - 'a']--;
        }
        for (int i : a) {
            if (i != 0)
                return false;
        }
        return true;
    }

}
