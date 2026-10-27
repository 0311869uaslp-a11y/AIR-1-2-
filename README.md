# Distributed Internet Applications (AIR) — Java Enterprise & Spring Framework

Academic coursework, practical exercises, and Java projects developed while studying **Applications Internet Réparties (AIR)** (Distributed Internet Applications). This repository brings together examples of enterprise Java development, dependency injection, web applications, persistence, distributed components, security, and software testing.

> **Repository scope:** A collection of laboratory exercises, example applications, and assignment handouts—not a single deployable application. Some folders contain alternative or corrected versions of the same exercise. The exact runtime requirements depend on each project.

## Course overview

The course explores how Java applications are structured into reusable components and layers, how web clients communicate with server-side code, and how enterprise applications manage persistence, security, and deployment. Practical work includes both Spring-based applications and traditional Java EE technologies.

### Topics covered

| Area | Concepts and practical work |
| --- | --- |
| Java enterprise fundamentals | Project structure, components, application lifecycle, configuration, and modular design |
| Spring Core | Inversion of Control (IoC), dependency injection, XML-based bean configuration, autowiring, and qualifiers |
| Layered architecture | Separation of model, data-access (DAO), service, and controller responsibilities |
| Web applications | HTTP request handling, Java Servlets, form processing, and server-side deployment |
| Spring MVC | Controllers, request mappings, view resolution, form binding, validation, and model–view–controller architecture |
| RESTful services | REST concepts and API-oriented exercises, documented in the REST assignment handout |
| Hibernate ORM | Entity mapping, sessions, object–relational persistence, and Hibernate configuration |
| Java Persistence API (JPA) | Entity classes, persistence units, `EntityManager`, and persistence configuration |
| Data access with Spring | JDBC-based DAO patterns, Spring JDBC support, and database integration |
| Enterprise JavaBeans (EJB) | Stateless enterprise components, local and remote interfaces, client/server interaction, and application-server deployment |
| Aspect-Oriented Programming | Cross-cutting concerns, aspects, and logging with Spring AOP |
| Application security | Authentication, authorization, login flows, and Spring Security configuration |
| Testing | JUnit tests, DAO tests, and database test fixtures |
| Development workflow | Eclipse IDE, Maven, Java runtime configuration, application servers, and troubleshooting port conflicts |

## Repository contents

### Spring fundamentals and architecture

| Folder | Description |
| --- | --- |
| [`tp1-spring/`](tp1-spring/) | Introduction to Spring beans and dependency injection; entry point: `TestTP1.java` |
| [`tp2-spring/`](tp2-spring/) | Spring configuration and qualifier-based bean selection; `TestTP2.java` and `TestQualifier.java` |
| [`tp3-spring/`](tp3-spring/) | Layered design with model, DAO, and service classes; `TestTP3.java` |
| [`TP7/`](TP7/) | Spring AOP logging aspect and JUnit test (`MonServiceTest.java`) |

### Persistence and database access

| Folder | Description |
| --- | --- |
| [`tp4/`](tp4/) | Hibernate example with `Personne`, `Adresse`, and `hibernate.cfg.xml` |
| [`tp4_2/`](tp4_2/) | JPA persistence examples with `persistence.xml` and `TestJPA.java` |
| [`TP4_2_2/`](TP4_2_2/) | Another JPA exercise/version; the Maven project is nested under `TP4_2/` |
| [`TP6/`](TP6/) | Spring JDBC/DAO implementations and JUnit/DBUnit-oriented database tests |

### Spring MVC and web security

| Folder | Description |
| --- | --- |
| [`tp4-spring-mvc/`](tp4-spring-mvc/) | MVC example for managing leave requests, with controllers, services, and validation |
| [`TP5/`](TP5/) | Spring MVC application using Java-based configuration and controllers |
| [`tp5-corrige-main.zip_expanded/`](tp5-corrige-main.zip_expanded/) | Corrected/alternative TP5 material; the application is in the nested `tp5-corrige-main/` directory |
| [`TP8/`](TP8/) | Spring MVC extended with Spring Security, login, and access control |

The Spring MVC exercises use a **leave-request management** domain (`Collaborateur`, `DemandeConge`, and related classes) to demonstrate web application structure.

### Servlets, Java EE, and EJB

| Folder | Description |
| --- | --- |
| [`weblet/`](weblet/) | To-do-oriented servlet (`AddTodoServlet.java`) |
| [`formulario/`](formulario/) | Servlet-based form processing (`FormularioServlet.java`) |
| [`helloworld-servlet/`](helloworld-servlet/) | Basic Hello World servlet |
| [`helloWorld/`](helloWorld/) | Java web application example |
| [`TP2/`](TP2/) | Eclipse web-project skeleton; no Java source implementation identified |
| [`TP3/`](TP3/) | EJB Hello World example with local and remote interfaces |
| [`HelloBean/`](HelloBean/) | EJB bean, remote interface, and client example |
| [`HelloEJB/`](HelloEJB/) | Additional EJB-related project material |
| [`HelloWorldEJB/`](HelloWorldEJB/) | EJB Hello World implementation with local/remote contracts |
| [`HelloWorldClient/`](HelloWorldClient/) | Java client for an EJB example |

### Assignment handouts

