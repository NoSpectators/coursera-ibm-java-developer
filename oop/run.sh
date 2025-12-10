#!/bin/bash

export CLASSPATH=$CLASSPATH:/home/john/my-projects/coursera-ibm-java-developer/oop/classes

javac -d classes/ src/Book.java src/BookAccess.java
java BookAccess

#javac -d classes/ src/BooksMenu.java
#java BooksMenu
