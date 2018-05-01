#!/usr/bin/python3

'''
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
'''

#Lambda Expressions, Expression List
div = lambda x,y: x/y
exp = lambda x,y: x**y 
_min = lambda x,y: min(x,y)
expr = []

#main()
def main ():
    #Header Prompt
    print ("Let's demonstrate the usefulness of Airthmetic\n"  +
                        "operations by using Lambda Expressions.\n")
 
    #One can always escape the program by entering the EOF character (such as CTRL+D)
    #on their shell triggering an EOF Error, ending the application.
    
    #Let's do some division
    print("\nLET'S DO SOME DIVISION:\t", end="")
    try:
        #expr = input().split()
        expr = [72,34]
        expr1 = float(expr[0])
        expr2 = float(expr[1])
    except (ValueError,IndexError):
        print("\n\nYou have entered invalid input. Restarting.\n\n")
        main()
    #Call the Lambda Expression, Print the result
    print("The result is:\t" + str(div(expr1, expr2)) )
    
    #Let's do some exponentiation
    print("\nLET'S DO SOME EXPONENTIATION:\t", end="")
    try:
        # expr = input().split()
        expr = [72,34]
        expr1 = float(expr[0])
        expr2 = float(expr[1])
    except (ValueError,IndexError):
        print("\n\nYou have entered invalid input. Restarting.\n\n")
        main()
    #Call the Lambda Expression, Print the result
    print("The result is:\t" + str(exp(expr1, expr2)) )
    
    #Let's find the minimum value
    print("\nLET'S FIND THE MINIMUM VALUE:\t", end="")
    try:
        # expr = input().split()
        expr = [72,34]
        expr1 = float(expr[0])
        expr2 = float(expr[1])
    except (ValueError,IndexError):
        print("\n\nYou have entered invalid input. Restarting.\n\n")
        main()
    #Call the Lambda Expression, Print the result
    print("The result is:\t" + str( _min(expr1, expr2) ) + "\n")
    
#Run It
if __name__ == "__main__":
    main()