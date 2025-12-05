#!/bin/bash

export CLASSPATH=$CLASSPATH:/home/john/my-projects/coursera-ibm-java-developer/classes

# java only works for single-file program
#java HelloWorld.java

#javac -d classes/ src/DataTypes.java
#java DataTypes

#javac -d classes/ src/DataDoubleToInt.java
#java DataDoubleToInt

#javac -d classes/ src/CharToInt.java
#java CharToInt

#javac -d classes/ src/MathOperators.java
#java MathOperators

#javac -d classes/ src/RelationalOperators.java
#java RelationalOperators

#javac -d classes/ src/TernaryOperator.java
#java TernaryOperator

#javac -d classes/ src/ArrayMath.java
#java ArrayMath

#javac -d classes/ src/ArrayAccess.java
#java ArrayAccess

#javac -d classes/ src/StringOps.java
#java StringOps

#javac -d classes/ src/AreaCalculator.java
#java AreaCalculator

#javac -d classes/ src/ExceptionTrial.java
#java ExceptionTrial

# two files where one class is shared by both files (the custom exception class)
javac -d classes/ src/StudentManagement.java src/StudentUnderAgeException.java src/StudentInvalidNameException.java
java StudentManagement
