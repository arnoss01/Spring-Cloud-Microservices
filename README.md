# Spring Cloud Microservices
  This project provides a comprehensive exploration of microservices using the Spring Cloud framework and various open-source tools from Netflix. Developed by **EL HADDAD Anas** and **LOUZAR Mehdi**.
# Project Overview

  This project provides an overview of microservices using Spring Cloud and Netflix Open Source software. It is a collaborative effort by Selaiman Kassou and Yassin Cherchem.

## Configuration Notes

  - Multiple projects with varying Java and Spring versions require configuring the `JAVA_HOME` environment variable for specific projects.
  
## Microservices Focus

  The primary objective of these microservices is Product and Order management. The project comprises:

### Business Microservices

  - **Products Microservice**
  - **Orders Microservice**

### Technical Microservices

  - **Reverse Proxy**
  - **Config Server**
  - **Registration Server**

## IDE Agnostic

  This project is IDE agnostic, designed for server deployment rather than being tied to a specific Integrated Development Environment (IDE). It is essential to install the necessary dependencies for optimal execution.

## Commands and Environment

  The commands used in this repository are Unix-based. Ensure familiarity with Unix command syntax for effective usage.

## Note

  Adapt the environment and configurations based on your specific requirements and development setup.

## Contact

  For further information, feel free to contact us.

- [EL HADDAD Anas](mailto:elhaddadanas@gmail.com)

# Projects

  - **config.server:** Spring Cloud Config Server.
  - **eurekaserver:** Netflix Eureka Server.
  - **zuul-server:** Netflix Zuul API Gateway.
  - **mproduits:** The Products Microservice.
  - **microservice-commandes:** The Orders Microservice.
  - [**mcommerce-config-repo:**](https://github.com/arnoss01/mcommerce-config-repo) The repository used by the Config Server to fetch configurations for each microservice.

# Dependencies

  This project relies on the following dependencies:
  
  - [Maven CLI](https://maven.apache.org/)
  - [JDK 17](https://openjdk.java.net/projects/jdk/17/)
  - [JDK 8 / 1.8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
  
  Make sure to have these dependencies installed on your system before running the project.

# Launching the Microservices

  Follow these steps to launch the microservices:
  
  - **Clone the repository and navigate into it:**
  
    ```bash
    git clone <repository-url>
    cd <repository-folder>
    ```
  
  - **Config Server:**
    - Navigate to the config server project.
    - Run the project:
  
    ```bash
    export JAVA_HOME=/your/java/17/home/path
    mvn spring-boot:run
    ```
  
  - **Eureka Server:**
    - Navigate to the Eureka server project.
    - Run the project:
  
    ```bash
    export JAVA_HOME=/your/java/8/home/path
    mvn spring-boot:run
    ```
  
  - **Zuul API Gateway:**
    - Navigate to the Zuul API Gateway project.
    - Set the JAVA_HOME to JDK 8.
    - Run the project:
  
    ```bash
    export JAVA_HOME=/your/java/8/home/path
    mvn spring-boot:run
    ```
  
  - **Products Microservice:**
    - Navigate to the products microservice project.
  
    ```bash
    export JAVA_HOME=/your/java/17/home/path
    mvn spring-boot:run 
    ```
  
  - **Orders Microservice:**
    - Navigate to the orders microservice project.

    ```bash
    export JAVA_HOME=/your/java/17/home/path
    mvn spring-boot:run 
    ```
  
  Now, you're ready to test and interact with the launched microservices.

