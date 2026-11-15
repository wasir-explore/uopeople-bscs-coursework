# Discussion Forum Unit 1: Databases and the Relational Data Model

**Posted by:** S M Wasir Jayed Rafi
**Course:** CS 2203-01 — Databases 1 (AY2027-T2)

Imagine an e-commerce platform tracking thousands of products, customer profiles,
and sales transactions every hour — the kind of real-world load databases were
built to handle (CBT Nuggets, 2019). How that database is built, and who builds
it, decides whether the platform stays fast, accurate, and trustworthy as it
grows.

## Characteristics of Databases and DBMS

Four characteristics set a managed database apart from scattered spreadsheets, and
each matters for this platform (Watt & Eng, 2014, Chapter 3).

**Control of data redundancy.** Each product or customer is stored once. A
relational model enforces this by putting products in a `Product` table and
letting every order line reference it through a `ProductID` foreign key, so a
price correction never has to repeat across hundreds of order records.

**Enforcement of integrity constraints.** The DBMS rejects data that breaks a
defined rule — a `Price` field that must stay positive, or a `CustomerEmail`
field that must be unique. These domain and entity-integrity rules (Watt & Eng,
2014, Chapter 9) stop bad catalog edits or duplicate accounts from corrupting the
data.

**Program-data independence.** The database is self-describing: its schema lives
in the system catalog, separate from the storefront, warehouse, and billing
applications that use it. Because none of those applications hard-codes the table
structure, the checkout page can be redesigned without touching how `Order` data
is stored (Watt & Eng, 2014, Chapter 3).

**Multiuser concurrency control and security.** When many shoppers check out at
once, concurrency control stops two of them from being sold the last unit of the
same item, and role-based access limits which staff can view full payment
details versus just order status (Watt & Eng, 2014, Chapter 3).

These characteristics map onto concrete tables — `Customer`, `Product`, `Order`,
and `OrderLine` — built on the relational model rather than the older
hierarchical or network models, since keys resolve a many-to-many relationship
more cleanly than rigid parent-child links (Watt & Eng, 2014, Chapter 4).

## Key Job Roles

Building this database calls for several distinct roles (Watt & Eng, 2014,
Chapters 13–14):

- **Database Designer** interviews stakeholders and produces the conceptual
  model — deciding, for example, that `Order` and `Product` need a junction
  table to resolve their many-to-many relationship.
- **Database Administrator (DBA)** owns the live database: authorizing access,
  tuning performance during peak sales events, and managing backup and recovery.
- **Application Programmer/Database Developer** writes the SQL and application
  code that lets the storefront, inventory, and billing systems read and write
  data correctly.
- **Data Analyst**, a "sophisticated user" in database terms, queries the
  finished database to produce sales or churn reports without altering the
  schema.
- **End users** (customer-service agents, warehouse staff) touch the data only
  through front-end forms, never the raw tables.

Each role covers a different risk: the designer prevents a costly redesign, the
DBA prevents downtime, the developer prevents bugs, and the analyst turns data
into decisions.

## Relational Model Development and Challenges

Modelling this platform means turning each entity into a relation:
`Customer(CustomerID, Name, Email)`, `Product(ProductID, Name, Price, StockQty)`,
and `Order(OrderID, CustomerID, OrderDate)`. Because one order holds many
products and one product appears on many orders, that many-to-many relationship
is resolved with a junction table, `OrderLine(OrderID, ProductID, Quantity)`,
where `OrderID` and `ProductID` together form a composite key (Watt & Eng, 2014,
Chapter 7).

Two constraints keep these relations trustworthy. Entity integrity requires every
table to have a non-null primary key, so an order can never exist without an
`OrderID`. Referential integrity requires that `CustomerID` in `Order` and
`ProductID` in `OrderLine` always match a real row in `Customer` or `Product`,
preventing orphan records that point to a customer or product that no longer
exists (Watt & Eng, 2014, Chapter 9).

The main challenge appears when a product is discontinued but still referenced by
past orders: cascading the delete would erase order history, so the foreign-key
rule should restrict the delete, or set the reference to null, rather than
cascade it. A second challenge is normalization versus performance — a fully
normalized schema avoids redundancy but needs several joins across `Product`,
`OrderLine`, and `Order` to render one order-history page, which grows costly as
transaction volume reaches millions of rows.

## Discussion Question

If restricting deletes is the right way to preserve order history, but the
storefront still needs to hide discontinued products from search results, how
would you adjust the `Product` table or its relationships to satisfy both
requirements without duplicating data?

## References

CBT Nuggets. (2019, July 18). *Databases in the real world* [Video]. YouTube.
https://www.youtube.com/watch?v=whmYCRfB4lQ

Watt, A., & Eng, N. (2014). *Database design* (2nd ed.). BCcampus, BC Open
Textbook Project. https://opentextbc.ca/dbdesign01/
