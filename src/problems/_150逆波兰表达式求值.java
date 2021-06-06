package problems;

import java.util.Stack;

/**
 * @author cz
 * @create 2021/6/6 23:53
 */
public class _150逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        if(n<=0)return 0;
        for(int i=0;i<n;i++){
            try {
                int num = Integer.parseInt(tokens[i]);
                stack.push(num);
            }catch (Exception e){
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (tokens[i]){
                    case "+":stack.push(num1 + num2);break;
                    case "-":stack.push(num2 - num1);break;
                    case "*":stack.push(num1 * num2);break;
                    case "/":stack.push(num2 / num1);break;
                }
            }
        }
        return stack.pop();
    }
}
