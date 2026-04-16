# AniVerseX-XML-JSP-SpringBoot-Assignments

This repository contains 3 college-level assignments for the mini project **AniVerseX - Anime Recommendations and Reviews**.

## Folder Structure

```text
AniVerseX-XML-JSP-SpringBoot-Assignments/
|-- xml-assignment/
|   |-- anime-catalog.xml
|   |-- xml-viewer.html
|
|-- jsp-assignment/
|   |-- index.jsp
|   |-- anime-list.jsp
|   |-- review-form.jsp
|   |-- style.css
|   |-- WEB-INF/
|       |-- web.xml
|
|-- springboot-assignment/
|   |-- pom.xml
|   |-- .gitignore
|   |-- README.md
|   |-- src/main/java/com/aniversex/...
|   |-- src/main/resources/...
|   |-- src/main/webapp/WEB-INF/jsp/...
```

---

## 1) XML Assignment

### Files
- `xml-assignment/anime-catalog.xml`
- `xml-assignment/xml-viewer.html`

### Run
Open `xml-viewer.html` in browser.

---

## 2) JSP Assignment

### Files
- `jsp-assignment/index.jsp`
- `jsp-assignment/anime-list.jsp`
- `jsp-assignment/review-form.jsp`
- `jsp-assignment/style.css`
- `jsp-assignment/WEB-INF/web.xml`

### Run
1. Place `jsp-assignment` inside Apache Tomcat `webapps` folder as a web project.
2. Start Tomcat.
3. Open in browser:
   - `http://localhost:8080/jsp-assignment/`

---

## 3) Spring Boot MVC/CRUD Assignment

### Database (MySQL)
Run once:

```sql
CREATE DATABASE aniversex_db;
```

Table creation and sample data files are included in:
- `springboot-assignment/src/main/resources/schema.sql`
- `springboot-assignment/src/main/resources/data.sql`

### Run
1. Install Java 17 + Maven + MySQL.
2. Update DB username/password in:
   - `springboot-assignment/src/main/resources/application.properties`
3. Open terminal in `springboot-assignment` and run:

```bash
mvn spring-boot:run
```

4. Open:

```text
http://localhost:8080/
```
