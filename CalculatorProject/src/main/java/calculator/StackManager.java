/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;

import java.util.ListIterator;
import java.util.Stack;

/**
 *
 * @author francescolemmo
 */
public class StackManager {

    private Stack<ComplexNumber> stack;
    private final int maxSize = 50;

    public StackManager() {
        stack = new Stack<>();
    }

    public void dup() throws NotEnoughElementsException {
        if (stack.isEmpty()) 
            throw new NotEnoughElementsException("At least 1 element is needed.\n");

        ComplexNumber n = this.top();
        this.push(n);

    }

    public void drop() throws NotEnoughElementsException {
        if (stack.isEmpty()) 
            throw new NotEnoughElementsException("At least 1 element is needed.\n");
        
        this.pop();

    }

    public void swap() throws NotEnoughElementsException {
        if (stack.size() < 2) 
            throw new NotEnoughElementsException("At least 2 elements are needed.\n");
        
        ComplexNumber n1 = this.pop();
        ComplexNumber n2 = this.pop();
        this.push(n1);
        this.push(n2);
    }

    public void over () throws NotEnoughElementsException {
        if (stack.size() < 2) 
            throw new NotEnoughElementsException("At least 2 elements are needed.\n");
        
        ComplexNumber n1 = this.pop();
        ComplexNumber copyN2 = this.top();
        this.push(n1);
        this.push(copyN2);
    }

    public void clear() {
        stack.clear();
    }
    
    public void push(ComplexNumber number) throws StackIsFullException {
        if (stack.size() == this.maxSize) {
            throw new StackIsFullException("Stack Is Full\n");
        }
        else
            stack.push(number);
    }

    public ComplexNumber pop() throws StackIsEmptyException {
        if (stack.isEmpty()) {
            throw new StackIsEmptyException("Stack Is Empty\n");
        }
        else
            return stack.pop();
    }

    public ComplexNumber top() throws StackIsEmptyException {
        if (stack.isEmpty()) {
            throw new StackIsEmptyException("Stack Is Empty\n");
        }
        else
            return stack.peek();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("STACK:\n");
        
        if (stack.isEmpty())
            return sb.toString();
        
        ListIterator<ComplexNumber> i = stack.listIterator(stack.lastIndexOf(stack.lastElement()) + 1);
        
        while(i.hasPrevious()) {
            sb.append(" | ").append(i.previous().toString()).append(" |").append("\n");
        }

        return sb.toString();
    }

}