/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.util.Stack;

/**
 *
 * @author francescolemmo
 */
public class StackManager {

    private Stack<ComplexNumber> stack;

    public StackManager() {
        stack = new Stack<>();
    }

    public void dup() {
        ComplexNumber n = this.top();
        this.push(n);
    }

    public void drop() {
        this.pop();
    }

    public void swap() {
        ComplexNumber n1 = this.pop();
        ComplexNumber n2 = this.pop();
        this.push(n1);
        this.push(n2);
    }

    public void clear() {
        stack.clear();
    }

    public void over () {
        ComplexNumber n1 = this.pop();
        ComplexNumber copyN2 = this.top();
        this.push(n1);
        this.push(copyN2);
    }

    public void push(ComplexNumber number) {
        stack.push(number);
    }

    public ComplexNumber pop() {
        return stack.pop();
    }

    public ComplexNumber top() {
        return stack.peek();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("STACK:\n");

        for(ComplexNumber number : stack) {
            sb.append(" | ").append(number.toString()).append(" |").append("\n");
        }

        return sb.toString();
    }

}