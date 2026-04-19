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

---

## QUESTION 1
## Spring Boot CRUD + XML DTD + XPath + XQuery + XML Schema + XML Parser

### Aim
To implement core Web Programming concepts under a single anime project theme.

### Tools Required
Java 17, Spring Boot, Maven, MySQL, VS Code/IntelliJ, XML tools.

### Important Concept (Short)
- Spring Boot CRUD: add/list/edit/delete anime records.
- DTD: basic XML structure rules.
- XPath: XML node selection.
- XQuery: advanced XML querying.
- XSD: XML datatype validation.
- DOM Parser: Java-based XML parsing.

### Important Source Code (Key snippets)

#### A) Spring Boot CRUD
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

```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://localhost:3306/aniversex_db
spring.datasource.username=root
spring.datasource.password=root
```

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

#### B) XML + DTD
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

#### C) XPath
```text
/animeCollection/anime/title
/animeCollection/anime[number(rating) > 8.5]/title
/animeCollection/anime[number(episodes) < 100]/title
/animeCollection/anime[genre='Action']/title
count(/animeCollection/anime)
/animeCollection/anime/*[self::title or self::shortReview]
/animeCollection/anime[not(rating < /animeCollection/anime/rating)]/animeId
```

#### D) XQuery
```xquery
for $a in doc("anime.xml")/animeCollection/anime
return $a/title

for $a in doc("anime.xml")/animeCollection/anime
where xs:decimal($a/rating) > 8.5
return $a/title

count(doc("anime.xml")/animeCollection/anime)
```

#### E) XML Schema (XSD)
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

#### F) XML Parser (DOM)
```java
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse(new File("anime.xml"));
NodeList list = doc.getElementsByTagName("anime");
```

### Important File Names Used
`01-springboot-crud` key files, `02-xml-dtd/anime.xml`, `02-xml-dtd/anime.dtd`, `03-xpath/xpath-queries.txt`, `04-xquery/xquery-queries.txt`, `05-xml-schema/anime.xsd`, `06-xml-parser/src/AniVerseXmlDomParser.java`.

### How to Run
1. Start MySQL and create `aniversex_db`.
2. Run Spring Boot CRUD with `mvn spring-boot:run`.
3. Validate XML with DTD/XSD in XML validator.
4. Run XPath/XQuery in evaluator (BaseX/online).
5. Compile parser:
   - `javac -d out src/AniVerseXmlDomParser.java`
   - `java -cp out AniVerseXmlDomParser anime.xml`

### Expected Output
All modules execute correctly: CRUD pages work, XML validation passes, queries return correct results, parser prints all records.

### Output Screenshot
**[Paste Output Screenshot Here]**

### Result
Question 1 modules are implemented successfully.

---

## QUESTION 2
## XML + Java + JSP

### Aim
To read XML data using Java and display it in JSP table.

### Tools Required
Java 17, Apache Tomcat, JSP/Servlet API, VS Code.

### Important Concept
- XML stores anime data.
- Java Servlet reads/parses XML.
- JSP displays parsed data as table.

### Important Source Code (Key snippets)

```java
String xmlPath = getServletContext().getRealPath("/WEB-INF/data/anime.xml");
DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document document = builder.parse(new File(xmlPath));
NodeList nodeList = document.getElementsByTagName("anime");
request.setAttribute("animeList", animeList);
request.getRequestDispatcher("/anime-list.jsp").forward(request, response);
```

```xml
<servlet-mapping>
  <servlet-name>AnimeXmlServlet</servlet-name>
  <url-pattern>/anime-list</url-pattern>
</servlet-mapping>
```

```jsp
<% List<Anime> animeList = (List<Anime>) request.getAttribute("animeList"); %>
<table>
  <tr><th>Anime ID</th><th>Title</th><th>Genre</th><th>Episodes</th><th>Rating</th><th>Short Review</th><th>Recommendation Type</th></tr>
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
</table>
```

### Important File Names Used
`WEB-INF/data/anime.xml`, `src/com/aniversex/xmljsp/model/Anime.java`, `src/com/aniversex/xmljsp/servlet/AnimeXmlServlet.java`, `WEB-INF/web.xml`, `index.jsp`, `anime-list.jsp`, `style.css`.

### How to Run
1. Deploy folder to Tomcat `webapps`.
2. Compile Java source to `WEB-INF/classes`.
3. Start Tomcat.
4. Open: `http://localhost:8080/07-xml-java-jsp/`.

### Expected Output
Anime records from XML appear in JSP table.

### Output Screenshot
**[Paste Output Screenshot Here]**

### Result
Question 2 completed successfully with XML + Java + JSP integration.

---

## QUESTION 3
## JSP + JDBC + Spring Boot

### Aim
To build a complete CRUD web module using JSP UI, JDBC operations, Spring Boot structure, and MySQL.

### Tools Required
Java 17, Spring Boot, Maven, MySQL, VS Code/IntelliJ.

### Important Concept
- Controller manages routes.
- DAO executes SQL via JDBC.
- JSP provides form/list pages.
- MySQL persists anime records.

### Important Source Code (Key snippets)

```java
public void addAnime(Anime anime) { /* INSERT */ }
public List<Anime> getAllAnime() { /* SELECT */ }
public Anime getAnimeById(Integer animeId) { /* SELECT by id */ }
public void updateAnime(Anime anime) { /* UPDATE */ }
public void deleteAnime(Integer animeId) { /* DELETE */ }
```

```java
@GetMapping("/anime")
public String listAnime(Model model) {
    model.addAttribute("animeList", animeDao.getAllAnime());
    return "anime-list";
}

@PostMapping("/anime/save")
public String saveAnime(@ModelAttribute Anime anime) {
    if (anime.getAnimeId() == null) animeDao.addAnime(anime);
    else animeDao.updateAnime(anime);
    return "redirect:/anime";
}
```

```properties
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
spring.datasource.url=jdbc:mysql://localhost:3306/aniversex_db
spring.datasource.username=root
spring.datasource.password=root
spring.sql.init.mode=always
```

```sql
CREATE TABLE anime (
    anime_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    episodes INT NOT NULL,
    rating DECIMAL(3,1) NOT NULL,
    short_review VARCHAR(500) NOT NULL
);
```

### Important File Names Used
`pom.xml`, `AniVerseXJspJdbcApplication.java`, `Anime.java`, `AnimeDao.java`, `AnimeController.java`, `application.properties`, `schema.sql`, `data.sql`, `index.jsp`, `anime-list.jsp`, `anime-form.jsp`, `style.css`.

### How to Run
1. Create DB: `CREATE DATABASE aniversex_db;`
2. Update MySQL credentials in `application.properties`.
3. Run in terminal:
   - `mvn spring-boot:run`
4. Open: `http://localhost:8080/`.

### Expected Output
Add/View/Edit/Delete operations work and database updates are reflected in JSP list page.

### Output Screenshot
**[Paste Output Screenshot Here]**

### Result
Question 3 completed successfully as final integrated assignment module.

---

## OVERALL RESULT
All 3 questions of Assignment-2 were completed under one theme (**AniVerseX**) and verified using appropriate tools.
