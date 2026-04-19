# ASSIGNMENT-2
## Course: Web Programming
## Theme: AniVerseX - Anime Recommendations and Reviews

**Student Name:** ____________________  
**Register Number:** ____________________  
**Department / Class / Section:** ____________________  
**Date:** ____________________

---

## INDEX
1. Question 1: Spring Boot CRUD + XML DTD + XPath + XQuery + XML Schema + XML Parser
2. Question 2: XML + Java + JSP
3. Question 3: JSP + JDBC + Spring Boot
4. Overall Result

---

## FILE STRUCTURE (IMPORTANT FILES ONLY)
```text
assignment-2/
├── 01-springboot-crud/
│   ├── pom.xml
│   ├── src/main/java/com/aniversex/
│   │   ├── AniVerseXApplication.java
│   │   ├── controller/AnimeController.java
│   │   ├── model/Anime.java
│   │   ├── repository/AnimeRepository.java
│   │   └── service/AnimeService.java
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   ├── schema.sql
│   │   └── data.sql
│   └── src/main/webapp/WEB-INF/jsp/
│       ├── index.jsp
│       ├── anime-list.jsp
│       └── anime-form.jsp
│
├── 02-xml-dtd/
│   ├── anime.xml
│   ├── anime.dtd
│   └── README.md
│
├── 03-xpath/
│   ├── anime.xml
│   ├── xpath-queries.txt
│   └── README.md
│
├── 04-xquery/
│   ├── anime.xml
│   ├── xquery-queries.txt
│   └── README.md
│
├── 05-xml-schema/
│   ├── anime.xml
│   ├── anime.xsd
│   └── README.md
│
├── 06-xml-parser/
│   ├── anime.xml
│   ├── src/AniVerseXmlDomParser.java
│   └── README.md
│
├── 07-xml-java-jsp/
│   ├── anime.xml
│   ├── src/com/aniversex/xmljsp/AnimeXmlReaderServlet.java
│   ├── index.jsp
│   ├── anime-list.jsp
│   ├── style.css
│   └── WEB-INF/web.xml
│
└── 08-jsp-jdbc-springboot/
    ├── pom.xml
    ├── src/main/java/com/aniversex/jspjdbc/
    │   ├── AniVerseXJspJdbcApplication.java
    │   ├── controller/AnimeController.java
    │   ├── dao/AnimeDao.java
    │   └── model/Anime.java
    ├── src/main/resources/
    │   ├── application.properties
    │   ├── schema.sql
    │   └── data.sql
    └── src/main/webapp/WEB-INF/jsp/
        ├── index.jsp
        ├── anime-list.jsp
        └── anime-form.jsp
```

---

## QUESTION 1
## Spring Boot CRUD + XML DTD + XPath + XQuery + XML Schema + XML Parser

### Aim
To implement important Web Programming concepts using one common theme: AniVerseX.

### Tools Required
Java 17, Spring Boot, Maven, MySQL, VS Code/IntelliJ, XML validator, BaseX/online XPath-XQuery tool.

### Concept (Short)
- Spring Boot CRUD: create/read/update/delete anime details.
- XML + DTD: structure validation.
- XPath: data extraction from XML.
- XQuery: advanced XML query.
- XML Schema: datatype and range validation.
- XML Parser (DOM): Java code to read and print XML records.

### Algorithm / Steps
1. Build Spring Boot CRUD app with JSP and MySQL.  
2. Create XML and DTD; validate structure.  
3. Run XPath and XQuery queries on anime XML.  
4. Create XSD and validate field datatypes/rules.  
5. Parse XML using Java DOM parser and print output.

### Important Source Code

#### 1) Spring Boot CRUD (key files)

**Anime Entity**
```java
@Entity
@Table(name = "anime")
public class Anime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private Integer episodes;
    private Double rating;
    private String synopsis;
}
```

**Anime Controller**
```java
@GetMapping("/anime")
public String list(Model model) {
    model.addAttribute("animeList", animeService.getAllAnime());
    return "anime-list";
}

@PostMapping("/anime/save")
public String save(@ModelAttribute Anime anime) {
    animeService.saveAnime(anime);
    return "redirect:/anime";
}
```

**application.properties (core)**
```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://localhost:3306/aniversex_db
spring.datasource.username=root
spring.datasource.password=root
```

**schema.sql (anime table)**
```sql
CREATE TABLE anime (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    episodes INT NOT NULL,
    rating DOUBLE NOT NULL,
    synopsis VARCHAR(1000)
);
```

