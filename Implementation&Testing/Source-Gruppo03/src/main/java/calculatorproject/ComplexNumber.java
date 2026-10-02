/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculatorproject;

import java.util.Locale;


/**
 *
 * @author francescolemmo
 *
 */
public class ComplexNumber {

    // the two attributes represent the real and the imaginary parts of a complex number
    private double real;
    private double imaginary;

    // constructor for the creation of a complex number 
    public ComplexNumber(double real, double imaginary) {
        if(isNegativeZero(real))
            real = 0.0f;

        if(isNegativeZero(imaginary))
            imaginary = 0.0f;

        this.real = real;
        this.imaginary = imaginary;
    }

    // constructor for the creation of a real number 
    public ComplexNumber(double real) {
        if(isNegativeZero(real))
            real = 0.0;

        this.real = real;
        this.imaginary = 0.0f;
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
            return String.format(Locale.US,"%.3f", real);
        }
        else if (this.getImaginary() < 0)
            return String.format(Locale.US,"%.3f - %.3fj", real, (-1*imaginary));
        else {
            return String.format(Locale.US,"%.3f + %.3fj",real, imaginary);
        }

    }


    public static ComplexNumber fromString(String value) {
        value = value.replaceAll(" ", "");
        
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

        if(db[0] == null || isNegativeZero(db[0]))
            db[0] = 0.0d;

        if(db[1] == null || isNegativeZero(db[1]))
            db[1] = 0.0d;

        return new ComplexNumber(db[0], db[1]);
    }

    @Override
    public boolean equals(Object object) {
        if(this == object)
            return true;

        if(!(object instanceof ComplexNumber))
            return false;

        ComplexNumber other = (ComplexNumber) object;
        return this.getReal() == other.getReal() && this.getImaginary() == other.getImaginary();
    }

    private static boolean isNegativeZero(double value) {
        return Double.compare(Math.abs(value), 0.0) == 0 && Double.compare(1.0 / value, Double.NEGATIVE_INFINITY) == 0;
    }

}
