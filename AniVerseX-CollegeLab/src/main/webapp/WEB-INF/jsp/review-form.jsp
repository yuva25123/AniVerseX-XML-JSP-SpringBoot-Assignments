<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>${formTitle}</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
    <h1>${formTitle}</h1>

    <form action="/reviews/save" method="post" class="card">
        <!-- Hidden ID is used while editing existing review -->
        <input type="hidden" name="id" value="${review.id}">

        <label>User Name</label>
        <input type="text" name="userName" value="${review.userName}" required>

        <label>Anime</label>
        <select name="anime.id" required>
            <option value="">Select Anime</option>
            <c:forEach var="anime" items="${animeList}">
                <option value="${anime.id}" ${review.anime != null && review.anime.id == anime.id ? 'selected' : ''}>
                    ${anime.title}
                </option>
            </c:forEach>
        </select>

        <label>Score (1 to 10)</label>
        <input type="number" min="1" max="10" name="score" value="${review.score}" required>

        <label>Comment</label>
        <textarea name="comment" rows="4" required>${review.comment}</textarea>

        <div class="button-row">
            <button class="btn" type="submit">Save</button>
            <a class="btn secondary" href="/reviews">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
