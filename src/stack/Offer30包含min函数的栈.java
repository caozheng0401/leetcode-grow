package stack;

/**
 * @author cz
 * @create 2021/5/12 21:29
 */

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * url: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 解题思路：
 *        1. 设两个栈  一个栈 stack 存储元素   另一个栈 min 存取最小元素
 *        2. 当存入时  stack直接存入      min首先判断有没有元素，没有直接加，  有 判断一下值，小就添加
 *        3. 当删除时  stack直接删除      min与stack出去的值比较 相等也删除stack值
 */
public class MinStack {

    public Stack<Integer> stack ;
    public Stack<Integer> min ;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()){
            min.push(x);
        } else if (x <= this.min()){
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()){
            throw new RuntimeException();
        }
        int pop = stack.pop();
        if (pop == this.min()){
            min.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()){
            throw new RuntimeException();
        }
        return stack.peek();
    }

    public int min() {
        if (min.isEmpty()){
            throw new RuntimeException();
        }
        return min.peek();
    }
}
