<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>AniVerseX Anime List (JSP)</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h1>Anime Recommendations</h1>
    <table>
        <tr>
            <th>Title</th>
            <th>Genre</th>
            <th>Episodes</th>
            <th>Rating</th>
        </tr>
        <%-- Static sample data for beginner lab assignment --%>
        <tr>
            <td>Naruto</td>
            <td>Action, Adventure</td>
            <td>220</td>
            <td>8.3</td>
        </tr>
        <tr>
            <td>Attack on Titan</td>
            <td>Action, Dark Fantasy</td>
            <td>89</td>
            <td>9.1</td>
        </tr>
        <tr>
            <td>Demon Slayer</td>
            <td>Action, Supernatural</td>
            <td>55</td>
            <td>8.7</td>
        </tr>
    </table>
    <br>
    <a class="btn" href="index.jsp">Back</a>
</div>
</body>
</html>
