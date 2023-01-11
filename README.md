# SampleProject

**Project Structure:**

Directory: src/main/java - This directory consist two packages "setup" and "util"

DriverSetup Class extends to StartServer class which is basically used to start appium server programmatically. And DriverSetup class is used to initialize driver and launch application based on the given capabilities.

util package has ElementUtil Class which has all the basic functionality of appium like, click, sendKeys, elementDisplay etc.

Directory: src/main/resources -  This directory contains capabilities.json and test apk file.

Directory: src/test/java - This directory contains Page Objects and test scripts

Directory: src/test/resources - This directory contains TestData.csv file.

pom.xml - has all the required dependencies and plugins

testng.xml is the file from where all the test script triggered.

**AutoLaunch is a shell script, using this we can execute the test in single click.**

**How to Execute:**
\
Pre-conditions: To execute through IDE
1. Appium server should be installed in the machine.
2. Android Emulator should be created and running in the machine.
3. `platformVersion` capability should be updated in capabilities.json according to emulator version.
4. Just `Run` the project.

Pre-conditions: To execute through AutoLaunch shell script
1. Open `AutoLaunch` file in any IDE or Text Edit
2. Read commented lines and do require changes.
3. Just double-click or open `AutoLaunch` file from System folder structure.