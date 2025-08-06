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
