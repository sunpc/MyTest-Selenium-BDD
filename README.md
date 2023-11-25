# MyTest Selenium BDD

This repository contains the base setup of an UI testing project, using Cucumber + Selenium (Page Factory Model) + Spring Boot + Cucumber Reporting.

A simple search in Baidu.com to check that results are displayed is used as example.

# Requirements

* JDK 17
* Maven 3.9.5

# Test Execution

1. Download or clone the repository
2. Open a terminal
3. From the project root directory run:  `mvn clean test`

# Configuration

By default, tests will be executed in Edge (headless mode). 

Preferences can be changed in "application.properties" file

This values can also be defined from the command line when launching the tests without the need of
modify the properties file.

`mvn clean test -Dselenium.browser.headless=false`

# Results

To check the report, open the '/cucumber-html-reports/overview-features.html' file once the execution has finished.

# Links
    
   [Cucumber](<https://docs.cucumber.io/>)
   
   [Gherkin](<https://cucumber.io/docs/gherkin/>)
      
   [Selenium](<https://github.com/SeleniumHQ/selenium>)
      
   [Page Object & Page Factory](<https://www.tutorialselenium.com/2019/02/05/page-object-model-selenium-webdriver/>)
   
   [Spring Boot](<https://spring.io/projects/spring-boot>)
   
   [WebDriverManager](<https://github.com/bonigarcia/webdrivermanager>)
   