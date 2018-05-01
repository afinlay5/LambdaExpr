/*
Copyright (C) 2018 Adrian D. Finlay. All rights reserved.

Licensed under the MIT License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://opensource.org/licenses/MIT

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER INCLUDING AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
==============================================================================
**/

package me.adriandavid.java;

import java.util.Scanner; //For Scanner class
import java.lang.Math; //For pow(), min()
import java.util.InputMismatchException; //InputMismatchException class
import static java.lang.System.out; //For println(), print()

//Defines Structure for Lambda Expression
@FunctionalInterface
interface MathOp {
    //Must contain one and only one abstract method
    double binaryMathOp(double a, double b);
}

//Main Class
public class LambdaExpr {
    //Main method
    public static void main (String[] args) {
        //Input Stream
        Scanner in = new Scanner(System.in);
        //Lambda Reference, Arithmetic Expressions
        MathOp doMath;
        double expr1=0, expr2 =0;

        //Header
        out.println("Let's demonstrate the usefulness of Airthmetic\n"  +
                    "operations by using Lambda Expressions.\n");

        //nextDouble() Exceptions: Note that I will not catch NoSuchElementException 
        //or IllegalStateException because it is not necessary to do so for our example.
        //One can always escape the program by entering the EOF character (such as CTRL+D)
        //on their shell triggering an uncaught NoSuchElementException, ending the application.

        //Prompt for Division
        out.print("LET'S DO SOME DIVISION:\t");
        try{
            expr1 = in.nextDouble();
            expr2 = in.nextDouble();
        } catch (InputMismatchException ime) {
            out.println("\n\nYou have entered invalid input. Restarting.\n\n");
            main(args);
        } catch (java.util.NoSuchElementException nse) {
            //For some odd reason gradle does not like Reading in input
            expr1 = 9;
            expr2 = 18;
        }
        //Lambda Expression for Division 
        doMath = (x,y) -> {
            return x / y;
        };
        //Print Result
        out.println("The result is:\t" + doMath.binaryMathOp(expr1, expr2));

        //Prompt for Exponentiation 
        out.print("\nLET'S DO SOME EXPONENTIATION:\t");
        try{
            expr1 = in.nextDouble();
            expr2 = in.nextDouble();
        } catch (InputMismatchException e) {
            out.println("\n\nYou have entered invalid input. Restarting.\n\n");
            main(args);
        } catch (java.util.NoSuchElementException nse) {
            //For some odd reason gradle does not like Reading in input
            expr1 = 9;
            expr2 = 18;
        }
        //Lambda Expression for Addition
        doMath = (x,y) -> {
            return Math.pow(x,y);
        };
        //Print Result
        out.println("The result is:\t" + doMath.binaryMathOp(expr1, expr2));
        //Method References
        out.println("\nNotice something about the previous Lambda Expression.\n"+
                     "\nAll it did was call Math.pow(double a, double b), which is\n" +
                     "compatible with MathOp.binaryMathOp(double a, double b).\n" +
                     "\nCommonly, we use lambda methods to refer to existing methods.\n" +
                     "This is an opportune situation to instead use a Method Reference.\n" +
                     "\nWe will demonstrate this with a method reference to Math.min(double x, double y).\n");
        
        //Prompt to find minimum value
        out.print("\nLET'S FIND THE MINIMUM VALUE:\t");
        try{
            expr1 = in.nextDouble();
            expr2 = in.nextDouble();
        } catch (InputMismatchException e) {
            out.println("\n\nYou have entered invalid input. Restarting.\n\n");
            main(args);
        } catch (java.util.NoSuchElementException nse) {
            //For some odd reason gradle does not like Reading in input
            expr1 = 9;
            expr2 = 18;
        }
        
        //Method Reference (Lambda Expression)
        doMath = Math::min;
        //Print Result
        out.println("The result is:\t" + doMath.binaryMathOp(expr1, expr2) + "\n");

        //Close Input Stream
        in.close();
    }
}