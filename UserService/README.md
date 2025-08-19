USER SEVICE:

JAVA version: 17

Schema diagram:

DB: SQl

Steps to connect with SQL:

1. Two Dependency is required: JPA and mysql
   a. JPA Maven: https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa/3.5.0
   b. MY SQL Connector: https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/9.3.0
2. Write JPA related prop in application prop:
   link: https://spring.io/guides/gs/accessing-data-mysql
3. cretae Entity -> @Entity use on class
   ORM -> is concept.
   JPA and hibernate are products

what is Flyway?

Note:

1. BaseModel should not be a table But a column of tables we are creating so we will use @MappedSuperClass But we will use @Getter and @Setter

# Authentication

### Bcrypt Implementation:

Steps:

## **1️⃣ Add Spring Security Dependency**

If you don’t already have it, add this to your `pom.xml`:

## **2️⃣ Create a `PasswordEncoder` Bean**

In a config class (e.g., `SecurityConfig.java`):

## **3️⃣ Use bcrypt in `UserService`**

### **Registration — Hash Password Before Saving**

4. Implement Security Config: copy function

ERROR: After Implememting all above steps I was getting 403(Forbidden error)

SOLUTION: disable csrf and cors

Forbid means -> not allowed

Means this is service side error

A "403 Forbidden" error, also known as "HTTP Error 403," means that ==the server understands the request but refuses to authorize it, indicating a lack of permission to access the requested resource.

* **Distinction from 404:**
* Unlike a "404 Not Found" error, where the server doesn't recognize the requested resource, a 403 error means the resource exists, but the user's access is blocked.

# 403 Forbidden

The HTTP **`403 Forbidden`** [client error response](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status#client_error_responses) status code indicates that the server understood the request but refused to process it. This status is similar to [`401`](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status/401), except that for **`403 Forbidden`** responses, authenticating or re-authenticating makes no difference. The request failure is tied to application logic, such as insufficient permissions to a resource or action.

# 401 Unauthorized

The HTTP **`401 Unauthorized`** [client error response](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Status#client_error_responses) status code indicates that a request was not successful because it lacks valid authentication credentials for the requested resource. This status code is sent with an HTTP [`WWW-Authenticate`](https://developer.mozilla.org/en-US/docs/Web/HTTP/Reference/Headers/WWW-Authenticate) response header that contains information on the [authentication scheme](https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/Authentication#authentication_schemes) the server expects the client to include to make the request successfully.

# Implementing/getting Token

We should get token after login:

## Implementation Choice Summary


| Approach       | Maintenance | Spring Integration | Features           | Security | Recommendation      |
| -------------- | ----------- | ------------------ | ------------------ | -------- | ------------------- |
| Apache Commons | Deprecated  | Poor               | Basic              | Medium   | ❌ Avoid            |
| jjwt           | Active      | Excellent          | Comprehensive      | High     | ✅ Recommended      |
| Nimbus         | Active      | Good               | Very Comprehensive | High     | 👍 Good alternative |
| Auth0          | Active      | Good               | Good               | High     | 👍 If using Auth0   |
| Manual         | N/A         | None               | Minimal            | Risky    | ❌ Never            |

I implemented Apache common lang.

Steps:

1. search apache lang3 in mvn reppository
2. create a Token class/ Entity
3. in login Authservice file do changes -> generate token using RandomString Method and then do expiryAt save these things in Token class
4. Here Password is Bcrypt generated not token

# Assignment/Doubts:

Q1: Why constructor injection is recommanded way and not field injection

Q2: When a client send an api put a token in path of api then verify the token and send the response

# Communication Between Two Services

1. create AuthCommon  file , anotate it as component.
2. then make changes in service file, call the api of UserService
3. make changes in controller

### Setting CreatedBy default:

1. Using Spring Security AuditorAware (Recommended)

# OAuth2 Impelmentation

1. write dependency in pom.xml
2. convert yaml file to .properties file
3. write securityConfig->  all these are present in spring offical site
4. Make changes in user password, becs if u login it wont work, it requires bcrypt password. if u put bcrypt password inside password string then u will able to pass login section but it will give error.
5. To resolve error, we need to connect with db

# Implement OAuth2 with DB/JPA( Core Services with JPA )

https://docs.spring.io/spring-authorization-server/reference/guides/how-to-jpa.html

### Steps:

1. Make models and copy all model class from above link.
2.
