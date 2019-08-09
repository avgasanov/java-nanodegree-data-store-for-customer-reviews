# Java Developer Nanodegree - Data Store for Customer Reviews

## Project Specification for Customer Reviews (Midterm and Final)

### Code Quality

- All code is functional (i.e. no errors are thrown by the code). Warnings are okay, as long as they are not a result of poor coding practices.
- The project uses functions and loops where possible to reduce repetitive code. Comments are used as needed to document code functionality.

### Relational Database Management System (RDBMS)

- The project contains the necessary SQL scripts to create review, comment and product tables.
- The project contains the SQL to create foreign key constraints on review & comment tables. Review is related to Product. Comment is related to Review.
- The project contains the following properties to properly connect to a relational database in Spring.
Spring.datasource.url, spring.datasource.username, spring.datasource.password

### JPA

- The project contains the JPA entities for Product, Review & Comment.
- The project contains JPA entities which use at least one of the available id generation strategies in JPA.
- The project contains JPA entities which are connected using JPA collections.

### Spring Data JPA

- The project contains Spring Data JPA repositories for Product, Review & Comment entities.
- The project contains Spring Data JPA repositories with methods following the query keywords and return types.
- The project contains the correct methods wired in at the provided controllers in the starter code.
- The project has tests for all the methods in the Spring Data JPA repositories.
- The project has tests for Spring Data JPA repositories that run against a H2 database.

## Additional requirements for Final Project:

### MongoDB

- The project contains a document for review nested with the comments inside.
- The project contains Spring Data Mongo repositories with methods following the query keywords and return types.
- The project contains the correct methods wired in at the provided controllers in the starter code.
- The project has tests for all the methods in the Spring Data MongoDB repositories.
- The project has tests for Spring Data MongoDB repositories that run against an embedded mongo database.

Midterm branch for Midterm project, main branch for Final project

