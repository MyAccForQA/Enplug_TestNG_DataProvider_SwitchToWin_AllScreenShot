########################################
My Company Inc. [Selenium Tests]
########################################

This repository contains `Selenium <http://seleniumhq.org/>`_ tests for the `My Company Inc. <http://www.MyCompany.com/>`_, `GitHub Account <https://github.com/ACCOUNT/REPOSITORY>`_.


    .. image:: https://github.com/ACCOUNT/REPOSITORY/blob/master/screenshot/README/homepage.png
        :alt: My Company Inc.
        :width: 30%
        :align: center


.. contents::

.. section-numbering::

.. raw:: pdf

   PageBreak oneColumn


=============
Dependencies
=============
----------------
Git
----------------
Make sure you have `Git <https://git-scm.com/>`_ installed on your system. For check use the commands below:

``git -v``

----------------
GitHub
----------------
Make sure you have access `GitHub Account <https://github.com/ACCOUNT/REPOSITORY>`_:

``git clone https://github.com/ACCOUNT/REPOSITORY``

----------------
Maven
----------------
Make sure you have `Maven <https://maven.apache.org/download.cgi>`_ installed on your system. For check use the commands below:

``mvn -v/--version``

----------------
Java
----------------
Make sure you have `Java <http://www.java.com/>`_ installed on your system, if not follow the vendor instructions for installing them on your operating system.

``java -version``

----------------
GeckoDriver
----------------
~~~~~~~~~~~~
FireFox - WebDriver for FireFox
~~~~~~~~~~~~
Need download driver from `GeckoDriver <https://github.com/mozilla/geckodriver/releases>`_ and drop in folder:
For Mac - ./src/main/resources/geckodriver/mac/ff/geckodriver
For Win - ./src/main/resources/geckodriver/mac/ff/geckodriver.exe

Instruction - https://github.com/SeleniumHQ/selenium/issues/2990

~~~~~~~~~~~~
ChromeDriver - WebDriver for Chrome [Not Implement yet]
~~~~~~~~~~~~
Need download chromedriver from `GeckoDriver <https://sites.google.com/a/chromium.org/chromedriver/downloads>`_ and drop in folder:
For Mac - ./src/main/resources/geckodriver/mac/ch/chromedriver
For Win - ./src/main/resources/geckodriver/win/ch/chromedriver.exe


=============
Run
=============
To run the framework using basic options and their syntax:

``mvn [clean] [test/site] [-DdriverType=FF] [-Ptest1/-Ptest2/-Ptest3] [-Dtestngfile=testng_xml_file]``

----------------
Clean
----------------
To clean the folders from test data from the previous run use the command [clean]

``mvn clean``

----------------
Run test without/with of report
----------------
To run the framework for execution you need to choose the desired option [test/site]

~~~~~~~~~~~~
Run test without of report
~~~~~~~~~~~~
To run tests without getting a report use option test

``mvn clean test``

~~~~~~~~~~~~
Run test with of report
~~~~~~~~~~~~
To run tests with getting a report use option site

``mvn clean site``

----------------
Browser
----------------
To run the framework in a particular browser, to need to specify the name of the browser as a parameter of the option of [-DdriverType]

~~~~~~~~~~~~
Firefox
~~~~~~~~~~~~
To run in Firefox use -DdriverType=FF, below:

``mvn clean site -DdriverType=[FF/ff/FIREFOX/FireFox/firefox/FOX/Fox/fox]``

~~~~~~~~~~~~
Chrome - [Not Implement yet]
~~~~~~~~~~~~
To run in Chrome use -DdriverType=CHROME, below:

``mvn clean site -DdriverType=[CH/ch/CHROME/chrome/GOOGLE/google]``

~~~~~~~~~~~~
Internet Explorer - [Not Implement yet]
~~~~~~~~~~~~
To run in Internet Explorer use -DdriverType=IE, below:

``mvn clean site -DdriverType=[IE/ie]``

~~~~~~~~~~~~
Default
~~~~~~~~~~~~
If you don't specify this parameter, default option -DdriverType = ff

``mvn clean site -DdriverType=ff``

----------------
Profile
----------------
In order to use a profile to run tests specify the desired option [-Ptest1/-Ptest2/-Ptest3]

~~~~~~~~~~~~
Profile #1
~~~~~~~~~~~~
Use option -Ptest1 to run the default profile

* if you specify a profile -Ptest1, then the following option [-Dtestngfile=testng_Tests_All.xml] should not be specified.

~~~~~~~~~~~~
Profile #2
~~~~~~~~~~~~
Use option -Ptest2 to run the profile where to need specify just testng_xml_file use option [-Dtestngfile=testng_Tests_All.xml]

~~~~~~~~~~~~
Profile #3
~~~~~~~~~~~~
Use option -Ptest3 to run the profile where to need specify full path and testng_xml_file use option [-Dtestngfile=!testngxml!/testng_Tests_All.xml]

~~~~~~~~~~~~
Default
~~~~~~~~~~~~
If you don't specify this parameter default option profile = -Ptest1

* if you specify a profile -Ptest1, then the following option [-Dtestngfile=testng_Tests_All.xml] should not be specified.

----------------
TestNG files
----------------
If specified the previous option, it is necessary to specify what of file need to run test, specify the option [-Dtestngfile=testng_xml_file]

testng_Tests_All.xml 				- run all tests

testng_Tests_Group_Error.xml 		- run test of error group

testng_Tests_OneMethod.xml 			- run test


=============
OPEN REPORT
=============

In project exist 3 kind of reports:

----------------
SureFire report
----------------
The `SureFire <http://maven.apache.org/surefire/maven-surefire-plugin/>`_ Plugin is used during the test phase of the build lifecycle to execute the unit tests of an application.

~~~~~~~~~~~~
Open report
~~~~~~~~~~~~
To open the browser and in the address bar enter the path:

``./target/site/surefire-report.html``

----------------
Allure report
----------------
`Allure <http://allure.qatools.ru/>`_ is open-source framework designed to create test execution reports clear to everyone in the team.

~~~~~~~~~~~~
Open report
~~~~~~~~~~~~
To open the browser and in the address bar enter the path:

``./target/site/allure-report/index.html``

----------------
Java Code Coverage report - [Not Implement yet]
----------------
`JaCoCo <http://www.eclemma.org/jacoco/index.html>`_ is a free code coverage library for Java, which has been created by the EclEmma team based on the lessons learned from using and integration existing libraries for many years. 

~~~~~~~~~~~~
Open report
~~~~~~~~~~~~
[Not Implement yet]


=============
Example
=============
----------------
1 - Default testng-file
----------------
mvn clean site -DdriverType=FF -Ptest1														->	full path = '!testngxml!/testng_Tests_All.xml'

----------------
2 - Only testng-file file
----------------
mvn clean site -DdriverType=FF -Ptest2 -Dtestngfile=testng_Tests_All.xml					->	full path = '!testngxml!/testng_Tests_All.xml'

----------------
3 - Full path of testng-file file
----------------
mvn clean site -DdriverType=FF -Ptest3 -Dtestngfile=!testngxml!/testng_Tests_All.xml		->	full path = '!testngxml!/testng_Tests_All.xml'

----------------
4 - REST API
----------------
mvn clean site -DdriverType=FF -Ptest3 -Dtestngfile=!testngxml!/testng_Tests_TestRest.xml	->	full path = '!testngxml!/testng_Tests_TestRest.xml'
