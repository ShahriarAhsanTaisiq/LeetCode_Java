package RegularPractice;
/* 225. Implement Stack using Queues
* Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
Implement the MyStack class:
void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:
You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, top, and empty.
All the calls to pop and top are valid.

* */

import java.util.LinkedList;
import java.util.Queue;

class MyStack{
    Queue<Integer> queue;
    public MyStack(){
        queue = new LinkedList<>();
    }
    public void push(int x){
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++){
            queue.offer(queue.poll());
        }
    }
    public int pop(){
        return queue.remove();
    }
    public int top(){
        return queue.peek();
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
public class LeetCode225 {
    public static void main(String[] args) {
        // Create a new stack
        MyStack myStack = new MyStack();

        // Perform operations as described in the example

        // Push 1 onto the stack
        myStack.push(1);
        System.out.println("Pushed 1");

        // Push 2 onto the stack
        myStack.push(2);
        System.out.println("Pushed 2");

        // Get the top element (should be 2)
        System.out.println("Top element: " + myStack.top()); // Output: 2

        // Pop the top element (should be 2)
        System.out.println("Popped element: " + myStack.pop()); // Output: 2

        // Check if the stack is empty (should return false)
        System.out.println("Is the stack empty? " + myStack.empty()); // Output: false

        // Pop the last element (should be 1)
        System.out.println("Popped element: " + myStack.pop()); // Output: 1

        // Check if the stack is empty (should return true)
        System.out.println("Is the stack empty? " + myStack.empty()); // Output: true
    }
}
