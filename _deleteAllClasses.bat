@echo off

rem Specify the root directory where your class files are located
set "rootDir=src"

rem Delete all .class files recursively in the specified root directory
for /r "%rootDir%" %%i in (*.class) do (
    del "%%i"
)