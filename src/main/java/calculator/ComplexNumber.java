/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator;


/**
 *
 * @author francescolemmo
 */
public class ComplexNumber {
    
    // the two attributes represent the real and the imaginary parts of a complex number
    private double real;
    private double imaginary;

    // constructor for the creation of a complex number 
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // constructor for the creation of a real number 
    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0;
    }
        
    // constructor for the creation of a complex number using an existing complex number
    public ComplexNumber(ComplexNumber number) {
        this.real = number.getReal();
        this.imaginary = number.getImaginary();
    }
    
    // method to get the real part of a number
    public double getReal() {
        return real;
    }

    // method to get the imaginary part of a number
    public double getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        if (this.getImaginary() == 0) {
            return real+"";
        }
        else if (this.getImaginary() < 0)
            return real + " - " + (-1*imaginary) + "j";
        else {
            return real + " + " + imaginary + "j";
        }
        
    }
    

    public static ComplexNumber fromString(String value) {
        
        StringBuilder temp = new StringBuilder();
        
        Double[] db = new Double[2];
        db[0] = null;
        db[1] = null;
        for(int i = 0; i < value.length(); i++)
        {
            if((value.charAt(i) == '+' || value.charAt(i) == '-') && !temp.toString().isEmpty())
            {
                db[0] = Double.parseDouble(temp.toString());
                temp = new StringBuilder(value.charAt(i) + "");
            }
            else if(value.charAt(i) != 'j')
            {
                temp.append(value.charAt(i));
                if (i+1 == value.length())
                {
                    db[0] = Double.parseDouble(temp.toString());
                }
            }
            else
            {
                db[1] = Double.parseDouble(temp.toString());
            }
            
        }
        
        if(db[0] == null)
            db[0] = 0.0d;
        
        if(db[1] == null)
            db[1] = 0.0d;
        
        return new ComplexNumber(db[0], db[1]);
    }
    
    
    
}
