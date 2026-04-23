# AniVerseX - Anime Recommendations and Reviews (College Lab Mini Project)

This is a simple Spring Boot + JSP mini project for college lab submission.

## 1) Folder Structure (Where each file should be placed)

```text
AniVerseX-CollegeLab/
|-- pom.xml
|-- .gitignore
|-- src/
    |-- main/
        |-- java/
        |   |-- com/aniversex/
        |       |-- AniVerseXApplication.java
        |       |-- controller/
        |       |   |-- HomeController.java
        |       |   |-- AnimeController.java
        |       |   |-- ReviewController.java
        |       |-- model/
        |       |   |-- Anime.java
        |       |   |-- Review.java
        |       |-- repository/
        |       |   |-- AnimeRepository.java
        |       |   |-- ReviewRepository.java
        |       |-- service/
        |           |-- AnimeService.java
        |           |-- ReviewService.java
        |-- resources/
        |   |-- application.properties
        |   |-- schema.sql
        |   |-- data.sql
        |   |-- static/
        |       |-- css/style.css
        |       |-- xml/anime-data.xml
        |-- webapp/
            |-- WEB-INF/
                |-- jsp/
                    |-- index.jsp
                    |-- about.jsp
                    |-- anime-list.jsp
                    |-- anime-form.jsp
                    |-- review-list.jsp
                    |-- review-form.jsp
```

## 2) Database (MySQL)

Create DB once:

```sql
CREATE DATABASE aniversex_db;
```

Table creation SQL is already present in:
- `src/main/resources/schema.sql`

Sample records are in:
- `src/main/resources/data.sql`

## 3) How to Run

1. Install Java 17 and Maven.
2. Install MySQL and create DB `aniversex_db`.
3. Open `src/main/resources/application.properties` and set MySQL username/password.
4. From project root, run:

```bash
mvn spring-boot:run
```

5. Open browser:

```text
http://localhost:8080/
```

## 4) Features Included

- Anime CRUD (Add, View, Edit, Delete)
- Review CRUD (Add, View, Edit, Delete)
- Anime-themed UI with CSS
- Sample XML anime catalog file
- Simple MVC + JPA beginner-friendly code

## 5) Notes

- Code is intentionally simple and readable for lab submission.
- Comments are added in key places for understanding.
