<%@ page import="java.util.List" %>
<%@ page import="com.aniversex.xmljsp.model.Anime" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AniVerseX Anime List</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Anime Recommendations</h1>

    <%
        String errorMessage = (String) request.getAttribute("errorMessage");
        List<Anime> animeList = (List<Anime>) request.getAttribute("animeList");
    %>

    <% if (errorMessage != null) { %>
        <div class="error"><%= errorMessage %></div>
    <% } else if (animeList == null || animeList.isEmpty()) { %>
        <div class="error">No anime records found.</div>
    <% } else { %>
        <table>
            <thead>
            <tr>
                <th>Anime ID</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Episodes</th>
                <th>Rating</th>
                <th>Short Review</th>
                <th>Recommendation Type</th>
            </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>
    <% } %>

    <div class="button-row">
        <a class="btn secondary" href="index.jsp">Back</a>
    </div>
</div>
</body>
</html>
