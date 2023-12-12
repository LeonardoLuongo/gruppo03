/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package calculator.release.stackexceptions;

/**
 *
 * @author francescolemmo
 */
public class StackIsFullException extends RuntimeException {

    /**
     * Creates a new instance of <code>StackIsFullException</code> without
     * detail message.
     */
    public StackIsFullException() {
    }

    /**
     * Constructs an instance of <code>StackIsFullException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StackIsFullException(String msg) {
        super(msg);
    }
}
