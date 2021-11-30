# Java Persistence


### Java Version
This sample requires you to have
[Java11][Java11].

### Download Maven
To get started, [download][maven-download] and [install][maven-install] it.

### Setup [Docker][docker] containers:

* Start all containers:

    ```shell
    docker-compose -f docker-compose.yml -p persistence up -d
    ```
* Start specific container:

   ```shell
   docker-compose -f docker-compose.yml -p persistence up -d neo4j
   ```
### Run Application

* In the specific path of each project, open the shell console, install the dependencies and run the application:

    ```shell
    mvn clean install -Dmaven.test.skip=true
    ```
    ```shell
    mvn spring-boot:run
    ```

### Authors:

[Luan Fernandes](https://github.com/souluanf) 


[maven]: https://maven.apache.org
[maven-download]: https://maven.apache.org/download.cgi
[maven-install]: https://maven.apache.org/install.html
[Java11]: https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html
[docker]: https://www.docker.com/get-started