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


using System;

namespace me.adriandavid.csharp
{
    class LambdaExpr
    {
        //Delegate
        delegate double mathOp (double x, double y);

        //main()
        static void Main(string[] args)
        {
            //Header Prompt
            Console.WriteLine("\nLet's demonstrate the usefulness of Airthmetic\n"  +
                    "operations by using Lambda Expressions.\n");

            //Lambda Expressions, Arithmetic Expressions
            mathOp div = (x,y) => x / y;
            mathOp exp = (x,y) => Math.Pow(x,y);
            mathOp min = (x,y) => Math.Min(x,y);
            string[] expr;
            var expr1 = 0.0;
            var expr2 = 0.0;


            //Prompt for Division
            Console.Write("LET'S DO SOME DIVISION:\t");
            try{
                // expr = Console.ReadLine().Split();
                // expr1 = double.Parse(expr[0]);
                expr1 = 10.2;
                // expr2 = double.Parse(expr[1]);
                expr2 = 13.9;
            } catch (Exception e) when (e is FormatException || e is OverflowException) {
                Console.WriteLine("\n\nYou have entered invalid input. Restarting.\n\n");
                Main(args);
            }
            //Lambda Expression, Print Result
            Console.WriteLine("The result is:\t" + div(expr1, expr2));


            //Prompt for Exponentiation 
            Console.Write("\nLET'S DO SOME EXPONENTIATION:\t");
            try{
                // expr = Console.ReadLine().Split();
                // expr1 = double.Parse(expr[0]);
                expr1 = 9.3;
                // expr2 = double.Parse(expr[1]);
                expr2 = 3.4;
            } catch (Exception e) when (e is FormatException || e is OverflowException) {
                Console.WriteLine("\n\nYou have entered invalid input. Restarting.\n\n");
                Main(args);
            }
            //Lambda Expression, Print Result
            Console.WriteLine("The result is:\t" + exp(expr1, expr2));


            //Prompt for Minimum 
            Console.Write("\nLET'S DO SOME MINIMUM:\t");
            try{
                // expr = Console.ReadLine().Split();
                // expr1 = double.Parse(expr[0]);
                expr1 = 7.3;
                // expr2 = double.Parse(expr[1]);
                expr2 = 1.2;
            } catch (Exception e) when (e is FormatException || e is OverflowException) {
                Console.WriteLine("\n\nYou have entered invalid input. Restarting.\n\n");
                Main(args);
            }
            //Lambda Expression, Print Result
            Console.Write("The result is:\t" + min(expr1, expr2) );
        }
    }
}