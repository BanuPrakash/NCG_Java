# Java

Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd., 

Email: banuprakashc@yahoo.co.in; banuprakash.cr@gmail.com; banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/NCG_Java

===================================

Softwares Required:
1)  openJDK 17
https://jdk.java.net/java-se-ri/17

2) IntelliJ Ultimate edition 
https://www.jetbrains.com/idea/download/?section=mac


3) MySQL on Docker

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```

OOP 

--> Programs which resemble real world application
Object communicates with other object by sending messages. What messages an object can take is exposed thro its interface.

Object --> state and behaviour

SOLID design principle

S --> Single Responsibility
O --> open Close Principle [ Closed for Change  & open for extension]
L --> Liskov Substitution Principle
    Genralization and Specialization 
I --> Interface Seggregation
D --> Dependency Injection

===========================

Java ?
Java is a technology which has a platform to run/execute bytecode

Byte code can be generated by using different programming languages / Compilers

Java programming language --> JDK --> javac
Kotlin --> KDK --> Kotlin Compiler
Groovy --> GDK --> Groovy compiler

Compile time Environment:
```
public class Account {
    private double balance ; // state
    private static int count; // state of class
    
    public Account() {
        count++;
    }
    
    public void deposit(double amt) {
        this.balance += amt;
    }

    public double getBalance() {
        return this.balance;
    }

    public static int getCount() {
        return count;
    }
}

javac Account.java ---> Account.class


public class AccountExample {
    public static void main(String[] args) {
        Account rahulAcc = new Account();
        rahulAcc.deposit(45000);

        System.out.println(Account.getCount()); // 1
        Account swethaAcc = new Account();
        swethaAcc.deposit(50000);

        System.out.println(swethaAcc.getBalance());
         System.out.println(Account.getCount()); // 2
    }
}

javac AccountExample.java --> AccountExample.class

```

JRE --> Java Runtime Environment

1) ClassLoader
    findLoadedClass(), 
    loadClass(), --> Classpath ENV variable
    findSystemClass()
    defineClass() --> Convert Bytecode to system specific DataStructure

2 java AccountExample [JRE --> classLoader]
2.1) classloader
2.2) Main Thread is started --> Unit of Work

 public void deposit(double amt) {
translate to:
public void deposit(Account this, double amt) {
    this.balance += amt;
}
context.behaviour(arguments);
rahulAcc.deposit(45000); ==> deposit(rahulAcc, 45000);

===========

Logically Grouping of classes/Object
1) Entity class
    business data
    Example:
    a) Uber
    Customer, Vehicle, Driver, Payment, Trip ...

    b) Swiggy
    Customer, Product, Order, LineItemm Payment, ShipAddress

    These classes contains instance variables / state, constructorss, getters and setters, hashCode, equals

    ``
    public class Customer {
        String email;
        String firstName;
        ...

    }
    ```
2) DAO: Data Access Object
    they contain CRUD operaions
    CREATE READ UPDATE and DELETE operations
    generally one per table
    ```
    public class CustomerDao {
        public void register(Customer c) {
            "INSERT into customers.."
    
        }

        public boolean login(Customer c) {
            select ...
        }
    }
    ```
3) Business Class:
    business logic
4) Service classes : are a facade over DAO and business class
    generally one per actor

```
    public class BankingService {

        public void transferFunds(Account fromAcc, Account toAcc, double amt) {
            accountDao.getBalance(fromAcc); // 
            businessLogic.checkEligible();
            accounDao.updateAccount(fromAcc);
            accountDao.updateAccount(toAcc);
            transactionDao.insertTx(fromAcc, toAcc);
            sendSMS()
            sendEMail();
        }

    }

```
5) Client
    Web Client / Desktop client / Mobile Client / Hardware ...

6) Utility classes : Helpers
7) Exception classes: to represent any abnormal condition in application
    Why?
    a) What went wrong
    b) Why?
    c) Where?

----

packages: folders for grouping related classes

``
com
 |
 adobe
    |
    aem
     |
     entity
        Customer.class
        Product.class
     dao
        CustomerDao.class
        Product.class
    service
        CustomerService.class

