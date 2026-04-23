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

    <form action="/anime/save" method="post" class="card">
        <!-- Hidden ID is used while editing existing record -->
        <input type="hidden" name="id" value="${anime.id}">

        <label>Title</label>
        <input type="text" name="title" value="${anime.title}" required>

        <label>Genre</label>
        <input type="text" name="genre" value="${anime.genre}" required>

        <label>Episodes</label>
        <input type="number" name="episodes" value="${anime.episodes}" required>

        <label>Rating (0 to 10)</label>
        <input type="number" step="0.1" min="0" max="10" name="rating" value="${anime.rating}" required>

        <label>Synopsis</label>
        <textarea name="synopsis" rows="4" required>${anime.synopsis}</textarea>

        <div class="button-row">
            <button class="btn" type="submit">Save</button>
            <a class="btn secondary" href="/anime">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
