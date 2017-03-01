<p align="center">
  <img src="http://www.gregoriopalama.com/wp-content/uploads/2016/06/cloud.png" alt="Spring Cloud Netflix"/>
</p>

## Lab 3 - Create a Spring Cloud Config Server and Client

**Part 2 - Config Client:**

9. Create a new, separate Spring Boot application.  Use a version of Boot < 1.3.x.  Name the project "lab-3-client", and use this value for the Artifact.  Add the web dependency.  You can make this a JAR or WAR project, but the instructions here will assume JAR.

10.  Open the POM (or Gradle) file and add a “Dependency Management” section to identify the spring cloud parent pom. (You could simply change the parent entries, but most clients will probably be ordinary applications with their own parents):
    ```
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-parent</artifactId>
                <version>"Camden.SR2"</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
```
11.  Add a dependency for group "org.springframework.cloud" and artifact "spring-cloud-starter-config”.  You do not need to specify a version -- this is already defined in the parent pom in the dependency management section.

12. Add a bootstrap.yml (or bootstrap.properties) file in the root of your classpath (src/main/resources recommended).  Add the following key/values using the appropriate format:
spring.application.name=lab-3-client
spring.cloud.config.uri=http://localhost:8001  
server.port=8002

    _(Note that this file must be "boostrap" -- not "application" -- so that it is read early in the application startup process.  The server.port could be specified in either file, but the URI to the config server affects the startup sequence.)_

13. Add a REST controller to obtain and display the lucky word:

    ```
    @RestController
    public class LuckyWordController {
 
      @Value("${lucky-word}") String luckyWord;
  
      @RequestMapping("/lucky-word")
      public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
      }
    }
    ```

14.  Start your client.  Open [http://localhost:8002/lucky-word](http://localhost:8002/lucky-word).  You should see the lucky word message in your browser.

  **BONUS - Profiles:**

15. Create a separate file in your GitHub repository called "lab-3-client-northamerica.yml” (or .properties).  Populate it with the "lucky-word" key and a different value than used in the original file.

16. Stop the client application.  Modify the boostrap file to contain a key of spring.profiles.active: northamerica.  Save, and restart your client.  Access the URL.  Which lucky word is displayed?  (You could also run the application with -Dspring.profiles.active=northamerica rather than changing the bootstrap file)

##Info

- [x] **[Microservices with Spring Cloud (Udemy)](https://www.udemy.com/microservices-with-spring-cloud/learn/v4/overview)**

- [x] **Instructor: [Ken Krueger, Technical Instructor in Software Development topics](https://linkedin.com/in/ken-krueger-43670111)**