```

Relationship between Objects:
1) Generalization and Specialization
2) Realization
3) Uses A relationship
4) Association


Generalization and Specialization: Inheritance ==> IS A relationship

Mobile m = new Mobile(); memory is created for id, nam, price and connectivity
all the methods of Product + getter and setter for connectivity;

m.setPrice(3333); // is this valid?

Product p = new Mobile(); 
p.setPrice(4444); // valid
p.setConnectivty("5G"); ???? 
p.isExpensive(); // which method --> calls method in Mobile and not Product class --> dynamic binding

instance methods are dynamic binding / runtime binding
static methods are compile time bindings
all instance methods in Java are virtual by default.

static methods --> don't call overriding --> shadowing
variables --> shadowing

======

abstract keyword
1) use it with class to specify that it's too generic, can't exist in real world
can't instantiate a abstract class

2) use it on method --> pure virtual function


note: Java doesn't support multiple inheritance

Visbility:
private
public
protected: visible to all classes within the same package + inherited classes
default:  visible to all classes within the same package

=====================

Realization relationship

A Component will realize the behaviour specified by other component in order to communicate

Program to contract.

In java as in real world we use interfaces for this.

interface EmployeeDao {
    void addEmployee(Employee e);
}


Why should we program to interface?
1) DESIGN
2) IMPLEMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE COUPLING

interfaces are like complete abstract classes, can't instantiate 

interface Flyable {
    fly();
}
class Eagle extends Bird implements FLyable {
    ///

    public void fly() {

    }
}


class AeroPlane extends Vehicle implements Flyable {
    ..
    public void fly() {

    }
}

Class.forName("java.lang.String"); // loads String class into METASPACE
Class.forName("com.adobe.prj.entity.Product");

=================================

Day 2

Recap:

Object --> state & behaviour

Template for Object
* Java / C++ / C# --> class
class Product {}
* JavaScript --> function
function Product() {}
* Oracle --> Type
Type Product 

===========
* all methods in interface by default are public and abstract

Fight f = new Hero();

f.fight();

f.swim();

Swim s = (Swim) f;

s.swim(); // works

public void fightSequence(Fight[] fight) {
    ...
}

Comparable interface --> 

```
class AddComputation implements Computation {
     @Override
            public int compute(int firstArg, int secondArg) {
                return firstArg + secondArg;
            }
}

class SubComputation implements Computation {
     @Override
            public int compute(int firstArg, int secondArg) {
                return firstArg - secondArg;
            }
}

Computation add = new AddComputation();
```

Annotation?
Metadata --> data about data.

1) Who uses it?
    * COMPILER
    * CLASSLOADER
    * RUNTIME [JRE]
2) Where can I use it?
    * TYPE --> class / interface / Annotation / Record / Enum
    * METHOD
    * FIELD
    * PARAMETER

@Override ==> Compiler and METHOD
@SuppressWarnings ==> Compiler

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Platform {
    String value();
}

a = value;
value = x;

@Platform("android")
public class PubG extends Game {

}

Compiler --> keeps annotation in .class file

Classloader ==> Samsung / OnePlus

===========

Annotations contains properties; no fields and methods

Java Collection Framework
* interfaces 
* Implementation classes
* Utility / Algorithm classes

Data Containers:
array is a data container: --> size is fixed, adding at end, removing from end


Collection type:
1) List
* ordered
* allows index based operations
* duplicates are allowed
* can be re-ordered

ArrayList, LinkedList, vavr, Apache Collections

2) Set
* unique collection
* not ordered
* Can't re-order
3) Queue

Vector and Stack are legacy collection; very slow; allow methods of these collections are using locking mechanism to avoid data corruption
all methods are synchronized

Collections --> contains algorithms similar to Arrays

```
Usage:

1) BAD, not typesafe
ArrayList list = new ArrayList();
list.add("A");
list.add(new Product());
list.add(new Date());

if(list.get(0) instanceof Date) {
    Date d = (Date)list.get(0);
}

2) Typesafe --> BAD because changing implemention is difficult
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add(new Product()); // ERROR

3) Prefer
List<String> list = new ArrayList<>(); 
list.add("A");
list.add(new Product());

doTask(list);

