#!/bin/bash

export CLASSPATH=$CLASSPATH:/home/john/my-projects/coursera-ibm-java-developer/oop/classes

#javac -d classes/ src/Book.java src/BookAccess.java
#java BookAccess

#javac -d classes/ src/BooksMenu.java
#java BooksMenu

#javac -d classes/ src/Employee.java src/TestEncapsulation.java
#java TestEncapsulation

#javac -d classes/ src/Student.java src/StudentRegistry.java
#java StudentRegistry

#javac -d classes/ src/Car.java src/CarMenu.java
#java CarMenu

#javac -d classes/ src/Vehicle.java src/VehicleMenu.java
#java VehicleMenu


javac -d classes/ src/Shape.java src/Circle.java src/ShapeMenu.java
java ShapeMenu
