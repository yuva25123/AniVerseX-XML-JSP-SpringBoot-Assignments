<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>AniVerseX Review Form (JSP)</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Submit Anime Review</h1>

    <%-- This form is demonstration only (no backend storage in JSP assignment) --%>
    <form class="card">
        <label>User Name</label>
        <input type="text" placeholder="Enter your name" required>

        <label>Select Anime</label>
        <select required>
            <option>Naruto</option>
            <option>Attack on Titan</option>
            <option>Demon Slayer</option>
        </select>

        <label>Score (1 to 10)</label>
        <input type="number" min="1" max="10" required>

        <label>Comment</label>
        <textarea rows="4" placeholder="Write your review" required></textarea>

        <br><br>
        <button class="btn" type="submit">Submit</button>
        <a class="btn" href="index.jsp">Back</a>
    </form>
</div>
</body>
</html>
