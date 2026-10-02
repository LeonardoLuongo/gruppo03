/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package calculatorproject;

import calculatorproject.exceptions.*;
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
public class StackManagerTest {
    
    StackManager instance;
    ComplexNumber sLast;
    ComplexNumber last;
    
    public StackManagerTest() {
        instance = new StackManager();
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        sLast = new ComplexNumber(23,72); //second-last element
        last = new ComplexNumber(5,23.2); //last element
        instance.push(sLast);
        instance.push(last);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of dup method, of class StackManager.
     */
    @Test
    public void testDup1() {
        System.out.println("dup");
        instance.dup();
        assertEquals(last.toString(),instance.top().toString());
    }
    
    @Test
    public void testDup2() throws NotEnoughElementsException {
        System.out.println("dup: empty stack");
        instance.pop();
        instance.pop();
        //Stack is now empty
        assertThrows(NotEnoughElementsException.class, () -> {
            instance.dup();
        });
    }    

    
    /**
     * Test of drop method, of class StackManager.
     */
    @Test
    public void testDrop1() {
        System.out.println("drop");
        instance.drop();
        assertEquals(sLast.toString(),instance.top().toString());
    }
    
    @Test
    public void testDrop2() throws NotEnoughElementsException {
        System.out.println("drop: empty stack");
        instance.pop();
        instance.pop();
        //Stack is now empty
        assertThrows(NotEnoughElementsException.class, () -> {
            instance.drop();
        });
    }
    

    /**
     * Test of swap method, of class StackManager.
     */
    @Test
    public void testSwap1() {
        System.out.println("swap");
        instance.swap();
        assertEquals(sLast.toString(),instance.top().toString());
    }
    
    @Test
    public void testSwap2() throws NotEnoughElementsException {
        System.out.println("swap: one element in the stack");
        instance.pop();
        //only one element is in the stack
        assertThrows(NotEnoughElementsException.class, () -> {
            instance.swap();
        });
    }
    
    
    /**
     * Test of over method, of class StackManager.
     */
    @Test
    public void testOver1() {
        System.out.println("over");
        instance.over();
        assertEquals(sLast.toString(),instance.top().toString());
    }

    @Test
    public void testOver2() {
        System.out.println("over: one element in the stack");
        instance.pop();
        //only one element is in the stack
        assertThrows(NotEnoughElementsException.class, () -> {
            instance.over();
        });
    }
    
    
    /**
     * Test of clear method, of class StackManager.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        instance.clear();
        assertEquals("STACK:\n",instance.toString());
    }

    
    /**
     * Test of push method, of class StackManager.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        ComplexNumber number = new ComplexNumber(51.3,24);
        instance.push(number);
        assertEquals(number.toString(),instance.top().toString());
    }

    
    /**
     * Test of pop method, of class StackManager.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        ComplexNumber result = instance.pop();
        assertEquals(last, result);
    }

    
    /**
     * Test of top method, of class StackManager.
     */
    @Test
    public void testTop() {
        System.out.println("top");
        ComplexNumber result = instance.top();
        assertEquals(last, result);
    }


    /**
     * Test of getSize method, of class StackManager.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        //two elements in the stack
        int result = instance.getSize();
        assertEquals(2, result);
    }

}
