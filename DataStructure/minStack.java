
class MyStack{
    private Queue<Integer> Q1 = new LinkedList<>();
    private Queue<Integer> Q2 = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Q2.offer(x);
    
        while (!Q1.isEmpty()) {
            Q2.offer(Q1.poll());
        }
        Queue<Integer> temp = Q1;
        Q1 = Q2;
        Q2 = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!empty()) {
            Q1.poll();
        }
    }

    // Get the top element.
    public int top() {
        if (!empty()) {
            return Q1.peek();
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return Q1.isEmpty();
    }
}




public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(number, minStack.peek()));
        }
    }

    public int pop() {
        minStack.pop();
        return stack.pop();
    }
    
    public int top(){
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}


class MinStack {
    Stack<Integer> stack=new Stack<>();
    int min=Integer.MAX_VALUE;
    
    public void push(int x) {
        if(x<=min) {stack.push(min); min=x;}
        stack.push(x);
        
    }
    
    public void pop() {
        if(stack.peek()==min){ stack.pop(); min=stack.pop(); }
        else stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
