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
        <!-- Hidden id for update operation -->
        <input type="hidden" name="id" value="${anime.id}">

        <label>Title</label>
        <input type="text" name="title" value="${anime.title}" required>

        <label>Genre</label>
        <input type="text" name="genre" value="${anime.genre}" required>

        <label>Episodes</label>
        <input type="number" name="episodes" value="${anime.episodes}" required>

        <label>Rating</label>
        <input type="number" step="0.1" name="rating" value="${anime.rating}" required>

        <label>Synopsis</label>
        <textarea name="synopsis" rows="4" required>${anime.synopsis}</textarea>

        <button class="btn" type="submit">Save</button>
        <a class="btn" href="/anime">Back</a>
    </form>
</div>
</body>
</html>
