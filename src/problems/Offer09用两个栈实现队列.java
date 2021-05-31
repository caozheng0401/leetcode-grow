package problems;

import java.util.Stack;

/**
 * @author cz
 * @create 2021/5/12 21:52
 */

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * url:https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * 解题思路 : 实现队列，头删尾插 ， 说明得用两个栈， 一个添加，一个删除，但当删除时必须得倒序，说明我们得见一个倒序的函数
 *          但这个倒叙函数必须得当删除不剩一个数的时候使用，因为当 添加的是12 删除第一个2 再添加 34 要是添加 删除的就是 4 而不是1
 *          就导致错误。
 */
public class CQueue {

    public Stack<Integer> push;
    public Stack<Integer> pop;

    public CQueue() {
        this.push = new Stack<>();
        this.pop = new Stack<>();

    }
    private void pushToPop(){
        if (this.pop.empty()){
            while (!this.push.empty()){
                this.pop.push(this.push.pop());
            }
        }
    }
    public void appendTail(int value) {
        this.push.push(value);
        pushToPop();
    }

    public int deleteHead() {
        if (pop.empty() && push.empty()){
            return -1;
        }
        pushToPop();
        return pop.pop();
    }


}
