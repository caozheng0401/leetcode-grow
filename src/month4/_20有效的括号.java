package stack;

import java.util.HashMap;
import java.util.Stack;

/**
 *遇到左的括号，进栈，遇到右的符号，出栈并判断。如果直接遇到右符号直接出栈。
 * url:https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20有效的括号 {
    private HashMap<Character,Character> map = new HashMap<>();
    public _20有效的括号(){
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');
    }

    public boolean isValid1(String s) {
        while(s.contains("{}") ||
                s.contains("[]")  ||
                s.contains("()")
        ){
            s.replace("{}","");
            s.replace("()","");
            s.replace("[]","");
        }
        return s.isEmpty();
    }
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char a = s.charAt(i);
            if (map.containsKey(a)){
                stack.push(a);
            }else {
                if (stack.isEmpty()) return false;

                if (a != map.get(stack.pop()))
                 return false;
            }
        }
        return stack.isEmpty();
    }
}
