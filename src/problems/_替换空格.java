package problems;

/**
 * @author cz
 * @create 2021/6/2 18:53
 */

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class _替换空格 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        int length = s.length() -1;
        int count = 0;
        for (int i = 0; i <= length; i++) {
            if (chars[i] == ' '){
                count++;
            }
        }
        char[] result = new char[s.length() + 2 * count ];
        int newLength = result.length -1 ;
    while (length >= 0){
        if (chars[length] == ' '){
            result[newLength] = '0';
            result[newLength - 1] = '2';
            result[newLength - 2] = '%';
            newLength -= 3;
            length --;
        }else {
            result[newLength] = chars[length];
            newLength--;
            length--;
        }
    }
        return String.valueOf(result);
    }
}
