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

#include <iostream>
#include <cmath>
#include <algorithm>

// namespace me_adriandavid_cplusplus {

    //Lambda Expressions, Arithmetic Expressions
    auto _div = [] (double x, double y) { return x/y; };
    auto _exp = [] (double x, double y) { return pow (x,y); };
    auto _min = [] (double x, double y) { return std::min(x,y); };
    double expr1, expr2;

    //Function Prototype
    void calc();

    //main()
    int main () {
        /* Because it is against ISO CPP to recursively call main(), we'll 
        place the code in a function. */
        calc();
        
        //Flush char buffer, close.
        std::cout<<std::endl;
        return 0;
    }

    //calc()
    void calc () {
        //Header Prompt
        std::cout<< "\nLet's demonstrate the usefulness of Arithmetic\n" <<
                        "operations by using Lambda Expressions.\n\n";

        //One can always escape the program by entering the EOF character (such as CTRL+D
        //or CTRL+C) on their shell triggering an EOF Error, ending the application.

        //Prompt for Division
        std::cout<<"LET'S DO SOME DIVISION:\t";
        // std::cin>> expr1 >> expr2;
        expr1 = 3.4; expr2=4;
        //It must be a number.
        if (std::cin.fail() ) {
            std::cout << "\nYou have entered invalid input. Restarting.\n\n";
            std::cin.clear();
            std::cin.ignore(10000,'\n');
            calc();        
        } //Lambda Expression, Print Result
        else { std::cout<<"The result is:\t" << _div(expr1, expr2) << '\n'; }

        //Prompt for Exponentiation
        std::cout<<"\nLET'S DO SOME EXPONENTIATION:\t";
        // std::cin>> expr1 >> expr2;
        expr1 = 3.4; expr2=9.2;
        //It must be a number.
        if (std::cin.fail() ) {
            std::cout << "\nYou have entered invalid input. Restarting.\n\n";
            std::cin.clear();
            std::cin.ignore(10000,'\n');
            calc();
        } //Lambda Expression, Print Result
        else { std::cout<<"The result is:\t" << _exp(expr1, expr2) << '\n'; }

        //Prompt for Minimum
        std::cout<<"\nLET'S FIND THE MINIMUM VALUE:\t";
        // std::cin>> expr1 >> expr2;
        expr1 = 6.12; expr2=2.9;
        //It must be a number.
        if (std::cin.fail() ) {
            std::cout << "\nYou have entered invalid input. Restarting.\n\n";
            std::cin.clear();
            std::cin.ignore(10000,'\n');
            calc();
        } //Lambda Expression, Print Result
        else { std::cout<<"The result is:\t" << _min(expr1, expr2) << '\n'; } 
    }
// }