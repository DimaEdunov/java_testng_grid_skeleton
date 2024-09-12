@ECHO OFF
:: Set JAVA_HOME to your JDK installation
setx JAVA_HOME "C:\Program Files\Java\jdk-18.0.1.1"

:: Add Java to the PATH
setx JAVA_HOME "C:\Program Files\Java\jdk-18.0.1.1"

:: Run Allure command
allure serve C:\Github\Java\JavaBasics\SeleniumPractice\allure-results

:: Pause to keep the terminal open
pause
