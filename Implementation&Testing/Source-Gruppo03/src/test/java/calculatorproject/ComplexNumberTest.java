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

/**
 *
 * @author francescolemmo
 */
public class ComplexNumberTest {
    
    public ComplexNumberTest() {
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
     * Test of fromString method, of class ComplexNumber.
     */
    @Test
    public void testFromString1() {
        System.out.println("fromString: positive real");
        String value = "+1.0032";
        String expResult = new ComplexNumber(1.00320).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString2() {
        System.out.println("fromString: negative real");
        String value = "-5.324";
        String expResult = new ComplexNumber(-5.324).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString3() {
        System.out.println("fromString: positive imaginary");
        String value = "9.167j";
        String expResult = new ComplexNumber(0,9.167).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString4() {
        System.out.println("fromString: negative imaginary");
        String value = "  -11.3j";
        String expResult = new ComplexNumber(0,-11.3).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString5() {
        System.out.println("fromString: positive real, positive imaginary");
        String value = "3.54+ 6.32j";
        String expResult = new ComplexNumber(3.54,6.32).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString6() {
        System.out.println("fromString: negative real, positive imaginary");
        String value = "-47.78  + 342.0j";
        String expResult = new ComplexNumber(-47.78,342).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString7() {
        System.out.println("fromString: positive real, negative imaginary");
        String value = "+89.2  + 65.0j";
        String expResult = new ComplexNumber(89.2,65.0).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFromString8() {
        System.out.println("fromString: negative real, negative imaginary");
        String value = "-7.758    - 376j";
        String expResult = new ComplexNumber(-7.758,-376).toString();
        String result = ComplexNumber.fromString(value).toString();
        assertEquals(expResult, result);
    }
    
}  


