/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorproject;

import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import calculatorproject.exceptions.NotEnoughElementsException;
/**
 *
 * @author leonardoluongo, francescolemmo
 */
public class CalculatorTest {
    Calculator calculator;
    
    public CalculatorTest() {
        calculator = new Calculator();
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
    
    // method to assert the real and the imaginary of a complex number
    private void assertEqualsCN(ComplexNumber cn1, ComplexNumber cn2)
    {
        assertEquals(String.format(Locale.US,"%.3f", cn1.getReal()), String.format(Locale.US,"%.3f", cn2.getReal()));
        assertEquals(String.format(Locale.US,"%.3f", cn1.getImaginary()), String.format(Locale.US,"%.3f", cn2.getImaginary()));
    }
    
    // method to get the last result pushed into the stack
    public ComplexNumber getLastResult() {
        return calculator.stackManager.top();
    }
    
    
    /**
     * Test of add method, of class Calculator.
     */
    @Test
    public void testAdd1()
    {
        System.out.println("testAdd: two complex numbers");
        ComplexNumber cnExpected = new ComplexNumber(5.2, (2-0.56));

        calculator.fetchInput("2 + 2j");
        calculator.fetchInput("3.2 - 0.56j");
        calculator.fetchInput("+");
        
        assertEqualsCN(cnExpected, getLastResult());
        
    }

    @Test
    public void testAdd2()
    {
        System.out.println("testAdd: two imaginary parts");
        ComplexNumber cnExpected = new ComplexNumber(0.0, -2+0.56);

        calculator.fetchInput("-2j");
        calculator.fetchInput("0.56j");
        calculator.fetchInput("+");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testAdd3()
    {
        System.out.println("testAdd: two real parts");
        ComplexNumber cnExpected = new ComplexNumber(3, 0);

        calculator.fetchInput("-2.46");
        calculator.fetchInput("5.46");
        calculator.fetchInput("+");

        assertEqualsCN(cnExpected, getLastResult());
    }


    @Test
    public void testAdd4()
    {
        System.out.println("testAdd: one real one imaginary");
        ComplexNumber cnExpected = new ComplexNumber(505, 104);

        calculator.fetchInput("505");
        calculator.fetchInput("104j");
        calculator.fetchInput("+");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testAdd5()
    {
        System.out.println("testAdd: zero real and zero imaginaty");
        ComplexNumber cnExpected = new ComplexNumber(0, 0);

        calculator.fetchInput("0");
        calculator.fetchInput("0j");
        calculator.fetchInput("+");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testAdd6()
    {
        System.out.println("testAdd: opposite numbers");
        ComplexNumber cnExpected = new ComplexNumber(0, 0);

        calculator.fetchInput("5+8j");
        calculator.fetchInput("-5-8j");
        calculator.fetchInput("+");

        assertEqualsCN(cnExpected, getLastResult());
    }
    
    @Test
    public void testAdd7() throws NotEnoughElementsException
    {
        System.out.println("testAdd: not enough elements");

        calculator.fetchInput("64+8j");

        assertThrows(NotEnoughElementsException.class, () -> {
            calculator.fetchInput("+");
        });
    }
    
    
    /**
     * Test of sub method, of class Calculator.
     */
    
    @Test
    public void testSub1()
    {
        System.out.println("testSub: two complex numbers");
        ComplexNumber cnExpected = new ComplexNumber(21 - 90, 34 + 5.6);

        calculator.fetchInput("21 + 34j");
        calculator.fetchInput("90 - 5.6j");
        calculator.fetchInput("-");

        assertEqualsCN(cnExpected, getLastResult());

    }

    @Test
    public void testSub2()
    {
        System.out.println("testSub: two imaginary parts");
        ComplexNumber cnExpected = new ComplexNumber(0, -2-0.56);

        calculator.fetchInput("-2j");
        calculator.fetchInput("0.56j");
        calculator.fetchInput("-");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testSub3()
    {
        System.out.println("testSub: two real parts");
        ComplexNumber cnExpected = new ComplexNumber((-85-0.9546), 0.0);

        calculator.fetchInput("-85");
        calculator.fetchInput("0.9546");
        calculator.fetchInput("-");

        assertEqualsCN(cnExpected, getLastResult());
    }


    @Test
    public void testSub4()
    {
        System.out.println("testSub: one real, one imaginary");
        ComplexNumber cnExpected = new ComplexNumber(71, -43);

        calculator.fetchInput("71");
        calculator.fetchInput("43j");
        calculator.fetchInput("-");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testSub5()
    {
        System.out.println("testSub: zero real and zero imaginaty");
        ComplexNumber cnExpected = new ComplexNumber(0, 0);

        calculator.fetchInput("0");
        calculator.fetchInput("0j");
        calculator.fetchInput("-");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testSub6()
    {
        System.out.println("testSub: opposite numbers");
        ComplexNumber cnExpected = new ComplexNumber(5 + 5, 8 + 8);

        calculator.fetchInput("5+8j");
        calculator.fetchInput("-5-8j");
        calculator.fetchInput("-");

        assertEqualsCN(cnExpected, getLastResult());
    }

    /**
     * Test of mul method, of class Calculator.
     */
    @Test
    public void testMul1()
    {
        System.out.println("testMul: two complex numbers");
        ComplexNumber cnExpected = new ComplexNumber(0, 29.0);

        calculator.fetchInput("5 + 2j");
        calculator.fetchInput("2 + 5j");
        calculator.fetchInput("*");
        
        assertEqualsCN(cnExpected, getLastResult());

    }
    
    @Test
    public void testMul2()
    {
        System.out.println("testMul: one complex number and one imaginary");
        ComplexNumber cnExpected = new ComplexNumber(2.0, -54.0);

        calculator.fetchInput("54 + 2j");
        calculator.fetchInput("0 - 1j");
        calculator.fetchInput("*");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testMul3()
    {
        System.out.println("testMul: two complex numbers, one negative");
        ComplexNumber cnExpected = new ComplexNumber(-18.2, 49.04);

        calculator.fetchInput("0.32 - 5j");
        calculator.fetchInput("-10 - 3j");
        calculator.fetchInput("*");

        assertEqualsCN(cnExpected, getLastResult());
    }


    @Test
    public void testMul4()
    {
        System.out.println("testMul: two complex numbers");
        ComplexNumber cnExpected = new ComplexNumber(108.857, -19267.71);

        calculator.fetchInput("198.09 - 13.2j");
        calculator.fetchInput("7 - 96.801j");
        calculator.fetchInput("*");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testMul5()
    {
        System.out.println("testMul: zero real and zero imaginaty");
        ComplexNumber cnExpected = new ComplexNumber(0, 0);

        calculator.fetchInput("0");
        calculator.fetchInput("0j");
        calculator.fetchInput("*");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testMul6()
    {
        System.out.println("testMul: opposite numbers");
        ComplexNumber cnExpected = new ComplexNumber(39, -80);

        calculator.fetchInput("5+8j");
        calculator.fetchInput("-5-8j");
        calculator.fetchInput("*");

        assertEqualsCN(cnExpected, getLastResult());
    }
    
    @Test
    public void testMul7() throws NotEnoughElementsException
    {
        System.out.println("testMul: not enough elements");

        calculator.fetchInput("64+8j");

        assertThrows(NotEnoughElementsException.class, () -> {
            calculator.fetchInput("*");
        });
    }

    /**
     * Test of div method, of class Calculator.
     */
    
    @Test
    public void testDiv1()
    {
        System.out.println("testDiv: two complex numbers");
        ComplexNumber cnExpected = new ComplexNumber(0.8, 0.6);

        calculator.fetchInput("1+2j");
        calculator.fetchInput("2+1j");
        calculator.fetchInput("/");

        assertEqualsCN(cnExpected, getLastResult());

    }

    @Test
    public void testDiv2()
    {
        System.out.println("testDiv: one complex number and one imaginary");
        ComplexNumber cnExpected = new ComplexNumber(-2.0, 54.0);

        calculator.fetchInput("54 + 2j");
        calculator.fetchInput("0 - 1j");
        calculator.fetchInput("/");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testDiv3()
    {
        System.out.println("testDiv: two complex numbers, one negative");
        ComplexNumber cnExpected = new ComplexNumber(0.1083, 0.4675);

        calculator.fetchInput("0.32 - 5j");
        calculator.fetchInput("-10 - 3j");
        calculator.fetchInput("/");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testDiv4()
    {
        System.out.println("testDiv: two complex numbers");
        ComplexNumber cnExpected = new ComplexNumber(0.2829, 2.0259);

        calculator.fetchInput("198.09 - 13.2j");
        calculator.fetchInput("7 - 96.801j");
        calculator.fetchInput("/");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testDiv5()
    {
        System.out.println("testDiv: zero real divided by one imaginary");
        ComplexNumber cnExpected = new ComplexNumber(0, 0);

        calculator.fetchInput("0");
        calculator.fetchInput("1j");
        calculator.fetchInput("/");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testDiv6()
    {
        System.out.println("testDiv: opposite numbers");
        ComplexNumber cnExpected = new ComplexNumber(-1, 0.0);

        calculator.fetchInput("5+8j");
        calculator.fetchInput("-5-8j");
        calculator.fetchInput("/");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testDiv7() throws ArithmeticException {
        System.out.println("testDiv: divide by zero");
        calculator.fetchInput("1");
        calculator.fetchInput("0");
        assertThrows(ArithmeticException.class, () -> {
            calculator.fetchInput("/");           
        });
    }

    /**
     * Test of sqrt method, of class Calculator.
     */
    @Test
    public void testSqrt1() {
        System.out.println("testSqrt: negative real");
        ComplexNumber cnExpected = new ComplexNumber(0, 2);

        calculator.fetchInput("-4");
        calculator.fetchInput("sqrt");

        assertEqualsCN(cnExpected, getLastResult());
    }
    
    @Test
    public void testSqrt2() {
        System.out.println("testSqrt: complex number");
        ComplexNumber cnExpected = new ComplexNumber(2.59390, 1.19511);

        calculator.fetchInput("5.3+6.2j");
        calculator.fetchInput("sqrt");

        assertEqualsCN(cnExpected, getLastResult());
    }

    @Test
    public void testSqrt3() {
        System.out.println("testSqrt: imaginary number");
        ComplexNumber cnExpected = new ComplexNumber(2.44948, 2.44948);

        calculator.fetchInput("12j");
        calculator.fetchInput("sqrt");

        assertEqualsCN(cnExpected, getLastResult());
    }
    /**
     * Test of inv method, of class Calculator.
     */
    @Test
    public void testInv1() {
        System.out.println("testInv: complexNumber");
        ComplexNumber cnExpected = new ComplexNumber(-5, -8);

        calculator.fetchInput("5+8j");
        calculator.fetchInput("inv");

        assertEqualsCN(cnExpected, getLastResult());
    }
    
    @Test
    public void testInv2() {
        System.out.println("testInv: imaginary number");
        ComplexNumber cnExpected = new ComplexNumber(0, 23.18);

        calculator.fetchInput("-23.18j");
        calculator.fetchInput("inv");

        assertEqualsCN(cnExpected, getLastResult());
    }
    
    @Test
    public void testInv3() {
        System.out.println("testInv: complexNumber");
        ComplexNumber cnExpected = new ComplexNumber(-4.45, 68.7);

        calculator.fetchInput("4.45-68.7j");
        calculator.fetchInput("inv");

        assertEqualsCN(cnExpected, getLastResult());
    }

    /**
     * Test of varPlusStack method, of class Calculator.
     */
    @Test
    public void testVarPlusStack1() {
        System.out.println("varPlusStack: two real numbers");
        calculator.fetchInput("4");
        String var = "v";
        calculator.fetchInput("5");
        calculator.fetchInput(">"+var);
        calculator.fetchInput("+"+var);
        
        ComplexNumber expResult = new ComplexNumber(9);
        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }
    
    @Test
    public void testVarPlusStack2() {
        System.out.println("varPlusStack: two complex numbers");
        calculator.fetchInput("-21+3.12j");
        String var = "q";
        calculator.fetchInput("35.2 + 53j");
        calculator.fetchInput(">"+var);
        calculator.fetchInput("+"+var);
        
        ComplexNumber expResult = new ComplexNumber(14.2, 56.12);
        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }
    
    @Test
    public void testVarPlusStack3() {
        System.out.println("varPlusStack: one real and one imaginary number");
        calculator.fetchInput("4.43j");
        String var = "l";
        calculator.fetchInput("25");
        calculator.fetchInput(">"+var);
        calculator.fetchInput("+"+var);
        
        ComplexNumber expResult = new ComplexNumber(25,4.43);
        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }

    /**
     * Test of varSubStack method, of class Calculator.
     */
    @Test
    public void testVarSubStack1() {
        System.out.println("varSubStack: two complex numbers");
        calculator.fetchInput("4+3j");
        String var = "m";
        calculator.fetchInput("7+12j");
        
        calculator.fetchInput(">"+var);
        calculator.fetchInput("-"+var);
        
        ComplexNumber expResult = new ComplexNumber(3,9);
        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }
    
    @Test
    public void testVarSubStack2() {
        System.out.println("varSubStack: two complex numbers");
        calculator.fetchInput("-21+21j");
        String var = "r";
        calculator.fetchInput("35.2 + 53j");
        
        calculator.fetchInput(">"+var);
        calculator.fetchInput("-"+var);
        
        ComplexNumber expResult = new ComplexNumber(56.2,32);
        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }
    
    @Test
    public void testVarSubStack3() {
        System.out.println("varSubStack: one real and one imaginary number");
        calculator.fetchInput("7.43j");
        String var = "p";
        calculator.fetchInput("5.32");
        
        calculator.fetchInput(">"+var);
        calculator.fetchInput("-"+var);
        
        ComplexNumber expResult = new ComplexNumber(5.32, -7.43);
        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }
    /**
     * Test of fromStackIntoVariable method, of class Calculator.
     */
    @Test
    public void testFromStackIntoVariable1() {
        System.out.println("fromStackIntoVariable");
        ComplexNumber expResult = new ComplexNumber(4.3,9.12);
        calculator.fetchInput("4.3 + 9.12j");
                
        String var = "a";
        calculator.fetchInput(">"+var);

        ComplexNumber result = calculator.variableManager.getVariable(var).getValue();
        
        assertEqualsCN(expResult, result);
    }
    @Test
    public void testFromStackIntoVariable2() throws RuntimeException{
        System.out.println("fromStackIntoVariable: empty stack");
        
        String var = "w";
        
        assertThrows(RuntimeException.class, () -> {
            calculator.fetchInput(">"+var);
        });
    }

    /**
     * Test of fromVariableIntoStack method, of class Calculator.
     */
    @Test
    public void testFromVariableIntoStack1() {
        System.out.println("fromVariableIntoStack");
        
        ComplexNumber expResult = new ComplexNumber(8.33,15.2);
        calculator.fetchInput("8.33 + 15.2j");
                
        String var = "g";
        calculator.fetchInput(">"+var);
        calculator.fetchInput("<"+var);
        
        ComplexNumber result = getLastResult();
        
        assertEqualsCN(expResult, result);
    }

    @Test
    public void testFromVariableIntoStack2() throws RuntimeException{
        System.out.println("fromVariableIntoStack: empty");
        
        String var = "t";
        
        assertThrows(RuntimeException.class, () -> {
            calculator.fetchInput("<"+var);
        });
    }
}
