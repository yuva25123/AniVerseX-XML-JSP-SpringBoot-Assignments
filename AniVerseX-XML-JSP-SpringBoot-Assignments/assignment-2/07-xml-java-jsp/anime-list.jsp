<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aniversex.xmljsp.Anime" %>
<!DOCTYPE html>
<html>
<head>
    <title>AniVerseX Anime List (JSP)</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Anime Recommendations (From XML)</h1>
    <table>
        <tr>
            <th>Anime ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Episodes</th>
            <th>Rating</th>
            <th>Short Review</th>
            <th>Recommendation Type</th>
        </tr>
        <%
            List<Anime> animeList = (List<Anime>) request.getAttribute("animeList");
            if (animeList != null && !animeList.isEmpty()) {
                for (Anime anime : animeList) {
        %>
        <tr>
            <td><%= anime.getAnimeId() %></td>
            <td><%= anime.getTitle() %></td>
            <td><%= anime.getGenre() %></td>
            <td><%= anime.getEpisodes() %></td>
            <td><%= anime.getRating() %></td>
            <td><%= anime.getShortReview() %></td>
            <td><%= anime.getRecommendationType() %></td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="7">No anime data found. Click "Load Anime XML Data" from home page.</td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a class="btn" href="index.jsp">Back</a>
</div>
</body>
</html>
