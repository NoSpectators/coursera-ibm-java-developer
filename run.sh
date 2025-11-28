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

javac -d classes/ src/RelationalOperators.java
java RelationalOperators
