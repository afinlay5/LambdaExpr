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

package me.adriandavid;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.System.out;
import static java.lang.System.err;

public class LambdaExprMain {
	public static void main (String[] args) {
		Process proc = null;

		//java/LambdaExpr.java
		out.println("----------------------------");
		out.println("Java Lambda Demo");
		out.println("----------------------------\n");
		new me.adriandavid.java.LambdaExpr().main(null);
		
		//python/LambdaExpr.py
		out.println("----------------------------");
		out.println("Python Lambda Demo");
		out.println("----------------------------\n");
		LambdaExprMain.callExternal(proc, "python");
		
		//csharp/LambdaExpr.cs
		out.println("----------------------------");
		out.println("C Sharp Lambda Demo");
		out.println("----------------------------\n");
		LambdaExprMain.callExternal(proc, "csharp");
		
		//cplusplus/LambdaExpr.cpp
		out.println("----------------------------");
		out.println("C++ Lambda Demo");
		out.println("----------------------------\n");
		LambdaExprMain.callExternal(proc, "cplusplus");	
	}
	private static void callExternal(Process proc, final String env) {

		switch (env){
			//LambdaExpr.py
			case "python": {
				if (new File(System.getProperty("user.dir"), "build/classes/me/adriandavid/python/LambdaExpr.pyc").exists()) {
					try {
						proc = Runtime.getRuntime().exec("python3 build/classes/me/adriandavid/python/LambdaExpr.pyc");
						LambdaExprMain.displayExternal(proc);
					} catch (IOException ioe) {err.println("An I/O Error has occured."); System.exit(0); }
					return;
				}
			}				
			//LambdaExpr.cs
			case "csharp": { 
				if (new File(System.getProperty("user.dir"), "build/classes/me/adriandavid/csharp/").list().length > 0) {
					try {	
						proc = Runtime.getRuntime().exec("mono build/classes/me/adriandavid/csharp/LambdaExpr.exe");
						//Print to console
						LambdaExprMain.displayExternal(proc);
					}catch (IOException ioe) {
						err.println("An I/O Error has occured."); 
						System.exit(0); 
					}catch (Exception e) {
						err.println("This platform is likely not supported.");
						err.println("Cause:\t" + e.getMessage());
						System.exit(0);
					}
					return;
				}
			}
			//LambdaExpr.cpp
			case "cplusplus": { 
				if (new File(System.getProperty("user.dir"), "build/classes/me/adriandavid/cplusplus/").list().length > 0) {
					String OS = System.getProperty("os.name");
					try {
						//Windows
						if (OS.toLowerCase().contains("windows")) {
							proc = Runtime.getRuntime().exec("build/classes/me/adriandavid/cplusplus/LambdaExpr.exe");
						}
						//*Nix
						else if ( OS.toLowerCase().contains("linux") || OS.toLowerCase().contains("mac") || OS.toLowerCase().contains("bsd") ) {
							proc = Runtime.getRuntime().exec("./build/classes/me/adriandavid/cplusplus/LambdaExpr");
						}
						//Unsupported
						else {
							out.println("This platform is not supported.");
							System.exit(0);
						}
						//Print to console
						LambdaExprMain.displayExternal(proc);
					} catch (IOException ioe) {err.println("An I/O Error has occured."); System.exit(0); }
					return;
				}
			}
		}

		//File is missing
		err.println("The script could not be found."); 
		System.exit(0);
	}
	private static void displayExternal (Process proc) throws java.io.IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
			String output = br.readLine();
			if (output == null) {
				err.println("An error occured in printing the stream.");
				System.exit(0);
			}
			else {
				System.out.println(output);
				while( (output = br.readLine()) != null) { 
					System.out.println(output); 
				}
			}
		}
	}
}