<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Review List</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>Anime Reviews</h1>

    <div class="button-row">
        <a class="btn" href="/reviews/new">Add Review</a>
        <a class="btn secondary" href="/">Home</a>
    </div>

    <table>
        <thead>
        <tr>
            <th>User</th>
            <th>Anime</th>
            <th>Score</th>
            <th>Comment</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="review" items="${reviewList}">
            <tr>
                <td>${review.userName}</td>
                <td>${review.anime.title}</td>
                <td>${review.score}</td>
                <td>${review.comment}</td>
                <td>
                    <a href="/reviews/edit/${review.id}">Edit</a> |
                    <a href="/reviews/delete/${review.id}" onclick="return confirm('Delete this review?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
