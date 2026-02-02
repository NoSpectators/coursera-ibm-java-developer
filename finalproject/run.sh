#!/bin/bash

#export CLASSPATH=$CLASSPATH:/home/john/my-projects/coursera-ibm-java-developer/finalproject/classes

javac -d classes src/Mood.java src/InvalidMoodException.java src/MoodTracker.java
java MoodTracker
