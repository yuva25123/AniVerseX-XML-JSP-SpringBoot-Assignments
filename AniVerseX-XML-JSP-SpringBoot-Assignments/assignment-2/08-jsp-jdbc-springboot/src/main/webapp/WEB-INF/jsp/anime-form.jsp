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
        <!-- Hidden id is used for update -->
        <input type="hidden" name="animeId" value="${anime.animeId}">

        <label>Title</label>
        <input type="text" name="title" value="${anime.title}" required>

        <label>Genre</label>
        <input type="text" name="genre" value="${anime.genre}" required>

        <label>Episodes</label>
        <input type="number" name="episodes" min="1" value="${anime.episodes}" required>

        <label>Rating (0 to 10)</label>
        <input type="number" step="0.1" min="0" max="10" name="rating" value="${anime.rating}" required>

        <label>Short Review</label>
        <textarea name="shortReview" rows="4" required>${anime.shortReview}</textarea>

        <div class="button-row">
            <button class="btn" type="submit">Save</button>
            <a class="btn secondary" href="/anime">Back</a>
        </div>
    </form>
</div>
</body>
</html>
