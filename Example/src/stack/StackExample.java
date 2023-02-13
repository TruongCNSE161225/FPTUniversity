package stack;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("G");
        stack.push("o");
        stack.push("o");
        stack.push("d");
        stack.push("*");
        stack.push("*");
        stack.push("M");
        stack.push("o");
        stack.push("r");
        stack.push("*");
        stack.push("n");
        stack.push("i");
        stack.push("*");
        stack.push("*");
        stack.push("*");
        stack.push("n");
        stack.push("g");
        int pos = stack.search("*");
        System.out.println(stack);
        if(pos == 3){
            stack.pop();
        }
        System.out.println(stack);
    }
}
