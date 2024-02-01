@echo off
javac -d . src/*.java src/Staff/*.java src/Payroll/*.java
java -cp . src/Login