package problems;

import java.util.Stack;

/**
 * @author cz
 * @create 2021/6/6 23:41
 */
public class _1047删除字符串中的所有相邻重复项 {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (characters.isEmpty()){
                characters.add(chars[i]);
            }else {
                if (chars[i] == characters.peek()){
                    characters.pop();
                }else {
                    characters.push(chars[i]);
                }
            }
        }
        StringBuilder re = new StringBuilder();
        for (Character character : characters) {
            re.append(character);
        }
        return re.toString();
    }
}
