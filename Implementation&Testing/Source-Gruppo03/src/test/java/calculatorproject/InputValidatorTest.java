/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static calculatorproject.InputValidator.CorrectInputFormat;

/**
 *
 * @author francescolemmo
 */
public class InputValidatorTest {
    
    InputValidator instance;
    
    public InputValidatorTest() {
        instance = new InputValidator();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidInput method, of class InputValidator.
     */
    @Test
    public void testIsValidInput1() {
        System.out.println("isValidInput: positive real");
        CorrectInputFormat correctInput = new CorrectInputFormat("+12");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput2() {
        System.out.println("isValidInput: negative real");
        CorrectInputFormat correctInput = new CorrectInputFormat("-3");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput3() {
        System.out.println("isValidInput: positive real");
        CorrectInputFormat correctInput = new CorrectInputFormat("+76.4");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput4() {
        System.out.println("isValidInput: wrong string");
        CorrectInputFormat correctInput = new CorrectInputFormat("-test");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(false, result);
    }
    
    @Test 
    public void testIsValidInput5() throws IllegalArgumentException {
        System.out.println("isValidInput: space between numbers");
        CorrectInputFormat correctInput = new CorrectInputFormat("2  2");
        assertThrows(IllegalArgumentException.class, () -> {
            instance.isValidInput(correctInput);
        });
    }
    
    @Test
    public void testIsValidInput6() throws IllegalArgumentException {
        System.out.println("isValidInput: number after j");
        CorrectInputFormat correctInput = new CorrectInputFormat("2j  2");
        assertThrows(IllegalArgumentException.class, () -> {
            instance.isValidInput(correctInput);
        });
    }
    
    @Test
    public void testIsValidInput7() {
        System.out.println("isValidInput: double operator");
        CorrectInputFormat correctInput = new CorrectInputFormat("+2 + 34 -3j");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(false, result);
    }
    
    @Test
    public void testIsValidInput8() {
        System.out.println("isValidInput: operation");
        CorrectInputFormat correctInput = new CorrectInputFormat("*");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput9() {
        System.out.println("isValidInput: operation");
        CorrectInputFormat correctInput = new CorrectInputFormat("/");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput10() {
        System.out.println("isValidInput: wrong string");
        CorrectInputFormat correctInput = new CorrectInputFormat("cia/o");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(false, result);
    }
    
    @Test
    public void testIsValidInput11() {
        System.out.println("isValidInput: wrong variable operation");
        CorrectInputFormat correctInput = new CorrectInputFormat("c<");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(false, result);
    }
    
    @Test
    public void testIsValidInput12() {
        System.out.println("isValidInput: operation");
        CorrectInputFormat correctInput = new CorrectInputFormat("inv");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput13() {
        System.out.println("isValidInput: stack operation");
        CorrectInputFormat correctInput = new CorrectInputFormat("dup");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput14() {
        System.out.println("isValidInput: stack operation different cases");
        CorrectInputFormat correctInput = new CorrectInputFormat("dUp");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput15() {
        System.out.println("isValidInput: imaginary number");
        CorrectInputFormat correctInput = new CorrectInputFormat("5j");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsValidInput16() throws IllegalArgumentException {
        System.out.println("isValidInput: empty string");
        CorrectInputFormat correctInput = new CorrectInputFormat("");
        assertThrows(IllegalArgumentException.class, () -> {
            instance.isValidInput(correctInput);
        });
    }

    @Test
    public void testIsValidInput17() {
        System.out.println("isValidInput: string null");
        CorrectInputFormat correctInput = new CorrectInputFormat("null");
        boolean result = instance.isValidInput(correctInput);
        assertEquals(false, result);
    }
    
    
    /**
     * Test of isComplexNumber method, of class InputValidator.
     * 
     */
    @Test
    public void testIsComplexNumber1() {
        System.out.println("isComplexNumber: positive real");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("+48.3");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber2() {
        System.out.println("isComplexNumber: negative real");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("-73.11");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber3() {
        System.out.println("isComplexNumber: positive imaginary");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("+76.4j");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber4() {
        System.out.println("isComplexNumber: negative imaginary");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("-234.222j");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber5() {
        System.out.println("isComplexNumber: positive real, positive imaginary");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("+2.23 + 34j");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber6() {
        System.out.println("isComplexNumber: negative real, positive imaginary");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("-65.4 + 863j");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber7() {
        System.out.println("isComplexNumber: positive real, negative imaginary");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("431 - 126.55j");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }
    
    @Test
    public void testIsComplexNumber8() {
        System.out.println("isComplexNumber: negative real, negative imaginary");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("-102.428 - 234j");
        boolean result = instance.isComplexNumber(correctInput);
        assertEquals(true, result);
    }

    
    /**
     * Test of operationCode method, of class InputValidator.
     * 
     */
    @Test
    public void testOperationCode1() {
        System.out.println("operationCode: addition");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("+");
        int result = instance.operationCode(correctInput);
        assertEquals(0, result);
    }
    
    @Test
    public void testOperationCode2() {
        System.out.println("operationCode: subtraction");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("-");
        int result = instance.operationCode(correctInput);
        assertEquals(1, result);
    }
    
    @Test
    public void testOperationCode3() {
        System.out.println("operationCode: multiplication");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("*");
        int result = instance.operationCode(correctInput);
        assertEquals(2, result);
    }

    @Test
    public void testOperationCode4() {
        System.out.println("operationCode: division");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("/");
        int result = instance.operationCode(correctInput);
        assertEquals(3, result);
    }
    
    @Test
    public void testOperationCode5() {
        System.out.println("operationCode: square root");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("sqrt");
        int result = instance.operationCode(correctInput);
        assertEquals(4, result);
    }
    
    @Test
    public void testOperationCode6() {
        System.out.println("operationCode: sign inversion");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("inv");
        int result = instance.operationCode(correctInput);
        assertEquals(5, result);
    }

    @Test
    public void testOperationCode7() {
        System.out.println("operationCode: assign in variable");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat(">v");
        int result = instance.operationCode(correctInput);
        assertEquals(6, result);
    }
    
    @Test
    public void testOperationCode8() {
        System.out.println("operationCode: push from variable");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("<a");
        int result = instance.operationCode(correctInput);
        assertEquals(7, result);
    }
    
    @Test
    public void testOperationCode9() {
        System.out.println("operationCode: addition with variable");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("+f");
        int result = instance.operationCode(correctInput);
        assertEquals(8, result);
    }

    @Test
    public void testOperationCode10() {
        System.out.println("operationCode: subtraction with variable");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("-g");
        int result = instance.operationCode(correctInput);
        assertEquals(9, result);
    }
    
    @Test
    public void testOperationCode11() {
        System.out.println("operationCode: duplicate the last value in the stack");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("dup");
        int result = instance.operationCode(correctInput);
        assertEquals(10, result);
    }
    
    @Test
    public void testOperationCode12() {
        System.out.println("operationCode: remove the last value in the stack");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("drop");
        int result = instance.operationCode(correctInput);
        assertEquals(11, result);
    }

    @Test
    public void testOperationCode13() {
        System.out.println("operationCode: swap the last two values in the stack");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("swap");
        int result = instance.operationCode(correctInput);
        assertEquals(12, result);
    }
    
    @Test
    public void testOperationCode14() {
        System.out.println("operationCode: clear the entire stack");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("clear");
        int result = instance.operationCode(correctInput);
        assertEquals(13, result);
    }
    
    @Test
    public void testOperationCode15() {
        System.out.println("operationCode: duplicate the second-last value in the stack");
        InputValidator.CorrectInputFormat correctInput = new CorrectInputFormat("over");
        int result = instance.operationCode(correctInput);
        assertEquals(14, result);
    }
    
}
