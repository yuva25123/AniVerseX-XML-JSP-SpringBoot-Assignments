# Experiment 07: XML + Java + JSP
## Mini Project Theme: AniVerseX - Anime Recommendations and Reviews

## 1) Aim
To read anime data from an XML file using Java (DOM parser) and display it in JSP table format.

## 2) Concept: XML + Java + JSP
- XML stores anime data in a structured format.
- Java Servlet reads and parses XML using DOM parser.
- JSP displays parsed data in HTML table.

This combines backend (Java) and frontend (JSP) in a simple web application.

## 3) File Structure
```text
assignment-2/
└── 07-xml-java-jsp/
    ├── index.jsp
    ├── anime-list.jsp
    ├── style.css
    ├── README.md
    ├── src/
    │   └── com/aniversex/xmljsp/
    │       ├── model/Anime.java
    │       └── servlet/AnimeXmlServlet.java
    └── WEB-INF/
        ├── web.xml
        └── data/anime.xml
```

## 4) How It Works
1. User opens `index.jsp`.
2. Clicks "Load Anime Recommendations".
3. Request goes to servlet URL `/anime-list`.
4. `AnimeXmlServlet` reads `WEB-INF/data/anime.xml`.
5. Servlet puts list in request attribute `animeList`.
6. Request forwards to `anime-list.jsp`.
7. JSP loops through list and displays table.

## 5) How to Run in Apache Tomcat
### A) Folder Setup
1. Copy `07-xml-java-jsp` folder into Tomcat `webapps` as app name `07-xml-java-jsp`.
2. Compile Java files and place `.class` files in `WEB-INF/classes`.

### B) Compile Commands (from app root)
Windows PowerShell example:
```bash
mkdir WEB-INF\classes
javac -cp "%CATALINA_HOME%\lib\servlet-api.jar" -d WEB-INF\classes src\com\aniversex\xmljsp\model\Anime.java src\com\aniversex\xmljsp\servlet\AnimeXmlServlet.java
```

### C) Run
1. Start Tomcat.
2. Open:
```text
http://localhost:8080/07-xml-java-jsp/
```
3. Click **Load Anime Recommendations**.

## 6) Run in VS Code + Tomcat
1. Open this folder in VS Code.
2. Use terminal to compile Java source (same command above).
3. Deploy folder to Tomcat `webapps`.
4. Start Tomcat and open the URL.

## 7) Expected Output
A table with 5 anime records and columns:
- animeId
- title
- genre
- episodes
- rating
- shortReview
- recommendationType

## 8) Result
Successfully built a beginner-friendly XML + Java + JSP application where Java reads XML and JSP shows structured anime recommendations in table format.
