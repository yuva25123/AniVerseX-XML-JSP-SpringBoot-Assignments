<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Review List</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>Review List</h1>
    <a class="btn" href="/reviews/new">Add Review</a>
    <a class="btn" href="/">Home</a>

    <table>
        <tr>
            <th>User</th><th>Anime</th><th>Score</th><th>Comment</th><th>Action</th>
        </tr>
        <c:forEach var="review" items="${reviewList}">
            <tr>
                <td>${review.userName}</td>
                <td>${review.anime.title}</td>
                <td>${review.score}</td>
                <td>${review.comment}</td>
                <td>
                    <a href="/reviews/edit/${review.id}">Edit</a> |
                    <a href="/reviews/delete/${review.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
