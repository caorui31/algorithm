package raymond.project.ms;

import java.util.Stack;

public class StackToQueue<T> {

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void append(T element) {
        stack1.push(element);
    }

    public T deleteHead() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        if(stack2.isEmpty()) {
            throw new RuntimeException("queue is empty");
        }

        return stack2.pop();
    }


    public static void main(String[] args) {
        StackToQueue<Integer> queue = new StackToQueue<>();
        queue.append(1);
        queue.append(2);
        queue.append(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
