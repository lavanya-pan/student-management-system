# Student Management System

A REST API built with Spring Boot, MySQL and Redis caching.

## Features
- Add student
- Get all students
- Get student by ID
- Update student
- Delete student
- Redis caching for faster data retrieval

## Technologies
- Java
- Spring Boot
- MySQL
- Spring Data JPA
- Redis (Caching)

## How Caching Works
- First request fetches data from MySQL database
- Subsequent requests fetch data from Redis cache
- Cache is cleared automatically when data is updated or deleted