public void doTask(List<String> list) {

}
```

HOF : High Order Functions

 higher-order function is a function that does at least one of the following: 
 * takes one or more functions as arguments, 
 * returns a function as its result. 
 
 All other functions are first-order functions. 

Commonly used HOF:
1) filter : subset
2) map: transform
3) forEach: iterate
4) reduce: aggregate [sum, avg, count, ...]
5) limit: 10
6) skip
7) collect

https://rxmarbles.com/

========================

Web application with database connectivity

Java build tools: Maven/Gradle
* Uniformity across all team members
* Manage dependecies [ libraries ]
* automate tasks like compile / testing / Static code analysis / build / package

pom.xml or build.gradle
Project Object Model : file where depdenencies and goals are configured

======

Uber
    auth module
    driver module
    customer module

JDBC: Java Database Connectivity
integration library to connect to RDBMS.

Java provides interfaces; implementation classes are provided by database vendors

Oracle / MySQL / MS-SQL / Postgres

Steps:
    1) Establish a connection to database

    Connection con = DriverManager.getConnection(URL, USER, PWD);
    getConnection is factory method

    2) SEND SQL statements
    2.1) Statement
        use this if SQL is same for every request
        "select * from products"

    2.2) PreparedStatement
     use this if SQL takes IN parameter

     "select * from accouts where accountID = ?"

     "insert into products values (?, ?, ?)"

    2.3) CallableStatement
        to invoke stored procedures of database
        call SelectAllCustomers('BLORE', 5600001);

        ```
        CREATE PROCEDURE SelectAllCustomers @City nvarchar(30), @PostalCode nvarchar(10)
            AS
            SELECT * FROM Customers WHERE City = @City AND PostalCode = @PostalCode
        GO;
```
    3) Statement / PreparedStatement / CallableStatement returns
        3.1) int : for UPDATE / INSERT and DELETE statements ==> number of records effected
        3.2) ResultSet for SELECT statement
        ResultSet is a cursor to fetched records
        boolean next();

        rs.getString("CustomerName")
        rs.getString(1);
        
    4) close the resources --> done in finally block

        try {

        } catch(Exception ex) {

        } finally {
            con.close();
        }

======

```

```

Day 3:

JDBC

```
% docker exec -it local-mysql bash
# mysql -u root -p
mysql> create database JAVA_SPRING;
mysql> use JAVA_SPRING;

mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double);

mysql> insert into products values (0, 'iPhone 15', 89000.00);


mysql> insert into products values (0, 'Samsung OLED', 256000.00);

mysql> select * from products;
+----+--------------+--------+
| id | name         | price  |
+----+--------------+--------+
|  1 | iPhone 15    |  89000 |
|  2 | Samsung OLED | 256000 |
+----+--------------+--------+

```

HTTP Methods: GET , POST , PUT , DELETE ,,

```
public class RegisterServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        ...
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        ...
    }
    public void doPut(HttpServletRequest req, HttpServletResponse res) {
        ...
    }
    public void doDelete(HttpServletRequest req, HttpServletResponse res) {
        ...
    }
}

Deployment Descriptor --> web.xml
<!-- based on this Servlet engine instantiates -->
<servlet>
    <servlet-name>registerservlet</servlet-name>
    <servlet-class>pkg.RegisterServlet</servlet-class>
</servlet>

<!-- mapping -->
<servlet-mapping>
    <servlet-name>registerservlet</servlet-name>
    <url-pattern>/regiseter</url-pattern>
</servlet-mapping>

