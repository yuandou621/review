import java.util.Stack;

public class MYQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int a){
        while(!stack2.isEmpty()){
            int ret = stack2.pop();
            stack1.push(ret);
        }
        stack1.push(a);
    }
    public Integer pop(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            return null;
        }
        while(!stack1.isEmpty()){
            int ret = stack1.pop();
            stack2.push(ret);
        }
        return stack2.pop();
    }
    public int top(){
        while (!stack2.isEmpty()) {
            int ret = stack1.pop();
            stack2.push(ret);
        }
        return stack2.peek();
    }
}
