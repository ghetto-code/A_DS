package Stack;

public class Main {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(12);
        stack.push(13);
        stack.push(14);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