- [`TAREA_1/`](TAREA_1/) — AIR practical assignment 01 (including a Spanish version).
- [`Tarea_2/`](Tarea_2/) — AIR practical assignment 02: REST.
- [`Tarea_3/`](Tarea_3/) — AIR practical assignment 03: EJB, plus supporting material.
- [`Tarea_4/`](Tarea_4/) — AIR practical assignment 04: JPA and Hibernate.

These folders contain PDF handouts rather than runnable Java applications.

## Technologies and tools

**Languages and frameworks:** Java, Spring Core, Spring MVC, Spring Security, Spring AOP, Hibernate, JPA, JDBC, Java Servlets, EJB, JUnit, and DBUnit (where configured).

**Development and deployment:** Eclipse IDE, Apache Maven, Apache Tomcat, and a Java EE/Jakarta EE-compatible application server for EJB projects.

**Data persistence:** Relational database connectivity and ORM. Database engines, credentials, schemas, and versions must be checked in each project's configuration rather than assumed to be shared across the repository.

## Getting started in Eclipse

### Prerequisites

- **Eclipse IDE for Enterprise Java and Web Developers**.
- An appropriate **JDK** for each project (the repository contains legacy and newer Java configurations; do not assume one JDK works for all).
- **Maven** support (typically included through Eclipse m2e).
- **Apache Tomcat** for compatible servlet and Spring MVC web applications.
- A compatible **Java EE application server** (such as a suitable WildFly or GlassFish version) for EJB deployments.
- A relational database server for persistence exercises that require one.

> **Compatibility note:** Some examples use older `javax.*` APIs. Tomcat 9 is generally more suitable for `javax.servlet` applications than Tomcat 10+, which uses `jakarta.servlet`. Match the Java version, server version, and dependency versions to each project's configuration.

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/YOUR_REPOSITORY.git
cd YOUR_REPOSITORY
```

Replace the placeholder URL with the actual GitHub repository address.

### 2. Import projects into Eclipse

For existing Eclipse projects:

1. Select **File → Import → General → Existing Projects into Workspace**.
2. Choose the repository directory.
3. Select the detected projects and click **Finish**.

For Maven projects not detected automatically:

1. Select **File → Import → Maven → Existing Maven Projects**.
2. Choose the directory containing the relevant `pom.xml`.
3. Finish the import, then right-click the project and select **Maven → Update Project**.

### 3. Run the standalone Spring examples

Start with the following Java entry points:

| Project | Class | Eclipse action |
| --- | --- | --- |
| `tp1-spring` | `com.ecoalis.TestTP1` | Run As → Java Application |
| `tp2-spring` | `com.ecoalis.TestTP2` | Run As → Java Application |
| `tp2-spring` | `com.ecoalis.TestQualifier` | Run As → Java Application |
| `tp3-spring` | `com.ecoalis.TestTP3` | Run As → Java Application |
| `tp4` | `tp4.univ.paris13.model.Test` | Run As → Java Application (database required) |

For the JPA examples, locate and run the corresponding `TestJPA.java` class after configuring the persistence unit and database.

### 4. Run automated tests

For `TP6`, open a test class under `src/test/java/com/ecoalis/dao/` and choose **Run As → JUnit Test**. For `TP7`, run `MonServiceTest.java` in the same way. Database-related tests may require a running database and test data.

### 5. Run web applications

1. Configure a compatible Tomcat server in **Window → Show View → Servers**.
2. Import the web application into Eclipse.
3. Right-click the project and choose **Run As → Run on Server**.
4. Open the application's configured context path in your browser.

The exact URL and available routes depend on the project's controller mappings, deployment descriptor, and server configuration.

### 6. Deploy EJB applications

EJB projects require a compatible application server. Configure and start the server, deploy the EJB module, and then run the matching client with the appropriate naming/JNDI and client dependencies. A standalone client generally cannot invoke an undeployed EJB.

## Checking occupied ports on Windows

If Tomcat or another server fails to start because a port is already in use, open Command Prompt and run:

```cmd
netstat -ano | findstr :8080
```

Identify the process using the reported PID:

```cmd
tasklist /FI "PID eq 1234"
```

Replace `1234` with the actual PID. You can also inspect or change Tomcat's HTTP port in the **Servers** view in Eclipse. Do not terminate a process before identifying it.

## Learning outcomes

Through these exercises, the course develops the ability to:

1. Structure Java applications using layered and component-oriented architectures.
2. Configure and connect objects through Spring dependency injection.
3. Build and deploy HTTP applications using Servlets and Spring MVC.
4. Implement data persistence with Hibernate, JPA, and Spring JDBC.
5. Understand local and remote enterprise components with EJB.
6. Apply logging aspects and basic web authentication/authorization.
7. Write and run unit and data-access tests.
8. Diagnose build, dependency, deployment, and port-configuration issues in Eclipse.

## Notes

- Projects are preserved as **coursework and learning references** and may require environment-specific adjustments before they run.
- Some directories include generated Eclipse or Maven artifacts, and some examples overlap in purpose.
- The REST topic is explicitly represented by an assignment handout; a complete REST API implementation is **not independently confirmed** by the inspected Java project inventory.
- Avoid committing actual database passwords, private configuration files, or other secrets when publishing the repository.

## Academic context

**Course:** Applications Internet Réparties (AIR) — Distributed Internet Applications  
**Focus:** Enterprise Java, distributed application development, web frameworks, and persistence  
**Purpose:** Educational laboratory exercises and technical reference

---

*This repository documents practical learning in Java enterprise application development and distributed web systems.*
