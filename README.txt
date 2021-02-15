1. Part one: QA challenge
In my framework,

Features:
	I define the tests and tests steps and test data at the feature files which are under the resources folder.

Step Definitions:
	I write test scripts under step_definitions folder with using java programming language.
    I have Hooks class under step_definitions folder to create Before methods which are coming from Junit Annotations.

Runners:
	I have a CukesRunner class under runners folder to trigger my test suite. Alternatively, I can run my test suite through maven terminal like
        mvn verify command
    Note that: If you want to generate a test report, you need to run test suite through Maven command line. ( mvn verify ).
    You can reach the test report under the target folder
    target/cucumber-html-reports/overview-features.html

Utilities:
	There is a Configuration.properties file to keep credentials like apiUrl under the project folder.
	To retrieve those credentials, I have a ConfigReader.class under the utilities folder. With the help of that class, I can easily reach the information I need.

    ApiUtil class : I created methods to reuse them easily while automating the code and I keep those methods in the ApiUtil class.



