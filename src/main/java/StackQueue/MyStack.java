package StackQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author abaka
 * @date 2019/7/23 10:22
 */

/**
 * 思路：一个队列入元素，一个队列当作栈顶永远只保存一个元素，当入栈时，判断另外一个队列中是否有元素，如果有先将这个元素入队后入新的元素
 * 出队直接出队2的元素，如果队2为空，将队1的元素依次入到队2中剩余1个元素，交换两个队列，然后出队2的元素，
 * Top时，和队2一样，只是不remove元素，将元素第一个得到就好
 */
public class MyStack {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(!queue2.isEmpty())
            queue1.add(queue2.remove());
        queue1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queue2.isEmpty())
            return queue2.remove();
        while (queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        //queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.remove();
    }

    /** Get the top element. */
    public int top() {
        if (!queue2.isEmpty())
            return queue2.peek();
        while (queue1.size() > 1){
            queue2.add(queue1.remove());
        }
        //queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

