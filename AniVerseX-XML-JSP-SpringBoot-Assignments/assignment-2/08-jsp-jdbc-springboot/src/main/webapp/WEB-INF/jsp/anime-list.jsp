<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>AniVerseX - Anime List</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>Anime List</h1>

    <div class="button-row">
        <a class="btn" href="/anime/add">Add Anime</a>
        <a class="btn secondary" href="/">Home</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>Anime ID</th>
            <th>Title</th>
            <th>Genre</th>
            <th>Episodes</th>
            <th>Rating</th>
            <th>Short Review</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="anime" items="${animeList}">
            <tr>
                <td>${anime.animeId}</td>
                <td>${anime.title}</td>
                <td>${anime.genre}</td>
                <td>${anime.episodes}</td>
                <td>${anime.rating}</td>
                <td>${anime.shortReview}</td>
                <td>
                    <a href="/anime/edit/${anime.animeId}">Edit</a> |
                    <a href="/anime/delete/${anime.animeId}" onclick="return confirm('Delete this anime record?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
