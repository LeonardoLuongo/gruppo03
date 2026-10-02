/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package calculatorproject.exceptions;

/**
 *
 * @author francescolemmo
 */
public class NotEnoughElementsException extends RuntimeException {

    /**
     * Creates a new instance of <code>NotEnoughElementsException</code> without
     * detail message.
     */
    public NotEnoughElementsException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughElementsException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughElementsException(String msg) {
        super(msg);
    }
}
