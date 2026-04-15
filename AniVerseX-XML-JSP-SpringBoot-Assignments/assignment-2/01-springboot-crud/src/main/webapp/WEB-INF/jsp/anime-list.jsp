<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Anime List</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>Anime List</h1>
    <a class="btn" href="/anime/new">Add Anime</a>
    <a class="btn" href="/">Home</a>

    <table>
        <tr>
            <th>Title</th><th>Genre</th><th>Episodes</th><th>Rating</th><th>Synopsis</th><th>Action</th>
        </tr>
        <c:forEach var="anime" items="${animeList}">
            <tr>
                <td>${anime.title}</td>
                <td>${anime.genre}</td>
                <td>${anime.episodes}</td>
                <td>${anime.rating}</td>
                <td>${anime.synopsis}</td>
                <td>
                    <a href="/anime/edit/${anime.id}">Edit</a> |
                    <a href="/anime/delete/${anime.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
