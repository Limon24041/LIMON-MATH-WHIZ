
<%@ page import="java.util.List" %>
<%@ page import="com.limon.mathwhiz.model.GameQuestion" %>

<%
    String playerName = (String) session.getAttribute("playerName");
    List<GameQuestion> questions =
            (List<GameQuestion>) request.getAttribute("questions");

    if (playerName == null || questions == null) {
        response.sendRedirect("index.jsp");
        return;
    }
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

    <title>Math Whiz - Game</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="game-container">

    <div class="game-card">

        <h1>LIMON - MATH WHIZ</h1>

        <p class="subtitle">
            Welcome, <strong><%= escapeHtml(playerName) %></strong>!
        </p>

        <div class="game-info">
            <span>Difficulty: NORMAL</span>
            <span>Maximum Score: 10</span>
        </div>

        <h2>Mathematical Challenges</h2>

        <form action="submit" method="post">

            <% for (int i = 0; i < questions.size(); i++) {
                GameQuestion q = questions.get(i);
            %>

            <div class="question-box">

                <h3>Question <%= i + 1 %></h3>

                <p><%= escapeHtml(q.getQuestion()) %></p>

                <input
                        type="number"
                        name="answer<%= i + 1 %>"
                        step="any"
                        placeholder="Enter your answer"
                        required
                >

                <span class="marks">
                        Marks: <%= q.getMarks() %>
                    </span>

            </div>

            <% } %>

            <button type="submit">
                SUBMIT ANSWERS
            </button>

        </form>

        <p class="footer">
            Think Carefully! Good Luck!
        </p>

    </div>

</div>

</body>
</html>
