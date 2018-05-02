# Lambda Expressions in Java, Python, C#, C++
Gradle source code repository for C++, Java, C#, Python source code examples posted on personal blog (http://bit.ly/LambdaExpr).
Built and tested on SUSE Linux.

![alt text](https://raw.githubusercontent.com/afinlay5/LambdaExpr/master/blog.png)

# Platform 
- Any Microsoft Windows platform that supports the succceding environments.
- \*Nix platforms (most) that support the succceding environments.

# Requirements
- Java 8 (or greater) JDK
- Python 3 or greater (CPython implementation only)

- C# 3.0 or greater
- mono (any version supporting C# 3.0 or greater)

- C++ 11 or greater
- g++ (any version supportįng C++11 or greater)

- Have g++-7(gcc), mcs, mono, python3 in path or edit source and specify location to these files explicitly.

# Known Problems
- Gradle does not play well when calling java.util.Scanner.nextDouble(), where the Scanner wraps java.lang.System.in (05/01/2018).
- Gradle does not play well when input() is called in python source (05/01/2018).
- Gradle does not play well when Console.ReadLine() is called in C# source (05/01/2018).
- Gradle does not play well when std::cin in C++ source (05/01/2018).
- <strike>The commandLine subtasks all fail, so this is clearly unfinished (05/01/2018).</strike>

# Execution Screenshot
![alt text](https://raw.githubusercontent.com/afinlay5/LambdaExpr/master/run_gradle.png)
![alt text](https://raw.githubusercontent.com/afinlay5/LambdaExpr/master/run_gradle2.png)