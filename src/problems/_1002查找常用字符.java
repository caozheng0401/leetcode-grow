package problems;

/**
 * @author cz
 * @create 2021/5/31 20:43
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 */
public class _1002查找常用字符 {
    public List<String> commonChars(String[] words) {
        if (words.length == 0) {
            return null;
        }

        int[] init = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            init[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] init1 = new int[26];
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                init1[words[i].charAt(i1) - 'a']++;
            }
            for (int k = 0;k<26;k++) {
                init[k] = Math.min(init[k], init1[k]);
            }
        }
        ArrayList<String> re = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while(init[i] != 0){
                char c = (char) (i+'a');
                re.add(String.valueOf(c));
                init[i]--;
            }
        }
        return re;
    }
}
