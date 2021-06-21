# Hudl Test Automation Project

## Quick start Guide
Full instructions are below in the Installation Guide section below, but, if you feel comfortable knowing what to do, 
then for a quick start:
1. Install Java 8 JRE and include it in your PATH environment variable
2. Install Maven and include it in your PATH environment variable
3. Ensure the latest version of Chrome is installed (see note below, be default this project works with Chrome: 91.0.4472.101),
but you can easily override if you have a different version.
4. To run all tests:
    * (on Windows) `mvn clean install -Dhudl.username=<USERNAME> -Dhudl.password=<PASSWORD>`
    * (on Linux) `mvn clean install -Dhudl.username=<USERNAME> -Dhudl.password=<PASSWORD> -Dwebdriver.chrome.driver=drivers/chromedriver`
    * view test report in *target/site/serenity/index.html*
5. To run linting:
    * `mvn clean install site -DskipTests`
    * view output report in *target/site/index.html*, and browse to Project Reports -> CheckStyle in the html page

NB: I've not tested the ability to run on Mac OS. However the project does pull the MAC chromedriver so the command to run
would be:
`mvn clean install -Dhudl.username=<USERNAME> -Dhudl.password=<PASSWORD> -Dwebdriver.chrome.driver=drivers/mac-chromedriver`

### Browsers - running with Chrome and Chrome version
The project assumes you are have Chrome installed and are running Chrome version: 91.0.4472.101 (the latest at time of creation). 
If your version differs (you can check in Chrome -> Help -> About Google Chrome), then you can edit the following line in pom.xml:
`<chromedriver.version>91.0.4472.101</chromedriver.version>` 

For a first version, I have only provided the ability to run on Chrome. Extending to Firefox, Edge etc is straight-forward
as the Serenity library supports these browsers.


---
## Full Installation Guide and Running Tests
If you've not been successful running with the Quick Start Guide, then follow these steps before running tests for the first time.

### Pre-requisite step 1: Install Java JDK/JRE
To run tests, you require the Java 8 JRE installed on your system, and the JAVA_HOME and PATH environment variables set.
To develop tests, you require the Java 8 JDK installed, and the same environment variables set.

To install Java JDK/JRE, download from (if you already have these, then you do not need to re-install:
JRE: https://www.oracle.com/uk/java/technologies/javase-jre8-downloads.html
JDK: https://www.oracle.com/uk/java/technologies/javase/javase-jdk8-downloads.html

To set the environment variables:
* Add an environment variable called JAVA_HOME set to the path where .../jre/bin/java is available, eg:
  JAVA_HOME=/usr/lib/jvm2/jdk1.8.0_281/jre/bin/java
* Append the JDK and/or JVM bin directories to your PATH environment variable,
  eg. for the JRE on Linux: /usr/lib/jvm2/jdk1.8.0_281/jre/bin/
  eg. for Windows: c:\Program Files\Java\jdk1.8.0_281

### Pre-requisite step 2: Install Maven
* Download and extract the latest Maven version for your operating system from: https://maven.apache.org/download.cgi
* Append the bin directory of Maven to your system's PATH environment variable, eg: c:\apache-maven-3.6.3\bin
* To verify this is set up correctly, run "mvn" (Linux) or "mvn.exe" (Windows) from a command line and ensure Maven runs
  (but at this point will return an error.)

### Pre-requisite step 3: Ensure you are running the latest version of Chrome
See above for Chrome version and usage.
I have included a Maven plugin to download the driver automatically before tests start running, however this has some 
limitations, in that you have to provide the version number (by default it pulls a very old version).
If you are running this when Chrome 92+ is available, then you will need to edit the top level pom.xml and change the
version in <chromedriver.version>.

### Running Tests
The commands to run are in the Quick Start section above for different operating systems.
NB: the first execution may take a while to get started as Maven is downloading dependencies. Further test executions 
will not have the same overhead time.

#### Running Tests: Advanced Configuration 1 - changing runtime configuration
If you want to extend the framework, all configurable settings are in *test-runner.properties*.
This file has been set up with various configurable options. Some of these are currently supported, some
require documentation on valid settings, and some are for future improvements to demonstrate how to extend the codebase
easily and quickly. For example, all the plumbing is in place to support different browsers and OS's, but not tested.

* The chrome-switches configuration used in `test-runner.properties` by default launches each browser session in incognito
  mode in Chrome. This means Chrome opens in a deterministic state which is important for log-in tests. It is possible
  to also run in headless mode which is around 15-20% quicker to execute - see comments in the `test-runner.properties`
  to run.

#### Running Tests: Advanced Configuration 2 - Running subsets of tests
The feature files have been tagged by feature, so it is possible to run subsets of tests by either editing the 
test-runner.properties file line `cucumber.options` or by passing in a command line argument: `-Dcucumber.options=` and 
supplying the tags you wish to run with.

It's also possible to change the URL of the application under test in the test-runner.properties, by editing the
test.url property

---
## Additional notes on implementation
### Technology choice
I have chosen to use Java for this exercise, as it showcases my knowledge and experience best. I feel this project can
demonstrate my understanding of test automation best practices and coding standards (eg. linting,  extensibility and 
configurability). I do feel confident that within a short amount of time, I am able to implement automation in other 
languages and apply the concepts and quality that I hope I have demonstrated here.

The main library used in this project is Serenity (http://www.thucydides.info/#/). This is something I have used during
my career as it supports quick and very effective test automation while helping enforce good practices and structuring.
I hope to have demonstrated here that I am able to learn how to use a framework, understand the best practices and usages,
and apply that thoroughly rather than just take the basics.

I've used Maven as it is a dependency management tool while also allowing us to use plugins to perform tasks needed.

### Compile/Runtime linting and JavaDocs
I've included a linting plugin called checkstyle, which is a highly configurable plugin.
To run linting:
* Run: `mvn clean install site -DskipTests`
* When this is complete, there will be a set of reports in *target/site*, open checkstyle.html.
* The report currently contains a series of errors related to JavaDoc comments. While I have attempted to add JavaDoc
  comments for all page object classes and methods, there are still some further improvements to make for other classes.

### Note on locators
I have predominantly used CSS selectors, as these tend to be reliable. Where just an id can be directly used, I use that
as it is clearer to someone reading code. I noticed the "data-qa-id" attribute was available in the navigation bar, so 
have used this where possible using CSS selectors, as I assumed these have been added to support testing. Where these are not possible,
I have tried to use locators that are as reliable as possible.

### Test Reports
The following test reports are available
* *target/site/serenity/index.html* - full Serenity output report including analysis by feature, screenshots of each step etc
* *target/cucumber/index.html* - basic cucumber standard report

I've included *TestPreAndPostProcessor* Listener class for future implementation for test reports and test failure 
handling/information. This would enable quick feedback if test results/failures are streamed to a separate service, so
we don't have to wait for the full execution to complete.

---
## Code structure details/explanations
The code is structured in 4 levels as described below. For a small project, this may seem excessive, however I have 
tried to create an automation framework that could be extended and scale. Some examples of the code are relatively simple
for the log-in scenarios, but practices like inheritance and composition are vital to creating a robust and resilient 
automation framework that supports re-use and quick implementation of new tests.

### 1. Feature Files
The test scenarios have been written as BDD scenarios using Gherkin syntax. I have tried to ensure the scenarios are 
understandable to anyone without knowledge of the UI implementation, so they describe the behaviour of the system (ie. 
WHAT the system does).
My scenarios cover positive login and logout scenarios, negative log-in scenarios (eg. invalid/blank usernames/passwords), 
verification of other functionality on the UI (eg. Remember Me and Need Help).

Going forward (with more time and working knowledge of the system), I would consider adding scenarios for:
* security - eg. JavaScript injection, and maximum retries on failure, session time outs
* performance - verifying how long it takes to perform the log-in and load the UI
* functional - verification of expected data and configuration post-login (for example, I noticed at time the UI strings 
showing in different languages)

### 2. Step Definitions
The Step Definitions act as the glue between the Given/When/Then statements in feature files and the Steps classes. 
The Step Defintions are intended to be simple methods and turn the WHAT of the Given/When/Then statements into HOW to 
perform those actions.

### 3. Steps Classes
My general approach is firstly to create Steps classes and methods that perform Actions or Assertions. I broke down the 
classes by logical understanding of the login procs so it should be easy to find methods for re-use. And I added JavaDocs 
to describe the purpose of each method. The Steps are called from Step Definitions.
This means the Step Definitions become an imperative style list of instructions and the Steps contain the logic for
performing those instructions.
In turn, the Steps call off to the Page Object classes.

### 4. Page Objects Classes
I attempted to represent the functionality of pages involved in logging into Hudl into Java classes. I used inheritance,
for example from the LoginPage class to the HudlWebsiteHome class, and used composition to breakdown page content, eg to
separate out the NavigationBar in order to have more readable code and reliable UI locators.

---
## Future enhancements
To extend and grow this framework further, I would look to:
* Run tests against more controlled environments, eg. Selenium Hub, BrowserStack where the versions of browsers are
  known and managed. This would then support the ability to run on more browsers, devices and environments.
* Capture browser console logs on test failure. This could be implemented in the testFailure method in the
  TestPreAndPostProcessor listener class.
* Expand test users into a database of users with metadata (eg. to define deterministic configuration to verify later)
* The entire structure and re-usability, extensibility, configurability of the codebase has taken into account usage in
  CI/CD pipelines eg. in Jenkins, going forward.
* I would like to implement parallelisation of test executions. Based on the concept of ensuring tests are self-contained
  this should be possible. To run parallel tests, it would require some more work around user management to ensure there
  is no conflicting data for users as tests run.