#### 2) XML + DTD

**anime.xml**
```xml
<!DOCTYPE animeCollection SYSTEM "anime.dtd">
<animeCollection>
  <anime>
    <animeId>A001</animeId>
    <title>Naruto</title>
    <genre>Action</genre>
    <episodes>220</episodes>
    <rating>8.3</rating>
    <shortReview>A classic ninja journey with strong character development.</shortReview>
    <recommendationType>Beginner Friendly</recommendationType>
  </anime>
</animeCollection>
```

**anime.dtd**
```dtd
<!ELEMENT animeCollection (anime+)>
<!ELEMENT anime (animeId, title, genre, episodes, rating, shortReview, recommendationType)>
<!ELEMENT animeId (#PCDATA)>
<!ELEMENT title (#PCDATA)>
<!ELEMENT genre (#PCDATA)>
<!ELEMENT episodes (#PCDATA)>
<!ELEMENT rating (#PCDATA)>
<!ELEMENT shortReview (#PCDATA)>
<!ELEMENT recommendationType (#PCDATA)>
```

#### 3) XPath (required queries)
```text
/animeCollection/anime/title
/animeCollection/anime[number(rating) > 8.5]/title
/animeCollection/anime[number(episodes) < 100]/title
/animeCollection/anime[genre='Action']/title
count(/animeCollection/anime)
/animeCollection/anime/*[self::title or self::shortReview]
/animeCollection/anime[not(rating < /animeCollection/anime/rating)]/animeId
```

#### 4) XQuery (required programs)
```xquery
for $a in doc("anime.xml")/animeCollection/anime
return $a/title

for $a in doc("anime.xml")/animeCollection/anime
where xs:decimal($a/rating) > 8.5
return $a/title

count(doc("anime.xml")/animeCollection/anime)

let $maxRating := max(doc("anime.xml")/animeCollection/anime/rating/xs:decimal(.))
for $a in doc("anime.xml")/animeCollection/anime
where xs:decimal($a/rating) = $maxRating
return $a/animeId
```

#### 5) XML Schema (XSD validation rules)
```xml
<xs:element name="episodes" type="xs:positiveInteger"/>
<xs:element name="rating">
  <xs:simpleType>
    <xs:restriction base="xs:decimal">
      <xs:minInclusive value="0"/>
      <xs:maxInclusive value="10"/>
    </xs:restriction>
  </xs:simpleType>
</xs:element>
```

#### 6) XML Parser (DOM)
```java
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document document = builder.parse(new File("anime.xml"));
NodeList animeList = document.getElementsByTagName("anime");
```

### File Names Used (Important)
- `01-springboot-crud`: model, controller, service, repository, JSP, SQL, properties
- `02-xml-dtd`: `anime.xml`, `anime.dtd`
- `03-xpath`: `anime.xml`, `xpath-queries.txt`
- `04-xquery`: `anime.xml`, `xquery-queries.txt`
- `05-xml-schema`: `anime.xml`, `anime.xsd`
- `06-xml-parser`: `anime.xml`, `AniVerseXmlDomParser.java`, `sample-output.txt`

### How to Run
1. MySQL: create database `aniversex_db`.  
2. Spring Boot CRUD: `mvn spring-boot:run`.  
3. XML/DTD/XSD: validate in XML validator/VS Code extension.  
4. XPath/XQuery: run in BaseX or online evaluator.  
5. DOM Parser: compile and run Java parser.

### Expected Output
- CRUD app pages work with database records.
- XML validates with DTD and XSD.
- XPath/XQuery return expected values.
- DOM parser prints all anime records.

### Output Screenshot
**[Paste Output Screenshot Here]**

### Result
All Part-1 technologies were implemented successfully.

---

## QUESTION 2
## XML + Java + JSP

### Aim
To parse `anime.xml` using Java and display the parsed data on JSP page.

### Tools Required
Java 17, Apache Tomcat, VS Code/Eclipse.

### Concept
Servlet reads XML using DOM, stores list in request scope, JSP displays list in table format.

### Algorithm / Steps
1. Place XML in `WEB-INF/data/anime.xml`.
2. Create model class `Anime`.
3. Create servlet `AnimeXmlServlet` to parse XML.
4. Forward list to `anime-list.jsp`.
5. Display all required fields in table.

### Important Source Code

