
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String playerName = (String) request.getAttribute("playerName");
    Integer totalScore = (Integer) request.getAttribute("totalScore");
    String[] results = (String[]) request.getAttribute("results");
    Boolean saved = (Boolean) request.getAttribute("saved");

    if (playerName == null || totalScore == null || results == null) {
        response.sendRedirect("index.jsp");
        return;
    }

    String safeName = playerName.replace("&", "&amp;")
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("\"", "&quot;")
            .replace("'", "&#39;");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Math Whiz - Result</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="result-container">

    <div class="result-card">

        <div class="math-icon">🏆</div>

        <h1>GAME COMPLETED!</h1>

        <p class="subtitle">
            Congratulations, <strong><%= safeName %></strong>!
        </p>

        <div class="score-circle">

            <h2><%= totalScore %>/10</h2>

            <p>Your Final Score</p>

        </div>

        <h2>Answer Summary</h2>

        <div class="answer-summary">

            <% for (int i = 0; i < results.length; i++) { %>

            <div class="answer-row">

                <span>Question <%= i + 1 %></span>

                <strong class="<%= results[i].equals("Correct") ? "correct" : "incorrect" %>">
                    <%= results[i] %>
                </strong>

            </div>

            <% } %>

        </div>

        <% if (Boolean.TRUE.equals(saved)) { %>

        <p class="success-message">
            Your score has been saved successfully!
        </p>

        <% } else { %>

        <p class="error-message">
            Your score could not be saved to the database.
        </p>

        <% } %>

        <a href="index.jsp" class="action-button">
            PLAY AGAIN
        </a>

        <a href="leaderboard" class="secondary-button">
            VIEW LEADERBOARD
        </a>

    </div>

</div>

</body>
</html>
