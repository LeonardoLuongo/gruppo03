/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package calculator.exceptions.stackexceptions;

/**
 *
 * @author francescolemmo
 */
public class StackIsEmptyException extends RuntimeException {

    /**
     * Creates a new instance of <code>StackIsEmptyException</code> without
     * detail message.
     */
    public StackIsEmptyException() {
    }

    /**
     * Constructs an instance of <code>StackIsEmptyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StackIsEmptyException(String msg) {
        super(msg);
    }
}