OR use Annoation
 @WebServlet("/register")
 public class RegisterServlet extends HttpServlet {


 @WebServlet("/login")
 public class LoginServlet extends HttpServlet {
```

Servlet engines:
* tomcat
* jetty
* netty

mvn compile
mvn package

packaging: default is jar ==> java archive [zip]
war --> web archive
```
    application
        |
        WEB-INF
            pkg
                |
                ProductServlet.class
                Product.class
            web.xml
        index.html
        styles.css
```

mvn jetty:run
internally it executes
1) mvn compile
2) mvn package

http://localhost:8080/products

http://localhost:8080/ ==> index.jsp

mvn jetty:run -Djetty.http.port=9999

==============================================

Spring Framework
lightweight container to manage life-cycle of beans and wiring depenencies
Bean: objects which are managed by Spring container

Inversion Of Control container for DI

Think Spring as service provider

Metadata can be in the form of XML or annotation:

```
public interface ProductDao {
    void addProduct(Product p) throws PersistenceException;
    List<Product> getProducts();
}

public class ProductDaoJdbcImpl implements ProductDao {
    ...
}

public class ProductDaoMongoDbImpl implements ProductDao {
    ...
}

public class AppService {
    private ProductDao productDao;

    public void setProductDao(ProductDao dao) {
        this.productDao = dao
    }

    public void insert(Product p) {
        productDao.addProduct(p);
    }
}
beans.xml
<bean id="jdbc" class="pkg.ProductDaoJdbcImpl" />
<bean id="mongo" class="pkg.ProductDaoMongoDbImpl" />
<bean id="service" class="pkg.AppService">
        <property name="productDao" ref="jdbc"/>
</bean>

service.setProductDao(jdbc);

Ready to use

```
To create a Spring Container:
ApplicationContext ctx = new ClasspathXmlConfiguration("beans.xml");

====

Annotations as metadata:
* Spring creates beans of classes which has any of the below annoation at class-level
1) @Component
2) @Repository
3) @Service
4) @Configuration
5) @Controller
6) @RestController
7) @ControllerAdvice

https://github.com/spring-projects/spring-framework/blob/main/spring-jdbc/src/main/resources/org/springframework/jdbc/support/sql-error-codes.xml

```
public interface ProductDao {
    void addProduct(Product p) throws PersistenceException;
    List<Product> getProducts();
}

@Repository
public class ProductDaoJdbcImpl implements ProductDao {
    ...
}



@Service
public class AppService {
    @Autowired
    private ProductDao productDao;

    public void insert(Product p) {
        productDao.addProduct(p);
    }
}

ApplicationContext ctx = new AnnotationConfigApplicationContext();
ctx.scan("com.adobe.prj");
ctx.refresh();


AppService service = ctx.getBean("appService", AppService.class);


```

Spring uses below libraries for byte code instrumentation:
* byte buddy
* javaassist
* CGLib

Spring Boot Framework is a framework on top of Spring Framework.
Spring boot 2.x is built on top of Spring Framework 5.x
Spring boot 3.x is built on top of Spring Framework 6.x [needs JDK 17+]

Spring Boot Framework  is a highly opinated framework, lots of configurations are out of the box.
Simplifies development.

Example:
* if we are building web application --> Tomcat embedded server is configured - ready to use
* If we are connecting to database --> Connection pool is configured out of the box
* If we are using ORM --> Hibernate as JPA Vendor is configured out of the box

@SpringBootApplication is 3 in one
* @Configuration
* @ComponentScan
* @EnableAutoConfiguration -> opinated code generation 

SpringApplication.run(SpringdemoApplication.class, args); is similar to 
ApplicationContext ctx = new AnnotationConfigApplicationContext();

Field employeeDao in com.adobe.prj.springdemo.service.AppService required a single bean, but 2 were found:
	- employeeDaoFileImpl: 
    - employeeDaoJdbcImpl:

Solution 1:
```
using @Qualifier
@Service
public class AppService {
    @Autowired
    @Qualifier("employeeDaoJdbcImpl")
    private EmployeeDao employeeDao;

```
Solution 2:
usng @Primary
```
@Repository
@Primary
public class EmployeeDaoJdbcImpl  implements  EmployeeDao{


@Repository
public class EmployeeDaoFileImpl implements  EmployeeDao{

@Service
public class AppService {
    @Autowired
    private EmployeeDao employeeDao;

```

Solution 3:
using @ConditionalOnMissingBean

```
@Repository
@ConditionalOnMissingBean(name= "employeeDaoFileImpl")
public class EmployeeDaoJdbcImpl  implements  EmployeeDao{
```

Solution 4: 
using @Profile

```
@Repository
@Profile("prod")
public class EmployeeDaoJdbcImpl  implements  EmployeeDao{

@Repository
@Profile("dev")
public class EmployeeDaoFileImpl implements  EmployeeDao{

```

Modify Configuration: Active Profiles : dev
application.properties
spring.profiles.active=prod

====================================

Factory methods in Spring
* 3rd party classes needs to used in Spring Container

=========================

ORM: Object Relational Mapping

Objects ( java / C++ / Python / JS) --- Tables of database 

ORM generates DML for you, in certain scenarios DDL also

ORM Frameworks:
1) Hibernate --> JBOSS --> RedHat
2) TopLink --> Oracle
3) KODO --> BEA --> Oracle
4) JDO --> Sun --> Oracle
5) OpenJPA --> Apache
6) EclipseLink --> Eclipse 
...

public class ProductDaoJpaImpl implements ProductDao {
    @PersistenceContext 
    EntityManager em;

    @Override
    public void addProduct(Product p) {
        em.persist(p);    
    }
}

```
@Configuration
public class AppConfig {

    @Bean
    public DataSource getDataSource() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/JAVA_SPRING" );
        cpds.setUser("root");
        cpds.setPassword("Welcome123");
        cpds.setMinPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        return  cpds;
    }

    @Bean
    public EntityManagerFactory emf(DataSource ds) {
        LocalContainerEntityManagerFactory emf = new LocalContainerEntityManagerFactory();
        emf.setDataSource(ds);
        emf.setJpaVendor(new HibernateJpaVendor());
        emf.setPackagesToScan("com.adobe.prj.entity");
        return emf;
    }
}


```

Spring Data Jpa Module on top of Spring Core Module simplies using JPA/ORM
as in
Out ouf the box it creates:
1) DataSource
2) creates EntityManagerFActory
3) no need for @Repository classes
4) by default uses HikariCP for database connection pool
5) by default it uses Hibernate as JPAVEndor

Spring Boot Project:
dependecies:
lombok,
mysql,
jpa


https://docs.spring.io/spring-boot/appendix/application-properties/index.html

Day 4

---

Recap: 
Spring Framework and JPA/ORM

Entity are mapped to database table --> @Entity

PersistenceContext is an environment where entities are managed [ sync state with database ]
EntityManager interface is used to perform CRUD operations on entities present in PersistenceContext

EntityManagerFactory helps create PersitenceContext and provide EntityManager;
it uses DataSource [ pool of database connection] + JPAVendor (like hibernate)

========


1) spring.jpa.hibernate.ddl-auto=update
If table exists map entity to table
If not exists create a new table
If required alter table

2) spring.jpa.hibernate.ddl-auto=create
drop table when application terminates
create tables when application starts

3) spring.jpa.hibernate.ddl-auto=validate
entity has to map to existing tables 
can't create or alter

===
Spring Data jpa is going to generate Implementation classes for JpaRepository interface

update products set qty = 100 where 1 = 1;


1 Order has 4 items:
a) to save
orderDao.save(order);
itemDao.save(i1);
itemDao.save(i2);
itemDao.save(i3);
itemDao.save(i4);

2) to delete
orderDao.delete(order);
itemDao.delete(i1);
itemDao.delete(i2);
...

Using Cascade
 @OneToMany(cascade = CascadeType.ALL)
 @JoinColumn(name="order_fk")
 private List<LineItem> items = new ArrayList<>();

1 Order has 4 items:
a) to save
orderDao.save(order); // cascade takes care of persiting items also

b) to delete
orderDao.delete(order); // cascade -- deletes items of given order

=======

fetching by default is LAZY

orderDao.findById(1);
select * from orders where oid = 1;
items are not fetched


@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name="order_fk")
private List<LineItem> items = new ArrayList<>();

orderDao.findById(1);
select * from orders where oid = 1;
select * from items where order_fk = 1;

====

note:
1) one To Many is LAZY fetching by default
2) Many to One is EAGER fetching by default

select c.email, c.fname, c.lname, o.order_date, o.total   from orders o inner join  customers c on o.customer_fk = c.email
   
Getting Scalar Values 

* SQL
* JP-QL

======

* OneToMany
* ManyToOne
* OneToOne
* ManyToMany

```
@Entity 
public class Employee {
    int empid;
    name
}

@Entity
public class Laptop {
    String serialNo;
    String storage;
    String screen;

    @OneToOne
    @JoinColumn(name="emp_fk")
    Employee employee;
}


employees
empid  | name


laptops
serail_no | storage | screen | emp_fk
```

Employee Project:
```
emp_id | name | hire_date 


project_id | name | client | start_date | end_date

emp_project

id | emp_id | project_id | role      | start_date | end_date
1    12          p1         JR.ENG       
2    14          p2
3    12          p3
4    34          p2

    1                   *                   1
Employeee  -----> EmployeeProject <------- Project

```

EmployeeProject as aggregate

spring.datasource.url=jdbc:mysql://localhost:3306/EMP_PROJECT?createDatabaseIfNotExist=true

```
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class Example {
   public static void main(String[] args) {
	//default time zone
	ZoneId defaultZoneId = ZoneId.systemDefault();
		
	//creating the instance of LocalDate using the day, month, year info
        LocalDate localDate = LocalDate.of(2016, 8, 19);
        
        //local date + atStartOfDay() + default time zone + toInstant() = Date
        Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
        
        //Displaying LocalDate and Date
        System.out.println("LocalDate is: " + localDate);
        System.out.println("Date is: " + date);
   }
}
```
Rendering ==> data to Presentation

Building RESTful Web Services.

* Server Side Rendering
Cons:
* Can't have heterogenous clients
* Heavy payload [ server has to send entire page ]


* Client Side Rendering
* Server sends representation of Data in various formats like JSON / XML / CSV

Adv: 
* heterogenous clients
* payload is less

Building RESTful WS or GraphQL 

====

RESTful WS
REpresentational State Transfer

* Resource: files / database / printer
* Representation: state of resource at a given point
* ContentNegotiation: serve representation im various formats based on client requests

Http HEADER
Accept: application / json
Accept: text/xml

By including:
```
 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
We get:
1) Spring MVC Module
ModelViewController
Model --> business data and logic
Controller --> application flow
View --> Presentation [ not required for RESTFul]

2) DispatcherServlet: intercepts all HTTP requests from client
3) HandlerMapping: mapping URLs to @Controller or @RestController

```
    @RestController
    @RequestMapping("/api/products")
    public class ProductController {

        @GetMapping
        List<Product> getProducts() {
            ...
        }

        @PostMapping
        String addProduct(@RequestBody Product p) {
            ..
        }
    }

```

POST
http://localhost:8080/api/products
Content-type: application/json

{
    "name": "A",
    "price" : 3434,
    "quantity": 100
}


ContentNegotiationHandlers

Jackson java <---> json
Alternate: jettison, GSON, Moxy

===========

Day 5

Recap:

PaRT 1: JPA
* OneToMany
* ManyToOne
* JoinColumn --> FK
* OneToOne

DIRTY CHECKING:
within a Transactional boundary if an entity state changes, ORM's will automatically flush the new state to database by issuing UPDATE SQL statement

@Transactional --> Atomic 
Cascade : PERSIST, MERGE, ALL

Spring Data JPA:
CrudRepository:
* JpaRepository
* MongoRepository

with this we just create interface extends JpaRepositry / MongoRepository
Implementation classes [@Respoitory] are generated by Spring Data Jpa, with methods like

findAll() findById() , save, delete, ...

We can write custom methods in interface:
1) By using JPA Projections
findByFieldName() 
findByFieldNameGreaterThan(arg)
findByFieldNameLike(arg)
findByFieldNameBetween(arg1, arg2)
...

2) @Query

2.1) using JP-QL
@Query("from Product where price >= :l and price <= :h")
List<Product> getByRange(@Param("l") double low, @Param("h") double high);

2.2) using SQL
@Query(value = "select * from products where price >= :l and price <= :h", nativeQuery=true)
List<Product> getByRange(@Param("l") double low, @Param("h") double high);

2.3) required especially when we need scalar values, joins

============

Part 2: 

Spring MVC Module
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

This provides:
a) Embedded Tomcat server with Servlet engine/container
b) DispatcherServlet whose URL-pattern is "*"
c) HandlerMapping: contains data in key/value pair which maps URL to @Controller or @RestController
d) Jackson: library for ContentNegotiationHandler to convert Java <---> JSON

URL identifies a Resource:

CRUD operations we use HTTP Methods:
GET --> READ
POST --> CREATE
PUT / PATCH --> UPDATE
DELETE --> DELETE

Examples:

1) GET http://localhost:8080/api/products 
should get  all products

2) GET http://localhost:8080/api/products/3

Path Parameter / has to be used to get resource by ID [ generally a single resource]
get product whose id is 3

GET http://spotify.com/banu@gmail.com/playlist
get playlist of a singleuser banu@gmail.com


3) GET http://localhost:8080/api/products?page=1&size=20
 GET http://localhost:8080/api/products?low=500&high=20000

Query Parameters [?] should be used to get sub-set

---

4)  POST http://localhost:8080/api/products
payload --> a new resource to be added to products resource

5) DELETE  GET http://localhost:8080/api/products/2
delete a product whose id is 2
Avoid this as RESTful Endpoint;

6) PUT GET http://localhost:8080/api/products/2
payload --> a new resource data to be update in products resource identified by id -- 2

POST and PUT needs payload


Guiding Principles of REST:
1) Uniform interface
2) Client-server
3) Stateless: server should not keep any conversational state of client
4) Cacheable

https://martinfowler.com/articles/richardsonMaturityModel.html

Status Codes:
200 : OK
201 : CREATED
400 : BAD REQUEST
401: UNAUTHORIZED
404: RESOURCE NOT FOUND
500: INTERNAL SERVER ERROR
300 series: REDIRECTION SERIES

======

 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="order_fk")
    private List<LineItem> items = new ArrayList<>();

<<By Default>>
spring.jpa.open-in-view=true

Connection is kept alive until response is not commited


spring.jpa.open-in-view=false

Connection is lost once Call is done to database
select * from orders;

Client while getting items --> lazy intialization

======
