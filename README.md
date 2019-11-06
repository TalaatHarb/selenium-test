# selenium-test
Testing the basics of using Selenium, using Chrome web driver on windows

## Development Requirements
- JDK
- Maven
* Optional requirement (Eclipse IDE for EE developers)

## Runtime Requirements
- JDK
- The executable jar and the accompanying drivers folder

## How to run?
- Run the command: 'mvn clean install' in the root folder of your project
- Run the command: 'java -jar target/selenium-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar'

### How to run in eclipse?
- From the file menu in eclipse: choose import
- Choose Existing Maven projects
- Browse to the project root directory and select it
- Open: 'net.talaatharb.selenium.SeleniumApplication'
- Run the application

If you want to move only the executable parts to another folder(or another windows machine), then copy the following files/folders from the target directory:
- selenium-test-0.0.1-SNAPSHOT-jar-with-dependencies.jar
- drivers (folder)