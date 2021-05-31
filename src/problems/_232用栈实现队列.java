import java.util.Stack;

/**
 *准备2个栈：inStack、outStack
 * 	入队时，push 到 inStack 中
 * 	出队时
 * 如果 outStack 为空，将 inStack 所有元素逐一弹出，push 到 outStack，outStack 弹出栈顶元素
 * 如果 outStack 不为空， outStack 弹出栈顶元素
 * url:https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
public class _232用栈实现队列 {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    /** Initialize your data structure here. */
    public _232用栈实现队列() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }

        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }

        }
        return outStack.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }
}
