package RegularPractice;

/* 232. Implement Queue using Stacks

* Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.

Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.
* */

import java.util.Stack;

class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void MyQueue() {

    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

public class LeetCode232 {
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();

        // Pushing elements into the queue
        queue.push(1);
        queue.push(2);
        queue.push(3);

        // Checking front element
        System.out.println("Front element (peek): " + queue.peek()); // Expected: 1

        // Popping elements
        System.out.println("Popped: " + queue.pop()); // Expected: 1
        System.out.println("Popped: " + queue.pop()); // Expected: 2

        // Checking front element again
        System.out.println("Front element (peek): " + queue.peek()); // Expected: 3

        // Checking if queue is empty
        System.out.println("Is queue empty? " + queue.empty()); // Expected: false

        // Popping last element
        System.out.println("Popped: " + queue.pop()); // Expected: 3

        // Checking if queue is empty after popping all elements
        System.out.println("Is queue empty? " + queue.empty()); // Expected: true
    }
}