**Servlet parse + forward**
```java
String xmlPath = getServletContext().getRealPath("/WEB-INF/data/anime.xml");
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document document = builder.parse(new File(xmlPath));
NodeList nodeList = document.getElementsByTagName("anime");
request.setAttribute("animeList", animeList);
request.getRequestDispatcher("/anime-list.jsp").forward(request, response);
```

**web.xml mapping**
```xml
<servlet-mapping>
  <servlet-name>AnimeXmlServlet</servlet-name>
  <url-pattern>/anime-list</url-pattern>
</servlet-mapping>
```

**JSP table rendering**
```jsp
<% List<Anime> animeList = (List<Anime>) request.getAttribute("animeList"); %>
<% for (Anime anime : animeList) { %>
<tr>
  <td><%= anime.getAnimeId() %></td>
  <td><%= anime.getTitle() %></td>
  <td><%= anime.getGenre() %></td>
  <td><%= anime.getEpisodes() %></td>
  <td><%= anime.getRating() %></td>
  <td><%= anime.getShortReview() %></td>
  <td><%= anime.getRecommendationType() %></td>
</tr>
<% } %>
```

### File Names Used (Important)
- `WEB-INF/data/anime.xml`
- `src/com/aniversex/xmljsp/model/Anime.java`
- `src/com/aniversex/xmljsp/servlet/AnimeXmlServlet.java`
- `WEB-INF/web.xml`
- `index.jsp`, `anime-list.jsp`, `style.css`

### How to Run
1. Deploy folder in Tomcat `webapps`.
2. Compile Java classes to `WEB-INF/classes`.
3. Start Tomcat and open app URL.

### Expected Output
Anime records from XML are displayed in JSP table.

### Output Screenshot
**[Paste Output Screenshot Here]**

### Result
XML + Java + JSP integration works correctly.

---

## QUESTION 3
## JSP + JDBC + Spring Boot

### Aim
To build final CRUD application using JSP UI, JDBC DAO, Spring Boot architecture, and MySQL.

### Tools Required
Java 17, Spring Boot, Maven, MySQL, VS Code/IntelliJ.

### Concept
- Controller handles routes.
- DAO performs JDBC SQL operations.
- JSP pages provide form/list UI.
- MySQL stores anime records.

### Algorithm / Steps
1. Setup Spring Boot project with JSP + JDBC + MySQL dependencies.
2. Create model `Anime`.
3. Create `AnimeDao` for add/list/edit/delete queries.
4. Create `AnimeController` mappings.
5. Create JSP pages (`index`, `anime-list`, `anime-form`).
6. Configure DB and run with Maven.

### Important Source Code

**DAO methods**
```java
public void addAnime(Anime anime) { /* INSERT */ }
public List<Anime> getAllAnime() { /* SELECT */ }
public Anime getAnimeById(Integer animeId) { /* SELECT BY ID */ }
public void updateAnime(Anime anime) { /* UPDATE */ }
public void deleteAnime(Integer animeId) { /* DELETE */ }
```

**Controller save logic**
```java
@PostMapping("/anime/save")
public String saveAnime(@ModelAttribute Anime anime) {
    if (anime.getAnimeId() == null) animeDao.addAnime(anime);
    else animeDao.updateAnime(anime);
    return "redirect:/anime";
}
```

**application.properties**
```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://localhost:3306/aniversex_db
spring.datasource.username=root
spring.datasource.password=root
spring.sql.init.mode=always
```

**schema.sql**
```sql
CREATE TABLE anime (
    anime_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    episodes INT NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    short_review VARCHAR(500) NOT NULL,
    CHECK (episodes > 0),
    CHECK (rating >= 0 AND rating <= 10)
);
```

### File Names Used (Important)
`pom.xml`, `AniVerseXJspJdbcApplication.java`, `Anime.java`, `AnimeDao.java`, `AnimeController.java`, `application.properties`, `schema.sql`, `data.sql`, `index.jsp`, `anime-list.jsp`, `anime-form.jsp`, `style.css`.

### How to Run
1. Create DB: `CREATE DATABASE aniversex_db;`
2. Update MySQL credentials in `application.properties`.
3. Run command: `mvn spring-boot:run`
4. Open: `http://localhost:8080/`

### Expected Output
Add, View, Edit, Delete operations work through JSP and update MySQL data.

### Output Screenshot
**[Paste Output Screenshot Here]**

### Result
Final JSP + JDBC + Spring Boot module is completed and runnable.

---

## OVERALL RESULT
All three questions were completed successfully in a neat college-level format under the theme **AniVerseX – Anime Recommendations and Reviews**.
