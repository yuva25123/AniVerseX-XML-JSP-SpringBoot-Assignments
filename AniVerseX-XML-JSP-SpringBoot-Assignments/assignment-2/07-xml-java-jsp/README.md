# 07 - XML + Java + JSP

## Aim
Read anime data from `anime.xml` using Java Servlet (DOM parser) and display it in JSP table format.

## Files
- `anime.xml` - source XML data
- `src/com/aniversex/xmljsp/Anime.java` - model class
- `src/com/aniversex/xmljsp/AnimeXmlReaderServlet.java` - reads XML and sends data to JSP
- `index.jsp` - home page
- `anime-list.jsp` - displays anime table
- `style.css` - simple UI style
- `WEB-INF/web.xml` - servlet mapping and welcome page

## Run (Apache Tomcat 10)
1. Compile Java files into `WEB-INF/classes`.
2. Copy folder into Tomcat `webapps`.
3. Start Tomcat and open app URL.
