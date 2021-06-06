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
//        if (needle.isEmpty()){
//            return 0;
//        }
//        int i = 0;
//        int j = 0;
//        while(i < haystack.length() && j < needle.length()){
//            if (haystack.charAt(i) == needle.charAt(j)){
//                i++;
//                j++;
//            }else {
//                i = i - j +1;
//                j = 0;
//            }
//            if (j == needle.length()){
//                return i-j;
//            }
//        }
//        return -1;
        if (needle.length() == 0){
            return 0;
        }
        int next[] = new int[needle.length()];
        getNext(next,needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while(j >=0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if (j == (needle.length() - 1)){
                return (i - needle.length() +1);
            }
        }
        return -1;

    }

    private void getNext(int[] next, String moodle){
        char[] mod = moodle.toCharArray();
        int j = -1;
        next[0] = j;
        for (int i = 1; i < next.length; i++) {
            while(j>=0 && mod[i] != mod[j+1]){
                j = next[j];
            }
            if (mod[i] == mod[j+1]){
                j++;
            }
            next[i] = j;
        }
    }
}
