



all
mvn clean site -DdriverType=ff

mvn clean site -DdriverType=ff -Ptest1

mvn clean site -DdriverType=ff -Ptest2 -Dtestngfile=testng_Tests_All.xml

mvn clean site -DdriverType=ff -Ptest3 -Dtestngfile=!testngxml!/testng_Tests_All.xml

testng_Tests_All.xml 				- run all tests
testng_Tests_Group_Error.xml 		- run test of error group
testng_Tests_OneMethod.xml 			- run test



report
/Users/admin/Documents/DevS-iOS/java/workspaces/Demo/ForioEpicenter_Selenium3_RestAPI/target/site/allure-report/index.html