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

1. Add Swagger dependency

# FEATURES:

### **1. Implement Essential CRUD Operations   ->  DONE**

### **2. Add Advanced Features**

#### **Pagination & Sorting (GET)**

#### **Search/Filter Products

### **3. Add Validation**

Ensure data integrity with `@Valid` and DTOs:

#### **ProductRequest DTO

#### **Validated Controller**

### **4. Error Handling**

Create global exception handling:

#### **Custom Exception**

#### **Exception Handler**

### **5. Add Swagger/OpenAPI Documentation**

Document your API for frontend developers:

### **6. Write Unit & Integration Tests**

#### **Unit Test (Service Layer)**

### **7. Deploy Your API**

#### **Dockerize (Add `Dockerfile`)**

### **Next Steps**

1. **Add authentication** (JWT/OAuth2 for secure endpoints).
2. **Set up CI/CD** (GitHub Actions, Jenkins).
3. **Monitor performance** (Prometheus + Grafana).

## UPDATE:

I was getting error while finding and then updating the value so below

steps: first find the data findById from db then use map function and set the data with given Requested Data.

then use orElseThrow(()-> "Product does not exist ")

1. **Optional Handling**:
   * `findById()` returns an `Optional<Product>`
   * The `.map()` operation works on the Optional, not the Product directly
   * You were trying to assign the Optional to a Product variable

## TO DELETE PRODUCT:

Steps:

just run deleteByID(id) function in service.

## Exception Handling

I'll guide you through implementing comprehensive exception handling for your product catalog service. We'll cover:

* Custom exceptions
* Global exception handling
* MongoDB-specific error cases
* Validation exceptions
* Proper HTTP status codes

  Exception : Something went

It has two types:

1. checked ->
2. Unchecked ->

We will make custom exceptions and make a gobal exceptions Handler But why?

why not we can take RuntimeExceptionhandler and write message instead making custom exceptions?

### **Comparison: `RuntimeException` vs. Custom `ProductNotFoundException`**

#### **1. `RuntimeException` Approach**

public Product getProduct(String id) {
return productRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Product not found: " + id));
}


| Aspect                | `RuntimeException`                                    | `ProductNotFoundException`(Custom)                           |
| --------------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
| 🔍 Meaning            | Generic error — can mean*anything*                   | Specific error — clearly indicates product not found        |
| 📘 Readability        | Less readable in logs or responses                    | Clear and descriptive — helps developers and users          |
| 🎯 Control            | Harder to catch and handle specifically               | Can be caught and handled separately in a`@ControllerAdvice` |
| 🧹 Clean Architecture | Not clean — mixes business logic with generic errors | Clean — domain-specific exception handling                  |
| ⚙️ Reusability      | Not reusable or scalable                              | Can reuse in other controllers/services                      |
| 🛑 API Response       | Usually returns 500 Internal Server Error             | Can return 404 Not Found using`@ControllerAdvice`            |
| 📂 Best Practice      | ❌ Avoid using for known business errors              | ✅ Always use for expected domain-level errors               |

Custom Exception Implementation steps:

1. Create custom exception class. ProductNotFoundException and extends to Exception
2. Throw exception in service logic -> .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
3. Handle it in ControllerAdvisor


## What is a DTO (Data Transfer Object)?

A DTO is a plain Java object that carries data between layers (Controller ⇄ Service ⇄ Repository) without exposing the entity directly.
It helps you:

* Hide unnecessary fields
* Prevent circular references
* Format data as required by the client
* Apply validation
