## Welcome to Storm - Weather Update Website

Easy to build and use. 

This project is a Java Web Dynamic module which leverages Jersey - JAX-RS specification with Spring Injection to make available REST APIs and a single page application as well.

All you need is this repository, java and maven to build this repository and other dependencies and a tomcat server to host it.


Specific versions used in this project are:

**Maven : Apache Maven 3.6.0**
**Java : Java 1.8**
**Tomcat : Tomcat 9**


Steps to install are:

1. Install and clone this repository:

```markdown
git clone ...
```
2. Install Maven 3.6.0 and Java 1.8

3. Download tomcat 9 - latest version.

4. Build using maven and provide the tomcat webapps directory (tomcat_home/webapps) as the commandline argument -D (This is to automatically deploy the war file at the required location):

```markdown
mvn clean install -DtomcatDirectory=${CATALINA_HOME}/webapps
```

5. Run tomcat. Navigate to tomcat_home/bin and run the startup.sh or startup.bat script.


### That's It!! 

