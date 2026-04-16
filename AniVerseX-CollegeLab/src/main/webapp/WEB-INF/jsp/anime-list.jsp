<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Anime List</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>Anime Recommendations</h1>

    <div class="button-row">
        <a class="btn" href="/anime/new">Add Anime</a>
        <a class="btn secondary" href="/">Home</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Genre</th>
            <th>Episodes</th>
            <th>Rating</th>
            <th>Synopsis</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="anime" items="${animeList}">
            <tr>
                <td>${anime.title}</td>
                <td>${anime.genre}</td>
                <td>${anime.episodes}</td>
                <td>${anime.rating}</td>
                <td>${anime.synopsis}</td>
                <td>
                    <a href="/anime/edit/${anime.id}">Edit</a> |
                    <a href="/anime/delete/${anime.id}" onclick="return confirm('Delete this anime?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
