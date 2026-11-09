
<%@ page import="java.util.List" %>
<%@ page import="com.limon.mathwhiz.model.GameScore" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    List<GameScore> scores =
            (List<GameScore>) request.getAttribute("scores");

    if (scores == null) {
        response.sendRedirect("leaderboard");
        return;
    }

    SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd MMM yyyy, hh:mm a");
%>

<%!
    private String escapeHtml(String value) {
        if (value == null) return "";

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Math Whiz - Leaderboard</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="leaderboard-container">

    <div class="leaderboard-card">

        <div class="math-icon">🏆</div>

        <h1>TOP 10 PLAYERS</h1>

        <p class="subtitle">
            Math Whiz Hall of Fame
        </p>

        <% if (scores.isEmpty()) { %>

        <p class="empty-message">
            No scores available yet. Be the first player!
        </p>

        <% } else { %>

        <div class="table-wrapper">

            <table>

                <thead>
                <tr>
                    <th>Rank</th>
                    <th>Player Name</th>
                    <th>Score</th>
                    <th>Difficulty</th>
                    <th>Played At</th>
                </tr>
                </thead>

                <tbody>

                <% for (int i = 0; i < scores.size(); i++) {
                    GameScore score = scores.get(i);
                %>

                <tr>
                    <td>
                        <%= i == 0 ? "🥇" :
                                i == 1 ? "🥈" :
                                        i == 2 ? "🥉" : (i + 1) %>
                    </td>

                    <td>
                        <%= escapeHtml(score.getPlayerName()) %>
                    </td>

                    <td class="score-value">
                        <%= score.getScore() %>/10
                    </td>

                    <td>
                        <%= escapeHtml(score.getDifficulty()) %>
                    </td>

                    <td>
                        <%= score.getPlayedAt() == null
                                ? "N/A"
                                : dateFormat.format(score.getPlayedAt()) %>
                    </td>
                </tr>

                <% } %>

                </tbody>

            </table>

        </div>

        <% } %>

        <a href="index.jsp" class="action-button">
            PLAY GAME
        </a>

    </div>

</div>

</body>
</html>
