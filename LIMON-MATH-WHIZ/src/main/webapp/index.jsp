
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LIMON - MATH WHIZ</title>

    <link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="welcome-container">

    <div class="welcome-card">

        <div class="math-icon">🧠</div>

        <h1>LIMON - MATH WHIZ</h1>

        <p class="subtitle">
            Challenge Your Brain with Mathematics!
        </p>

        <form action="game" method="post">

            <label for="playerName">Enter Your Name</label>

            <input
                    type="text"
                    id="playerName"
                    name="playerName"
                    placeholder="Your name here..."
                    maxlength="100"
                    required
            >

            <button type="submit">
                START GAME
            </button>

        </form>

        <p class="difficulty">
            Difficulty Level: NORMAL
        </p>

        <p class="footer">
            Maximum Score: 10 Points
        </p>

    </div>

</div>

</body>
</html>
