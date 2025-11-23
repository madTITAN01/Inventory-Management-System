@echo off
echo Compiling...
if not exist out mkdir out
javac -d out -cp "lib/*" src\com\ankit\inventory\*.java

if %errorlevel% neq 0 (
  echo Compilation failed.
  pause
  exit /b %errorlevel%
)

echo Running...
java -cp "out;lib/*" com.ankit.inventory.Main
pause