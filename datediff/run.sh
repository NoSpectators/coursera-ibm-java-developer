#!/bin/bash

export CLASSPATH=$CLASSPATH:/home/john/my-projects/coursera-ibm-java-developer/datediff/classes

javac -d classes/ src/DateDiffCalculator.java
java DateDiffCalculator

#javac -d classes src/DateTimePrinter.java
#java DateTimePrinter

#javac -d classes src/ZonedDateTimePrinter.java
#java ZonedDateTimePrinter

#javac -d classes src/DateTimeOperations.java
#java DateTimeOperations
