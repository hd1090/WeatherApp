## Welcome to Storm - Weather Update Website

Easy to build and use. 

This project is a Java Web Dynamic module which leverages Jersey - JAX-RS specification with Spring Injection to make available REST APIs and a single page application as well.

All you need is this repository, java and maven to build this repository and other dependencies and a tomcat server to host it.


Specific versions used in this project are:

**Maven : Apache Maven 3.6.0**
**Java : Java 1.8**
**Tomcat : Tomcat 9**


Steps to install are (Boot Disk: Ubuntu 18.04):

1. Install and clone this repository:

  ```markdown
  git clone https://github.com/hd1090/WeatherApp.git
  ```
  
2. Install Maven 3.6.0 and Java 1.8
  Make sure apt is up-to date
  ```markdown
  apt update
  ```
  ```markdown
  apt install maven
  ```
  
  Also, java version is above jdk 8, you can check with:
  ```markdown
  java -version
  ```
  

3. Download tomcat 9 - latest version.
  ```markdown
  curl -O http://us.mirrors.quenda.co/apache/tomcat/tomcat-9/v9.0.16/bin/apache-tomcat-9.0.16.tar.gz
  ```
  
  Unzip tomcat
  ```markdown
  tar -xvf apache-tomcat-9.0.16.tar.gz 
  ```

4. Navigate to the Storm directory containing the pom.xml and build using maven and provide the tomcat webapps directory (tomcat_home/webapps) as the commandline argument -D (This is to automatically deploy the war file at the required location):

  ```markdown
  cd WeatherApp/Storm/
  ```
  ```markdown
  mvn clean install -DtomcatDirectory=${CATALINA_HOME}/webapps
  ```

5. Run tomcat. Navigate to tomcat_home/bin and run the startup.sh or startup.bat script.

  ```markdown
  cd apache-tomcat-9.0.16/bin
  ```
  
  ```markdown
  ./startup.sh 
  ```


### That's It!! Go on http://localhost:8080/weather/ and your website is ready. 
You can replace localhost with an IP address as well.
*Note: If you use localhost, auto-detection will not work. The auto-detect location module is based on ip-address and vulnerable to ip masking. Since this application doesn't have senstive information, there is no sever impact of ip spoofing

This site is also live at : http://34.73.167.171:8080/weather/


The API key provided is a trial key and has no guarentee of working. Use your own API_KEY in the 

WeatherApp/Storm/src/main/resources/application.properties

file.

