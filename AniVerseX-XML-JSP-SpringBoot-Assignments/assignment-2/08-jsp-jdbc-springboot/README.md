# Experiment 08: JSP + JDBC + Spring Boot
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim
To build a final CRUD web application using JSP UI, JDBC database operations, Spring Boot structure, and MySQL.

## 2) Features Implemented
- Add anime
- View anime list
- Edit anime
- Delete anime

## 3) Fields Used
- animeId
- title
- genre
- episodes
- rating
- shortReview

## 4) File Structure
```text
assignment-2/
└── 08-jsp-jdbc-springboot/
    ├── pom.xml
    ├── README.md
    └── src/main/
        ├── java/com/aniversex/jspjdbc/
        │   ├── AniVerseXJspJdbcApplication.java
        │   ├── controller/AnimeController.java
        │   ├── dao/AnimeDao.java
        │   └── model/Anime.java
        ├── resources/
        │   ├── application.properties
        │   ├── schema.sql
        │   ├── data.sql
        │   └── static/css/style.css
        └── webapp/WEB-INF/jsp/
            ├── index.jsp
            ├── anime-list.jsp
            └── anime-form.jsp
```

## 5) Database Setup (MySQL)
Run once:
```sql
CREATE DATABASE aniversex_db;
```

Table and sample data files are already included:
- `src/main/resources/schema.sql`
- `src/main/resources/data.sql`

## 6) How to Run (VS Code / Local System)
### Prerequisites
- Java 17+
- Maven
- MySQL running

### Steps
1. Open folder `assignment-2/08-jsp-jdbc-springboot`.
2. Update DB username/password in `application.properties`.
3. Open terminal in this folder.
4. Run:
```bash
mvn spring-boot:run
```
5. Open browser:
```text
http://localhost:8080/
```

## 7) Expected Output
- Home page with button to open anime CRUD.
- Anime list table showing all records.
- Add/Edit form for anime details.
- Delete action removes record from MySQL.

## 8) Result
Successfully built a college-level final assignment using JSP + JDBC + Spring Boot + MySQL with full CRUD operations for AniVerseX anime records.
