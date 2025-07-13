# Product_Catalog

It will be Product service for E-commerce project

We migrated the Product Catalog Service database from **MySQL** (relational) to **MongoDB** (document-based NoSQL) to improve flexibility, performance, and scalability.

### **2. Why We Migrated (Motivation)**

* **Flexible Schema**: Products can have different specifications, attributes, or images — MongoDB handles this easily without altering table structures.
* **Faster Development**: No need to manage complex table joins or schema migrations.
* **Better for Nested Data**: ProductImages and ProductAttributes can be **embedded** inside a product document — no foreign key handling.
* **Improved Read Performance**: MongoDB reads entire product documents in one query (no joins), which is great for catalog-heavy applications.
* **Horizontal Scalability**: MongoDB supports sharding and scaling out easily compared to MySQL.

### **3. Key Differences**


| Feature            | MySQL (SQL)                    | MongoDB (NoSQL)                  |
| ------------------ | ------------------------------ | -------------------------------- |
| Schema             | Fixed (tables, columns)        | Flexible (JSON-like documents)   |
| Relationships      | Foreign keys, joins            | Embedding, references (`@DBRef`) |
| Read operations    | Multiple joins for nested data | Single document fetch            |
| Schema migration   | Requires ALTER TABLE           | No need — structure can evolve  |
| Product Attributes | Separate table (1:M)           | Embedded in Product document     |
| Product Images     | Separate table (1:M)           | Embedded in Product document     |

### **Benefits We Observed**

* Reduced backend code and fewer SQL queries
* Easier evolution of product structure (adding new attributes/images)
* Faster catalog loading due to single document reads
* Clean mapping between frontend JSON and backend objects

### **When MongoDB is Especially Useful**

* Product Catalogs with varying specs
* Inventory systems where each product has custom fields
* Analytics dashboards with fast read requirements


### Steps I Followed:

Step 1: Update `pom.xml` – Dependencies

Step 2: Configure `application.properties`


## Step 3: Modify Entity Classes

### Changes made:

* Replaced `@Entity` with `@Document` (MongoDB)
* Replaced `@GeneratedValue` with `@Id` (MongoDB uses ObjectId)
* Embedded related sub-objects directly into `Product`
