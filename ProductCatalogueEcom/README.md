Source:

https://www.linkedin.com/pulse/ecommerce-microservices-architecture-guide-startups-businesses-w03we/

Question: Why category is null in my json response?


**@DBRef Annotation**: In your `Product` class, the `category` field is annotated with `@DBRef`, which means it expects a reference to a `Category` document in MongoDB. Since you're not providing any category reference in the JSON, it remains `null`.


Question2:

Layers:

Controller -> Service -> Repository




| Layer      | Responsibility                                     |
| ---------- | -------------------------------------------------- |
| Controller | Handle API requests (input/output)                 |
| Service    | Business logic, orchestration                      |
| Repository | Talk to MongoDB database (`MongoRepository`)<br /> |



| Layer          | Type to Use         | Why Use It?                                              |
| -------------- | ------------------- | -------------------------------------------------------- |
| **Controller** | `class`only         | Controllers are not extended or reused — keep simple    |
| **Service**    | `interface + class` | Makes business logic testable, replaceable, and mockable |
| **Repository** | `interface`only     | Spring Data auto-generates implementation at runtime     |


src/main/java/com/scaler/productcatalogueecom/

├── controllers/
│   └── ProductController.java

├── services/
│   ├── ProductService.java         ← Interface
│   └── ProductServiceImpl.java     ← Class implementing interface

├── models/
│   └── Product.java

├── repos/
│   └── ProductRepository.java      ← Interface only


SWAGGER IMPLEMENTATION:
